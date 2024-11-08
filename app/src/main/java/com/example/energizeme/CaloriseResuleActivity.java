package com.example.energizeme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CaloriseResuleActivity extends AppCompatActivity {

    private int MALE_CALORISES = 2300;
    private int FEMALE_CALORISES = 2000;
    private String name;
    private String gender;
    private double totalCal;

    private TextView resultText;
    private TextView resultNumber;
    private TextView text1;
    private ImageView resultImage;
    private ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calorise_resule);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        name = (String) intent.getExtras().get("Uname");
        gender = (String) intent.getExtras().get("Ugender");
        totalCal = (double) intent.getExtras().get("totalCalorise");

        resultText = findViewById(R.id.resultText);
        resultNumber = findViewById(R.id.resultNumber);
        text1 = findViewById(R.id.text1);
        resultImage = findViewById(R.id.resultImage);
        image1 = findViewById(R.id.image1);

        if(gender.equals("Male")){
            showResule(MALE_CALORISES);
        }else{
            showResule(FEMALE_CALORISES);
        }
    }

    private void showResule(int cal){
        resultNumber.setText("Your calorise count: "+ totalCal);
        if(totalCal < cal){
            resultText.setText("Great job today! You kept my calories under the limit\uD83D\uDD25 .");
            resultImage.setImageResource(R.drawable.less);
            text1.setText("Now you can eat a Burger as an encouragement for you 😉!");
            image1.setImageResource(R.drawable.burger);
        }else{
            resultText.setText("Unfortunately, you exceeded your calorie limit\uD83E\uDD7A.");
            resultImage.setImageResource(R.drawable.more);
            text1.setText("Now, it's time to exercise! \uD83D\uDCAA!");
            image1.setImageResource(R.drawable.noburger);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("welcome!", "Hello from onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}