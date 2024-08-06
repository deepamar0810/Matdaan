package com.example20.matdaan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends Activity {
    ImageView logo;
    TextView logoText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo=(ImageView)findViewById(R.id.logo);
        logo.setImageResource(R.drawable.m_logo_icon);

        logoText=(TextView)findViewById(R.id.logoText);



        logoText.setText("Matdaan");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent iHome = new Intent(SplashScreen.this,UserLoginPage.class);
                startActivity(iHome);
                finish();
            }
        },4000);

    }
}