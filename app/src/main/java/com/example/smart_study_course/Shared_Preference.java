package com.example.smart_study_course;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

public class Shared_Preference {
    final static String FileName="CaptainCode";

    public static String readSharedSettings(Context cxt,String settingsName,String defaultValue)
    {
        SharedPreferences sharedPref=cxt.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        return sharedPref.getString(settingsName,defaultValue);
    }
    public static void saveSharedSettings(Context cxt,String settingsName,String settingsValue)
    {
        SharedPreferences sharedPref=cxt.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString(settingsName,settingsValue);
        editor.apply();
    }
}
