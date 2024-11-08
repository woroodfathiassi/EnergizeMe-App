//package com.example.energizeme;
//
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.io.File;
//import java.util.Objects;
//
//public class ExerciseSelectedActivity extends AppCompatActivity {
//
//    private ExerciseMockup exerciseMockup;
//    private TextView Ename;
//    private ImageView Eimage;
//    private TextView Edescription;
//    private TextView timer;
//    private int sec = 20;
//    private Handler handler = new Handler();
//    private MediaPlayer mediaPlayer;
//
//    private int playbackAudio = 0;
//    private boolean isRunning = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_exercise_selected);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        exerciseMockup = new ExerciseMockup();
//        Ename = findViewById(R.id.Ename);
//        Eimage = findViewById(R.id.Eimage);
//        timer = findViewById(R.id.timer);
//        Edescription = findViewById(R.id.Edescription);
//
//        Intent intent = getIntent();
//        int exerciseIndex = (int) intent.getExtras().get("exercise_index");
//        String eType = (String) intent.getExtras().get("exercise_type");
//        String uGender = (String) intent.getExtras().get("Ugender");
//
//        Exercise e = exerciseMockup.getExercise(eType, exerciseIndex);
//        Ename.setText(e.getName());
//        Eimage.setImageResource(Objects.equals(uGender, "Male") ? e.getImage() : e.getGimage());
//        Edescription.setText(e.getDescription());
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
//        mediaPlayer.seekTo(playbackAudio);
//        mediaPlayer.start();
//
//        if (savedInstanceState != null) {
//            sec = savedInstanceState.getInt("timerValue");
//        }
//
//        handler.postDelayed(this::startCountdown, 3000);
//    }
//
//    private void startCountdown() {
//        isRunning = true;
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if (sec < 0) {
//                    isRunning = false;
//                    handler.postDelayed(() -> finish(), 5000);
//                } else {
//                    timer.setText("⏳" + sec);
//                    sec--;
//                    handler.postDelayed(this, 1000);
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        // Save the current timer value
//        outState.putInt("timerValue", sec);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Save the current position
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            playbackAudio = mediaPlayer.getCurrentPosition();
//            mediaPlayer.pause();
//        }
//        handler.removeCallbacksAndMessages(null);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Seek to the last position
//        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
//            mediaPlayer.seekTo(playbackAudio);
//            mediaPlayer.start();
//        }
//
////        if (!isRunning) {
////            startCountdown();
////        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // stop the audio
//        if (mediaPlayer != null) {
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//
//        // stop the timer
//        handler.removeCallbacksAndMessages(null);
//    }
//}



package com.example.energizeme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ExerciseSelectedActivity extends AppCompatActivity {

    private ExerciseMockup exerciseMockup;
    private TextView Ename;
    private ImageView Eimage;
    private TextView Edescription;
    private TextView timer;
    private int sec = 20;
    private Handler handler = new Handler();

    private long endTime;
    private boolean isRunning = false;
    private int playbackAudio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_selected);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        exerciseMockup = new ExerciseMockup();
        Ename = findViewById(R.id.Ename);
        Eimage = findViewById(R.id.Eimage);
        timer = findViewById(R.id.timer);
        Edescription = findViewById(R.id.Edescription);

        Intent intent = getIntent();
        int exerciseIndex = intent.getIntExtra("exercise_index", 0);
        String eType = intent.getStringExtra("exercise_type");
        String uGender = intent.getStringExtra("Ugender");

        Exercise e = exerciseMockup.getExercise(eType, exerciseIndex);
        Ename.setText(e.getName());
        Eimage.setImageResource(Objects.equals(uGender, "Male") ? e.getImage() : e.getGimage());
        Edescription.setText(e.getDescription());

        if (savedInstanceState != null) {
            sec = savedInstanceState.getInt("timerValue", 20);
        }

        startCountdown();
    }

    private void startCountdown() {
        endTime = System.currentTimeMillis() + (sec * 1000); // Calculate end time
        isRunning = true;
        updateCountdown();
    }

    private void updateCountdown() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!isRunning) return; // Stop if timer has been canceled

                long remainingTime = endTime - System.currentTimeMillis();
                if (remainingTime <= 0) {
                    timer.setText("⏳0"); // Set to 0 when finished
                    isRunning = false;
                    handler.postDelayed(() -> finish(), 5000);
                } else {
                    sec = (int) (remainingTime / 1000);
                    timer.setText("⏳" + sec);
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("timerValue", sec);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isRunning) {
            startCountdown();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}