package com.example.easylearndrivinglessons;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    SharedPreferences mySharedPrefs;
    public SharedPrefs(Context context){
        mySharedPrefs = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    //this method saves the users selected theme after closing our application
    public void setNightModeState(Boolean state){
        SharedPreferences.Editor editor = mySharedPrefs.edit();
        editor.putBoolean("NightMode",state);
        editor.commit();
    }

    //this method loads the users selected them after closing and reopening our application.
    public boolean loadNightModeState(){
        Boolean state = mySharedPrefs.getBoolean("NightMode", false);
        return state;
    }
}
