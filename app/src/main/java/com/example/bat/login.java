package com.example.bat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private Button btn1;
    TextView sgnup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1=(Button) findViewById(R.id.logbtn);
        sgnup=(TextView) findViewById(R.id.sign);

        btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(login.this,HomePage.class);
            startActivity(intent1);
        });

        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(login.this,signup.class);
                startActivity(intent2);
            }
        });
    }


}