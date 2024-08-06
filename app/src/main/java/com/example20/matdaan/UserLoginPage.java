package com.example20.matdaan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginPage extends Activity {

    SQLiteDatabase db;
    Button userLoginBtn;
    EditText enterAdhaarNumber,enterPasswordToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_page);

        creatingDatabaseAndTables();
        idFind();

     /*  db.execSQL("drop table IF EXISTS firstParty");
        db.execSQL("drop table IF EXISTS secondParty");
        db.execSQL("drop table  IF EXISTS thirdParty");
        db.execSQL("drop table  IF EXISTS voterDetails");
        db.execSQL("drop table  IF exists adhaarCheck");
        db.execSQL("drop table  IF exists mobileCheck"); */






        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(1==fetchingValuesFromLayout()) {

                    matchingValuesFromDatabase();

                }

            }
        });

    }
    //it creates Database and required tables
    public void creatingDatabaseAndTables()
    {
        //database create
        db =openOrCreateDatabase("VotersData.sql",MODE_PRIVATE,null);

        //tables create
        db.execSQL("CREATE TABLE IF NOT EXISTS firstParty(voterAdhaar INTERGER PRIMARY KEY,voterPass TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS secondParty(voterAdhaar INTEGER PRIMARY KEY,voterPass TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS thirdParty(voterAdhaar INTEGER PRIMARY KEY,voterPass TEXT)");

        // db.execSQL("drop table if exists voterDetails");
        db.execSQL("CREATE TABLE IF NOT EXISTS voterDetails(adhaarNo INTEGER PRIMARY KEY CHECK(adhaarNo LIKE '____________' AND (adhaarNo LIKE '9%' OR adhaarNo LIKE '8%' OR adhaarNo LIKE '7%' OR adhaarNo LIKE '6%' OR adhaarNo LIKE '5%' OR adhaarNo LIKE '4%' OR adhaarNo LIKE '3%' OR adhaarNo LIKE '2%')), " +
                "voterName TEXT NOT NULL,voterFatherName TEXT," +
                " dob DATE NOT NULL CHECK(dob <'2006/12/32'),gender TEXT NOT NULL, state TEXT NOT NULL ,city TEXT NOT NULL, address TEXT, " +
                "pincode TEXT NOT NULL CHECK(pincode LIKE '______'), mobile TEXT NOT NULL CHECK(mobile LIKE '______%' AND mobile LIKE '9%' OR mobile LIKE '8%' OR mobile LIKE '7%' OR mobile LIKE '6%' ) ," +
                " password TEXT NOT NULL CHECK(password LIKE '______%'),status INTEGER DEFAULT 1)");
        //  Toast.makeText(this,"table created",Toast.LENGTH_SHORT).show();

    }

    public  void nextActivity()
    {
        Intent i=new Intent(UserLoginPage.this, VotingPage.class);

        //attached extra information with intent
        i.putExtra("login",userLoginAdhaarNumber);
        i.putExtra("pass",userLoginPassword);

        startActivity(i);
        finish();

    }
    public void idFind()

    {
        userLoginBtn=(Button)findViewById(R.id.userLoginBtn);

        enterAdhaarNumber=(EditText) findViewById(R.id.enterAdhaarNumber);
        enterPasswordToLogin=(EditText) findViewById(R.id.enterPasswordToLogin);
    }

    private Long userLoginAdhaarNumber;
    private String userLoginPassword;
    //user inputed values
    public int fetchingValuesFromLayout()
    {   //if user logined without entering any details then NumberFromatException raised
        try {
            userLoginAdhaarNumber = Long.parseLong(enterAdhaarNumber.getText().toString());
            userLoginPassword = enterPasswordToLogin.getText().toString();
        } catch (NumberFormatException numberFormatException)
        {
            Toast.makeText(UserLoginPage.this,"Empty Login",Toast.LENGTH_SHORT).show();
            return 0;
        }
        catch (Exception e)
        {
            Toast.makeText(UserLoginPage.this,"Exception",Toast.LENGTH_SHORT).show();
            return 0;
        }
        return 1;
    }

    //values from Database
    public void matchingValuesFromDatabase()
    {

        //if user enters valid aadhaarNo then cursor moves
        Cursor cID=db.rawQuery("SELECT * FROM voterDetails WHERE adhaarNo ="+userLoginAdhaarNumber+" " ,null);
        if(cID.moveToNext())
        {
            //if user enters valid password then cursor moves
            Cursor cPass=db.rawQuery("SELECT * FROM voterDetails WHERE adhaarNo ="+userLoginAdhaarNumber+" AND password ='"+userLoginPassword+"' " ,null);
            if(cPass.moveToNext())
            {
                //if user status is 1 in the database then cursor moves
                Cursor cStatus=db.rawQuery("SELECT * FROM voterDetails WHERE adhaarNo ="+userLoginAdhaarNumber+" AND password ='"+userLoginPassword+"' AND status =1 " ,null);
                if(cStatus.moveToNext())
                {

                    nextActivity();
                }
                else {
                    Toast.makeText(UserLoginPage.this,"Already Voted",Toast.LENGTH_SHORT).show();
                }
            }
            else {
                //if user login without filling password
                if(userLoginPassword.equals(""))
                {
                    Toast.makeText(UserLoginPage.this,"Empty Password",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(UserLoginPage.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else{
            Toast.makeText(UserLoginPage.this,"Invalid ID",Toast.LENGTH_SHORT).show();
        }


    }


    //onClick method of sign up link
    public void userSignUp(View view)
    {
        Intent i =new Intent(UserLoginPage.this,UserRegistration.class);
        startActivity(i);
        finish();
    }

    //onClick method of election commission login link
    public void electionCommissionLogin(View view)
    {
        Intent i =new Intent(UserLoginPage.this,ElectionCommissionLogin.class);
        startActivity(i);
        finish();

    }

   Long onBackPressTime= 0L;
    @Override
   public  void onBackPressed() {
        if ( onBackPressTime+3000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG).show();
        }
        onBackPressTime=System.currentTimeMillis();
    }
}