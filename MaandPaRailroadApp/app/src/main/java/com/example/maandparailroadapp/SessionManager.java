package com.example.maandparailroadapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LoginSession";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "Username";
    public static final String KEY_EMAIL = "Email";
    public static User user;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(User _user) {
        user = _user;
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, null);
    }

    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    public User getUser(){ return user; }

    public void logoutUser() {
        editor.clear();
        editor.commit();
    }
}

