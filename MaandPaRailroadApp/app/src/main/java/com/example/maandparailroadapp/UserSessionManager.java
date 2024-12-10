package com.example.maandparailroadapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class UserSessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_USERNAME = "username";

    public UserSessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.commit();
        Log.d("UserSessionManager", "Username saved: " + username); // Debug log
    }

    public String getUsername() {
        String username = sharedPreferences.getString(KEY_USERNAME, null);
        Log.d("UserSessionManager", "Username retrieved: " + username); // Debug log
        return username;
    }
}
