package com.example.bat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class HomePage extends AppCompatActivity {

    Python py = Python.getInstance();
    final PyObject pyobj = py.getModule("//PYTHON KA FILE NAME");

    //PROJECT FOLDER ME SRC/MAIN/PYTHON YEH PATH PE PYTHON KA SCRIPT






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final DrawerLayout drawable1 = findViewById(R.id.drawlayout);

        findViewById(R.id.imgmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable1.openDrawer(GravityCompat.START);
            }
        });
    }
}