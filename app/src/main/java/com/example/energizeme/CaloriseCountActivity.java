package com.example.energizeme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CaloriseCountActivity extends AppCompatActivity {

    private EditText meal;
    private EditText calories;
    private Button add;
    private Button calculate;
    private TableLayout tableLayout;

    String userGender;
    String userName;

    Map<String, EditText> inputs;
    Map<String, TextView> errors;

    private String KEY_TABLE_MEAL = "mealList";
    private String KEY_TABLE_CALORIES = "caloriesList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calorise_count);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        userName = (String) intent.getExtras().get("userName");
        userGender = (String) intent.getExtras().get("userGender");

        Toast.makeText(CaloriseCountActivity.this, "Welcome " + userName + "!", Toast.LENGTH_SHORT).show();

        add = findViewById(R.id.butAdd);
        calculate = findViewById(R.id.butCalculate);
        tableLayout = findViewById(R.id.tableLayout);

        if (savedInstanceState != null) {
            ArrayList<String> savedMeals = savedInstanceState.getStringArrayList(KEY_TABLE_MEAL);
            ArrayList<String> savedCalories = savedInstanceState.getStringArrayList(KEY_TABLE_CALORIES);
            if (savedMeals != null && savedCalories != null) {
                restoreTableData(savedMeals, savedCalories);
            }
        }

        inputs = new HashMap<>();
        inputs.put("meal", findViewById(R.id.ETmeal));
        inputs.put("calories", findViewById(R.id.ETcalories));

        errors = new HashMap<>();
        errors.put("meal", findViewById(R.id.Emeal));
        errors.put("calories", findViewById(R.id.Ecalories));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTable();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tableLayout.getChildCount() <= 1) {
                    Toast.makeText(CaloriseCountActivity.this, "The table is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), CaloriseResuleActivity.class);
                    double tot = totalCalorise();
                    intent.putExtra("totalCalorise", tot);
                    intent.putExtra("Uname", userName);
                    intent.putExtra("Ugender", userGender);
                    startActivity(intent);
                }
            }
        });
    }

    private void addToTable() {
        String mealValue = inputs.get("meal").getText().toString();
        String caloriesValue = inputs.get("calories").getText().toString();

        boolean valid = true;
        if(mealValue.isEmpty()){
            errors.get("meal").setText("* Meal is requered.");
            valid = false;
        }else{
            errors.get("meal").setText("");
        }
        if(caloriesValue.isEmpty()){
            errors.get("calories").setText("* Calories is requered.");
            valid = false;
        }else{
            errors.get("calories").setText("");
        }

        if (valid) {
            // Create a new TableRow
            TableRow row = new TableRow(this);
            row.setPadding(8, 8, 8, 8);

            // Create TextViews for each piece of data
            TextView mealTV = new TextView(this);
            mealTV.setText(inputs.get("meal").getText());
            mealTV.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            row.addView(mealTV);

            TextView caloriesTV = new TextView(this);
            caloriesTV.setText(inputs.get("calories").getText());
            caloriesTV.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            row.addView(caloriesTV);

            // Add the row to the TableLayout
            tableLayout.addView(row);

            // Clear the EditTexts for new input
            inputs.get("meal").setText("");
            inputs.get("calories").setText("");
        }
    }

    private double totalCalorise(){
        double total = 0;
        for (int i = 1; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);

            TextView caloriesTV = (TextView) row.getChildAt(1);
            String caloriesText = caloriesTV.getText().toString();
            if (!caloriesText.isEmpty()) {
                double calories = Double.parseDouble(caloriesText);
                total += calories;
            }

        }
        return total;
    }

    private void restoreTableData(@NonNull ArrayList<String> meals, ArrayList<String> calories) {
        // delete all rows but head one no
        tableLayout.removeViews(1, tableLayout.getChildCount() - 1);

        for (int i = 0; i < meals.size(); i++) {
            String mealValue = meals.get(i);
            String caloriesValue = calories.get(i);

            TableRow row = new TableRow(this);
            row.setPadding(8, 8, 8, 8);

            TextView mealTV = new TextView(this);
            mealTV.setText(mealValue);
            mealTV.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            row.addView(mealTV);

            TextView caloriesTV = new TextView(this);
            caloriesTV.setText(caloriesValue);
            caloriesTV.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            row.addView(caloriesTV);

            tableLayout.addView(row);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<String> mealList = new ArrayList<>();
        ArrayList<String> caloriesList = new ArrayList<>();

        // Start from 1 to skip the header row
        for (int i = 1; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);

            TextView mealTV = (TextView) row.getChildAt(0);
            TextView caloriesTV = (TextView) row.getChildAt(1);

            mealList.add(mealTV.getText().toString());
            caloriesList.add(caloriesTV.getText().toString());
        }

        outState.putStringArrayList(KEY_TABLE_MEAL, mealList);
        outState.putStringArrayList(KEY_TABLE_CALORIES, caloriesList);
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
        Log.d("welcome!", "Hello from onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("welcome!", "Hello from onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tableLayout.removeAllViews();
    }
}