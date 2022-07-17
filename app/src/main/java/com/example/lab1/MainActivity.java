package com.example.lab1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this::OnClickCalculateAge);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void OnClickCalculateAge(View view) {




        //Get the string from the Edit Text object
        EditText BirthdayEditText = findViewById(R.id.BirthdayTextDate);
        String BirthdayString = BirthdayEditText.getText().toString();

        //figure out today's date
        LocalDate today = LocalDate.now();

        // Parse date from the date entry
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate birthday;
        try {
            birthday = LocalDate.parse(BirthdayString, formatter);
        } catch (Exception e) {
            TextView happyBirthdayTextView = findViewById(R.id.happyBirthdayTextView);
            happyBirthdayTextView.setText("m/d/yyyy");
            return;
        }

        Period p = Period.between(birthday, today);
        int days = p.getDays();
        int months = p.getMonths();
        int years = p.getYears();

        TextView yearsView = findViewById(R.id.yearsTextView);
        TextView monthsView = findViewById(R.id.monthsTextView);
        TextView daysView = findViewById(R.id.daysTextView);
        yearsView.setText(String.valueOf(years));
        monthsView.setText(String.valueOf(months));
        daysView.setText(String.valueOf(days));


        TextView happyBirthdayTextView = findViewById(R.id.happyBirthdayTextView);
        if (months == 0 && days == 0){
            happyBirthdayTextView.setText(getString(R.string.happy_birthday));
        } else {
            happyBirthdayTextView.setText("");
        }
    }
}