package com.example.bat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {

//    Python py = Python.getInstance();
//    final PyObject pyobj = py.getModule("//PYTHON KA FILE NAME");

    //PROJECT FOLDER ME SRC/MAIN/PYTHON YEH PATH PE PYTHON KA SCRIPT



    ImageButton capImgBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final DrawerLayout drawable1 = findViewById(R.id.drawlayout);
        capImgBtn = findViewById(R.id.capimg);

        findViewById(R.id.imgmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable1.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.naviview);
        navigationView.setItemIconTintList(null);

        MenuItem history = navigationView.getMenu().findItem(R.id.menuHistory);
        MenuItem profile_act = navigationView.getMenu().findItem(R.id.menuProfile);
        MenuItem reports_act = navigationView.getMenu().findItem(R.id.menuReports);
        MenuItem home_act = navigationView.getMenu().findItem(R.id.menuHome);


        history.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intenthis = new Intent(HomePage.this,category_page.class);
                startActivity(intenthis);
                return true;
            }
        });

        profile_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentprof = new Intent(HomePage.this,Profile.class);
                startActivity(intentprof);
                return true;
            }
        });

        reports_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentrep = new Intent(HomePage.this,Reports.class);
                startActivity(intentrep);
                return true;
            }
        });

        home_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intenth = new Intent(HomePage.this,HomePage.class);
                startActivity(intenth);
                return true;
            }
        });

        capImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcapimg = new Intent(HomePage.this, captureImage.class);
                startActivity(intentcapimg);
            }
        });
    }
}