package com.example20.matdaan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultPage extends Activity {

    SQLiteDatabase db;
    TextView totalVote,party1Count,party2Count,party3Count;
    TextView winnerTextView,runnerUpTextView;
    TextView femaleVoters,maleVoters;
    ProgressBar femaleProgressBar,maleProgressBar,totalVoteProgessBar;
    int maleVotePercent,femaleVotePercent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        idFind();
    //Progress bar

      /*  Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=10;i++)
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e);
                    }


                }
              //  Intent i =new Intent(processBar.this, AutoComp.class);
               // startActivity(i);
            }

        });
        t.start();*/


        fetchingValuesFromDatabase();
        setDataToLayut();
        checkWinnerAndRunnerUp();
        setUpProgressBar();



    }
    public void nextActivity()
    {
        Intent i =new Intent(ResultPage.this,UserLoginPage.class);
        startActivity(i);
        finish();
    }
    public void setUpProgressBar()
    {
        femaleProgressBar.setProgress(femaleVotesCountInt);
        femaleProgressBar.setMax(totalVotesCountInt);
        maleProgressBar.setProgress(maleVotesCountInt);
        maleProgressBar.setMax(totalVotesCountInt);
     //   totalVoteProgessBar.setProgress(totalVotesCountInt);
     //   totalVoteProgessBar.setMax(totalVotesCountInt);
    }
    public void checkWinnerAndRunnerUp()
    {

        if(party1VoteCount==party2VoteCount || party1VoteCount==party3VoteCount)
        {
            if(party1VoteCount==party3VoteCount)
            {
                winnerTextView.setText("Tie Between BJP And TDA");

            }
            else
            {
                winnerTextView.setText("Tie Between BJP And I.N.D.I.A ");
            }
        }
        else if (party2VoteCount==party3VoteCount)
        {
            winnerTextView.setText("Tie Between I.N.D.I.A And TDA ");
        }

        if(party1VoteCount >party2VoteCount)
        {
            if(party1VoteCount>party3VoteCount)
            {

                if(party2VoteCount==party3VoteCount)
                {
                    winnerTextView.setText("BJP");
                    runnerUpTextView.setText("Tie Between I.N.D.I.A And TDA ");
                }
                else if (party2VoteCount>party3VoteCount)
                {
                    winnerTextView.setText("BJP");
                    runnerUpTextView.setText("I.N.D.I.A");
                }
                else
                {
                    winnerTextView.setText("BJP");
                    runnerUpTextView.setText("TDA");
                }
            }
            else {
                if(party1VoteCount==party3VoteCount) {
                    winnerTextView.setText("Tie Between BJP And TDA");
                    runnerUpTextView.setText("I.N.D.I.A");
                }
                else
                {
                    winnerTextView.setText("TDA");
                    runnerUpTextView.setText("BJP");
                }
            }
        }
        else
        {
            if(party2VoteCount>party3VoteCount)
            {
                if(party1VoteCount==party2VoteCount)
                {
                    winnerTextView.setText("Tie Between BJP And I.N.D.I.A ");
                    runnerUpTextView.setText("TDA");
                }
                else if (party1VoteCount>party3VoteCount)
                {
                    winnerTextView.setText("I.N.D.I.A");
                    runnerUpTextView.setText("BJP");
                }
                else
                {
                   winnerTextView.setText("I.N.D.I.A");
                   runnerUpTextView.setText("TDA");
                }


            }
            else
            {
                if(party3VoteCount==party1VoteCount && party3VoteCount==party2VoteCount)
                {
                    winnerTextView.setText("Tied");
                    runnerUpTextView.setText("No One");
                }

                else if (party1VoteCount ==party2VoteCount)
                {
                    winnerTextView.setText("TDA");
                    runnerUpTextView.setText("Tie Between BJP And I.N.D.I.A ");
                }
                else if (party2VoteCount==party3VoteCount)
                {
                    winnerTextView.setText("Tie Between I.N.D.I.A And TDA");
                    runnerUpTextView.setText("BJP");

                } else if (party2VoteCount>party1VoteCount)
                {
                    winnerTextView.setText("TDA");
                    runnerUpTextView.setText("I.N.D.I.A");
                }
                else
                {
                    winnerTextView.setText("TDA");
                    runnerUpTextView.setText("BJP");
                }

            }
        }

      //another logic
      /*  int []a={party1VoteCount,party2VoteCount,party3VoteCount};
        int max=a[0];
        int index=0;
        for(int i=1; i<3; i++)
        {
            if(a[i] >max)
            {
                index=i;
                max=a[i];
            }
        }
        if(max==a[0] && max==a[1] && max==a[2] )
        {
            //System.out.println("Draw a b c");
            winnerTextView.setText("Draw : BJP , I.N.D.I.A , TDA");
            runnerUpTextView.setText("No one");
        }
        else if( max==a[0] && max==a[1])
        {
            //  System.out.println("Draw a b");
            winnerTextView.setText("Draw : BJP , I.N.D.I.A");
            runnerUpTextView.setText("TDA");
        }
        else if( max==a[0] && max==a[2])
        {
            // System.out.println("Draw a c ");
            winnerTextView.setText("Draw : BJP , TDA");
            runnerUpTextView.setText("I.N.D.I.A");
        }
        else if( max==a[1] && max==a[2])
        {
            // System.out.println("Draw b c ");
            winnerTextView.setText("Draw : I.N.D.I.A , TDA");
            runnerUpTextView.setText("BJP");
        }
        else
        {
            if(index==0)
            {
                //party1
                winnerTextView.setText("BJP");
                if(a[1]>a[2])
                {
                    runnerUpTextView.setText("I.N.D.I.A");
                }else if (a[1]==a[2]) {
                    runnerUpTextView.setText("Draw : I.N.D.I.A ,TDA");
                }
                else {
                    runnerUpTextView.setText("TDA");
                }
            } else if (index ==1) {
                //party2
                winnerTextView.setText("I.N.D.I.A");
                if(a[0]>a[2])
                {
                    runnerUpTextView.setText("BJP");
                }else if (a[1]==a[2]) {
                    runnerUpTextView.setText("Draw : I.N.D.I.A , TDA");
                }
                else {
                    runnerUpTextView.setText("TDA");
                }
            }
            else {
                //party3
                winnerTextView.setText("TDA");
                if(a[0]>a[1])
                {
                    runnerUpTextView.setText("BJP");
                } else if (a[0]==a[1]) {
                    runnerUpTextView.setText("Draw : BJP , I.N.D.I.A");
                } else {
                    runnerUpTextView.setText("I.N.D.I.A");
                }
            }
        }*/
    }
    public void fetchingValuesFromDatabase()
    {
        db=openOrCreateDatabase("VotersData.sql",MODE_PRIVATE,null);
        //Total Voters Count
        Cursor c=db.rawQuery("SELECT COUNT(*) FROM voterDetails ",null);
        if(c.moveToNext()) {

          totalVotesCountInt = c.getInt(0);
          totalVotersCount=Integer.toString(totalVotesCountInt);
          //  Toast.makeText(ResultPage.this, "Total Votes " + totalVoteCount, Toast.LENGTH_SHORT).show();
        }

        //party1 couting
       Cursor cParty1=db.rawQuery("SELECT COUNT(*) FROM firstParty ",null);
        if(cParty1.moveToNext()) {
            party1VoteCount = cParty1.getInt(0);
     //       Toast.makeText(ResultPage.this, "Total Votes party1" + party1VoteCount, Toast.LENGTH_SHORT).show();
        }


        //party2 counting
        Cursor cParty2=db.rawQuery("SELECT COUNT(*) FROM secondParty ",null);
        if(cParty2.moveToNext()) {
            party2VoteCount = cParty2.getInt(0);
           // Toast.makeText(ResultPage.this, "Total Votes party2" + party2VoteCount, Toast.LENGTH_SHORT).show();
        }


        //party3 counting
        Cursor cParty3=db.rawQuery("SELECT COUNT(*) FROM thirdParty ",null);
        if(cParty3.moveToNext()) {
            party3VoteCount = cParty3.getInt(0);
         //  Toast.makeText(ResultPage.this, "Total Votes party3" + party3VoteCount, Toast.LENGTH_SHORT).show();
        }


        //sax ratio finding
       Cursor cMale=db.rawQuery("SELECT COUNT(gender) FROM voterDetails WHERE gender='Male'",null);
        if(cMale.moveToNext())
        {
            maleVotesCountInt=cMale.getInt(0);
           maleVotesCount=Integer.toString(maleVotesCountInt);
        }

        Cursor cFemale=db.rawQuery("SELECT Count(gender) FROM voterDetails  WHERE gender='Female' ",null);
        if(cFemale.moveToNext())
        {
            femaleVotesCountInt=cFemale.getInt(0);
            femaleVotesCount=Integer.toString(femaleVotesCountInt);

        }


    }
    int totalVotesCountInt,femaleVotesCountInt,maleVotesCountInt;
    int party1VoteCount,party2VoteCount,party3VoteCount;
    String maleVotesCount,femaleVotesCount,totalVotersCount;


    public void setDataToLayut()
    {
       String party1VoteInString,party2VoteInString,party3VoteInString;


        party1VoteInString=Integer.toString(party1VoteCount);
        party2VoteInString=Integer.toString(party2VoteCount);
        party3VoteInString=Integer.toString(party3VoteCount);

        totalVote.setText(totalVotersCount);
        party1Count.setText(party1VoteInString);
        party2Count.setText(party2VoteInString);
        party3Count.setText(party3VoteInString);


        try {
            //Votes in percentage
            maleVotePercent = maleVotesCountInt * 100 / totalVotesCountInt;
            femaleVotePercent = femaleVotesCountInt * 100 / totalVotesCountInt;
           CharSequence femalePercentage = femaleVotePercent + "%";
           CharSequence malePercentage = maleVotePercent + "%";
            femaleVoters.setText(femalePercentage);
            maleVoters.setText(malePercentage);
        }catch (Exception e)
        {
            femaleVoters.setText("0%");
            maleVoters.setText("0%");
        }



    }
    public void idFind()
    {
        totalVote=(TextView) findViewById(R.id.totalVote);
        party1Count=(TextView) findViewById(R.id.party1Count);
        party2Count=(TextView) findViewById(R.id.party2Count);
        party3Count=(TextView) findViewById(R.id.party3Count);

        winnerTextView=(TextView) findViewById(R.id.winnerTextView);
        runnerUpTextView=(TextView) findViewById(R.id.runnerUpTextView);



        femaleVoters=(TextView) findViewById(R.id.femaleVoters);
        maleVoters=(TextView) findViewById(R.id.maleVoters);


        //ProgessBar
        femaleProgressBar=(ProgressBar) findViewById(R.id.femaleProgressBar);
        maleProgressBar=(ProgressBar) findViewById(R.id.maleProgressBar);
      //  totalVoteProgessBar=(ProgressBar) findViewById(R.id.totalVoteProgressBar);
    }

    @Override
    public void onBackPressed() {
        nextActivity();
    }
}