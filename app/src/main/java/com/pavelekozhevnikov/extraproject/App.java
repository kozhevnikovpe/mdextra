package com.pavelekozhevnikov.extraproject;

import android.app.Application;
import android.content.SharedPreferences;


public class App extends Application {
    private int[] themes =  {R.style.AppTheme3, R.style.AppTheme2, R.style.AppTheme};

    SharedPreferences sharedPrefs;

    public SharedPreferences getSharedPrefs() {
        return sharedPrefs;
    }

    public int getCurrentTheme(){
        int n = sharedPrefs.getInt("theme",0);
        return themes[n];
    }

    public void setNextTheme(){
        int n = sharedPrefs.getInt("theme",-1);
        n++;
        if(n>=themes.length)
            n=0;
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("theme", n);
        editor.commit();
    }

    public static App getInstance() {
        return instance;
    }

    private static App instance;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPrefs = getSharedPreferences("app",MODE_PRIVATE);
    }
}
