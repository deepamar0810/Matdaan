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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ElectionCommissionLogin extends Activity {
    int id=12345;
    String pass="election";
    EditText enterID,enterCommissionPassword;
    SQLiteDatabase db;
    Button commissionLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_election_commission_login);



        idFind();
        commissionLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //db=openOrCreateDatabase("VotersData.sql",MODE_PRIVATE,null);

                if (1==fetchingValuesFromLayout()) {


                    if (id == loginID) {
                        if (pass.equals(loginPassword)) {

                           nextActivity();
                        } else {
                            if (loginPassword.equals("")) {
                                Toast.makeText(ElectionCommissionLogin.this, "Empty Password", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ElectionCommissionLogin.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(ElectionCommissionLogin.this, "Invalid ID", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });



    }
   public void nextActivity()
    {
        Intent i =new Intent(ElectionCommissionLogin.this,ResultPage.class);
        startActivity(i);
        finish();
    }

    public void idFind()
    {
        enterID=(EditText) findViewById(R.id.enterID);
        enterCommissionPassword=(EditText) findViewById(R.id.enterCommissionPassword);
        commissionLoginBtn=(Button) findViewById(R.id.commissionLoginBtn);
    }
    private int loginID;
    private String loginPassword;
    public int fetchingValuesFromLayout()
    {
        try {
            loginID = Integer.parseInt(enterID.getText().toString());
            loginPassword = enterCommissionPassword.getText().toString();
        } catch (NumberFormatException numberFormatException)
        {
            Toast.makeText(ElectionCommissionLogin.this,"Empty Login",Toast.LENGTH_SHORT).show();
            return 0;
        }
        catch (Exception e)
        {
            Toast.makeText(ElectionCommissionLogin.this,"Exception",Toast.LENGTH_SHORT).show();
        }
        return 1;
    }
    public void userLogin(View view)
    {
        Intent i =new Intent(ElectionCommissionLogin.this,UserLoginPage.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(ElectionCommissionLogin.this,UserLoginPage.class);
        startActivity(i);
        finish();
    }
}