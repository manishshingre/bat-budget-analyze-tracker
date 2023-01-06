package com.example.bat;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class HomePage extends AppCompatActivity {
//    final PyObject pyobj = py.getModule("//PYTHON KA FILE NAME");
//
    //PROJECT FOLDER ME SRC/MAIN/PYTHON YEH PATH PE PYTHON KA SCRIPT

    ImageButton capImgBtn;
    TextView img_textview;
    ActivityResultLauncher<Intent> activityResultLauncher;

    Python python = Python.getInstance();
    PyObject pyobj = python.getModule("eocr");
    PyObject obj = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        
        final DrawerLayout drawable1 = findViewById(R.id.drawlayout);
        capImgBtn = findViewById(R.id.capimg);
        img_textview = findViewById(R.id.img_text);

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
                Intent intenthis = new Intent(HomePage.this,HistoryPage.class);
                startActivity(intenthis);
                return true;
            }
        });

        categories_act.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intentcat = new Intent(HomePage.this,category_page.class);
                startActivity(intentcat);
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
                Intent capimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(capimg);
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onActivityResult(ActivityResult result) {
                Bundle extras = result.getData().getExtras();
                Uri imageUri;
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                WeakReference<Bitmap> result1 = new WeakReference<>(Bitmap.createScaledBitmap(
                        imageBitmap,imageBitmap.getHeight(), imageBitmap.getWidth(), false).copy(
                                Bitmap.Config.RGB_565, true)
                );

                Bitmap bm = result1.get();
                imageUri = saveImage(bm,HomePage.this);

                obj = pyobj.callAttr("main", imageUri.toString());
                img_textview.setText(obj.toString());


//                img_textview.setText(""+imageUri);

            }
        });


    }

    private Uri saveImage(Bitmap image, Context context) {
        File imagesFolder = new File(context.getCacheDir(),"images");
        Uri uri = null;
        try{
            imagesFolder.mkdirs();
            File file = new File(imagesFolder,"captured_image.jpg");
            FileOutputStream stream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG,100,stream);
            stream.flush();
            stream.close();
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.example.bat"+".provider", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uri;

    }
}