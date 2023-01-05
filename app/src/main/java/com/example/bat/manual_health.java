package com.example.bat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class manual_health extends AppCompatActivity {

    TextView hl_txtDate,hl_txtTime;
    Button hl_btnDate, hl_btnTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_health);

        hl_txtDate = (TextView) findViewById(R.id.hl_when);
        hl_txtTime = (TextView) findViewById(R.id.hl_time);
        hl_btnDate = (Button) findViewById(R.id.hl_sub_date);
        hl_btnTime = (Button) findViewById(R.id.hl_sub_time);



        hl_btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });

        hl_btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });

    }

    private void setDate(){

        Calendar calendar= Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH);
        int date= calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                String showDate = i2+" /"+(i1+1)+" /"+i;
                hl_txtDate.setText(showDate);

            }
        },year, month, date);

        datePickerDialog.show();

    }

    private void setTime(){

        Calendar calendar= Calendar.getInstance();
        int hour= calendar.get(Calendar.HOUR);
        int min= calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                String showTime = hr+" :"+ min;
                hl_txtTime.setText(showTime);

            }
        }, hour, min, true);
        timePickerDialog.show();





    }


}


