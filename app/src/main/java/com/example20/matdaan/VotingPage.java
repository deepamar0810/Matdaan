package com.example20.matdaan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Modifier;
import java.nio.file.WatchEvent;

public class VotingPage extends Activity {

    SQLiteDatabase db;
    Long login;
    String pass;
    Button party1Btn, party2Btn, party3Btn;
    Vibrator vibrator;
    String vibrator_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);



        idFind();
        db=openOrCreateDatabase("VotersData.sql",MODE_PRIVATE,null);
        Bundle bundle=getIntent().getExtras();
        login=bundle.getLong("login");
         pass=bundle.getString("pass");
         //Vibrator  services
        vibrator_service= Context.VIBRATOR_SERVICE;
       vibrator=(Vibrator)getSystemService(vibrator_service);



        giveVote();


    }
    public void nextActivity()
    {
        Intent i =new Intent(VotingPage.this,UserLoginPage.class);
        startActivity(i);
        Toast.makeText(VotingPage.this,"Thanks for Voting",Toast.LENGTH_LONG).show();
        finish();
    }
    public void idFind()
    {
        party1Btn=(Button) findViewById(R.id.party1Btn);
        party2Btn=(Button) findViewById(R.id.party2Btn);
        party3Btn=(Button) findViewById(R.id.party3Btn);


    }
    public void beepSoundAndVibrate()
    {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                MediaPlayer mp=MediaPlayer.create(VotingPage.this, R.raw.vote_sound_effect);
                mp.start();
                try {
                    Thread.sleep(800);

                } catch (InterruptedException e) {
                    Toast.makeText(VotingPage.this,"Error Sound",Toast.LENGTH_SHORT).show();
                }
                vibrator.vibrate(1500);
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    Toast.makeText(VotingPage.this,"Error Sound",Toast.LENGTH_SHORT).show();
                }
                mp.stop();

            }
        });
        t.start();
    }
   public void giveVote()
    {


        party1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disable others buttons
                party2Btn.setEnabled(false);
                party3Btn.setEnabled(false);
                db.execSQL("INSERT INTO firstParty(voterAdhaar,voterPass ) VALUES("+login+",'"+pass+"')");

                db.execSQL("UPDATE voterDetails SET status=0 WHERE adhaarNo="+login+" AND password='"+pass+"'");

                int color= Color.parseColor("#00FF00");
                party1Btn.setBackgroundColor(color);

                beepSoundAndVibrate();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextActivity();
                    }
                },3500);

            }
        });

        party2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disable others buttons
                party1Btn.setEnabled(false);
                party3Btn.setEnabled(false);

                db.execSQL("INSERT INTO secondParty(voterAdhaar,voterPass ) VALUES("+login+",'"+pass+"')");

                db.execSQL("UPDATE voterDetails SET status=0 WHERE adhaarNo="+login+" AND password='"+pass+"'");

                int color= Color.parseColor("#00FF00");
                party2Btn.setBackgroundColor(color);

                beepSoundAndVibrate();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextActivity();
                    }
                },3500);


            }
        });

        party3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disable others buttons
                party1Btn.setEnabled(false);
                party2Btn.setEnabled(false);


                db.execSQL("INSERT INTO thirdParty(voterAdhaar,voterPass ) VALUES("+login+",'"+pass+"')");

                db.execSQL("UPDATE voterDetails SET status=0 WHERE adhaarNo="+login+" AND password='"+pass+"'");

                int color= Color.parseColor("#00FF00");
                party3Btn.setBackgroundColor(color);

                beepSoundAndVibrate();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nextActivity();
                    }
                },3500);


            }
        });

    }
  /*  public void voted(View view)
    {
        Toast.makeText(VotingPage.this,"Thanks for Voting",Toast.LENGTH_LONG).show();
        db.execSQL("UPDATE voterDetails SET status=0 WHERE adhaarNo="+login+" AND password='"+pass+"'");
        finish();
    }*/

    @Override
    public void onBackPressed() {

        Toast.makeText(VotingPage.this,"Give your Vote",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
