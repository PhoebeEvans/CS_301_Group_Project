package com.example.maandparailroadapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_USER_ID = "userId";

    public UserSessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserId(int userId) {
        editor.putInt(KEY_USER_ID, userId);
        editor.commit();
    }

    public int getUserId() {
        return sharedPreferences.getInt(KEY_USER_ID, -1); // Default value -1 if not found
    }
}
