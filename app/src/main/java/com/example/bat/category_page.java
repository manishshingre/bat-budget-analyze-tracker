package com.example.bat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class category_page extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page);

        final DrawerLayout drawable1 = findViewById(R.id.drawlayout);

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
        MenuItem categories_act = navigationView.getMenu().findItem(R.id.menuCategories);

        history.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intenthis = new Intent(category_page.this,HistoryPage.class);
                startActivity(intenthis);
                return true;
            }
        });

        categories_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentcat = new Intent(category_page.this,category_page.class);
                startActivity(intentcat);
                return true;
            }
        });

        profile_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentprof = new Intent(category_page.this,Profile.class);
                startActivity(intentprof);
                return true;
            }
        });

        reports_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentrep = new Intent(category_page.this,Reports.class);
                startActivity(intentrep);
                return true;
            }
        });

        home_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intenth = new Intent(category_page.this,HomePage.class);
                startActivity(intenth);
                return true;
            }
        });
    }
}


