package com.example.energizeme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ExerciseMockup exerciseMockup;
    private String exerciseSelected = "";
    private ListView eList;
    List<String> Etypes;
    String userGender;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.Etypes);
        exerciseMockup = new ExerciseMockup();
        eList = findViewById(R.id.eList);

        Intent intent = getIntent();
        userName = (String) intent.getExtras().get("userName");
        userGender = (String) intent.getExtras().get("userGender");

        Toast.makeText(MainActivity.this, "Welcome " + userName + "!", Toast.LENGTH_SHORT).show();

        bindSpinner();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                exerciseSelected = spinner.getSelectedItem().toString();
                bindListview(exerciseSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optional: Handle case when no item is selected, if necessary
            }
        });

        bindListview(Etypes.get(0));
        eList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent eSelectedIntent = new Intent(getApplicationContext(), ExerciseSelectedActivity.class);
                eSelectedIntent.putExtra("exercise_index", (int)id);
                eSelectedIntent.putExtra("exercise_type", exerciseSelected);
                eSelectedIntent.putExtra("Ugender", userGender);
                startActivity(eSelectedIntent);
            }
        });
    }

    private void bindSpinner() {
        Etypes = exerciseMockup.getExerciseTypes();
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Etypes);
        spinner.setAdapter(spnAdapter);
    }

    private void bindListview(String type) {
        List<String> Etypes = exerciseMockup.getItemsStr(type);
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Etypes);
        eList.setAdapter(spnAdapter);
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