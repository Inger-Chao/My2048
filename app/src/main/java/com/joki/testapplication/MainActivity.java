package com.joki.testapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.TextView;

import com.joki.testapplication.view.Layout;
import com.joki.testapplication.view.Layout.OnGame2048Listener;

public class MainActivity extends Activity implements OnGame2048Listener
{
    private Layout mGame2048Layout;

    private TextView mScore;
    private TextView mHighest;

    private  HighestScore hs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore = (TextView) findViewById(R.id.id_score);
        mHighest = (TextView) findViewById(R.id.id_Highest);
        mGame2048Layout = (Layout) findViewById(R.id.id_game2048);
        mGame2048Layout.setOnGame2048Listener(this);
        onHighestChange();
        onScoreChange(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // save(highestScore);
    }

    @Override
    public void onScoreChange(int score)
    {
        mScore.setText("SCORE:\n" + score);
    }

    @Override
    public void onHighestChange() {
        if(hs == null){
            hs = new HighestScore(this);
        }
        mHighest.setText("HIGHEST:\n" + hs.getHighestScore());
    }

    @Override
    public void onGameOver()
    {
        new AlertDialog.Builder(this).setTitle("GAME OVER")
                .setMessage("YOU HAVE GOT " + mScore.getText())
                .setPositiveButton("RESTART", new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        mGame2048Layout.restart();
                    }
                }).setNegativeButton("EXIT", new OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        }).show();
    }

}