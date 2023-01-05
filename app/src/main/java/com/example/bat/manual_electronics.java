package com.example.bat;

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

public class manual_electronics extends AppCompatActivity {

    TextView el_txtDate,el_txtTime;
    Button el_btnDate, el_btnTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_electronics);

        el_txtDate = (TextView) findViewById(R.id.el_when);
        el_txtTime = (TextView) findViewById(R.id.el_time);
        el_btnDate = (Button) findViewById(R.id.el_sub_date);
        el_btnTime = (Button) findViewById(R.id.el_sub_time);



        el_btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });

        el_btnDate.setOnClickListener(new View.OnClickListener() {
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
                el_txtDate.setText(showDate);

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
                el_txtTime.setText(showTime);

            }
        }, hour, min, true);
        timePickerDialog.show();





    }


}


