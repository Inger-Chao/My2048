package com.joki.testapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 嗨呀 on 2017/2/22.
 */

public class HighestScore {
    private static final String SP_SCORE_KEY = "highestScore";
    private SharedPreferences sp;

    public HighestScore(Context context) {
        sp = context.getSharedPreferences("HS", Context.MODE_PRIVATE);
    }


    public int getHighestScore() {
        int highestScore = sp.getInt(SP_SCORE_KEY, 0);
//        Log.d("TAG", "getHighestScore: " + highestScore);
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(SP_SCORE_KEY, highestScore);
       /* Log.d("TAG", "setHighestScore: "+highestScore);*/
        editor.commit();
    }
}
