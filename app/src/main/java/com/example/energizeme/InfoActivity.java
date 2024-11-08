package com.example.energizeme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoActivity extends AppCompatActivity {

    private Button start;
    private EditText userName;
    private TextView Ename;
    private TextView Egender;
    private RadioGroup radioGroup;
    private Button calCalorise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        start = findViewById(R.id.start);
        userName = findViewById(R.id.ETuserName);
        radioGroup = findViewById(R.id.radioGroup);
        Ename = findViewById(R.id.Ename);
        Egender = findViewById(R.id.Egender);
        calCalorise = findViewById(R.id.calCalorise);

        start.setOnClickListener(v -> navigateActivities(MainActivity.class));
        calCalorise.setOnClickListener(v -> navigateActivities(CaloriseCountActivity.class));

    }

    private void navigateActivities(Class<?> targetActivity){
        boolean flage = true;
        if(userName.getText().toString().trim().isEmpty()){
            Ename.setText("* User name is required");
            flage = false;
        }else{
            Ename.setText("");
        }

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            Egender.setText("");
        } else {
            flage = false;
            Egender.setText("* User gender is required");
        }

        if(flage){
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedGender = selectedRadioButton.getText().toString();
            String enteredName = userName.getText().toString().trim();

            Intent intent = new Intent(getApplicationContext(), targetActivity);
            intent.putExtra("userName", enteredName);
            intent.putExtra("userGender", selectedGender);
            startActivity(intent);
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