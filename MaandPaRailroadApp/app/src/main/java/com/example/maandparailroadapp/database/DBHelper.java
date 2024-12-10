package com.example.maandparailroadapp.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.maandparailroadapp.User;
import com.example.maandparailroadapp.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @authors Lauren and Phoebe
 * @date 12/9/2024
 * @description DatabaseHelper for managing users and events
 */


public class DBHelper extends SQLiteOpenHelper {
    // Database values
    private static final String DATABASE_NAME = "app.db";
    private static final int DATABASE_VERSION = 4;
    private static DBHelper instance;

    // User table columns
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "id"; // Define COLUMN_USER_ID here
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_IS_ADMIN = "isAdmin";

    // Event table columns
    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_EVENT_ID = "event_id"; // Define COLUMN_EVENT_ID
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    // Saved events table columns
    public static final String TABLE_SAVED_EVENTS = "saved_events";

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_IS_ADMIN + " INTEGER)";
        db.execSQL(createUserTable);

        String createEventsTable = "CREATE TABLE " + TABLE_EVENTS + " (" +
                COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT)";
        db.execSQL(createEventsTable);

        String createSavedEventsTable = "CREATE TABLE " + TABLE_SAVED_EVENTS + " (" +
                COLUMN_USER_ID + " INTEGER, " +
                COLUMN_EVENT_ID + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "), " +
                "FOREIGN KEY(" + COLUMN_EVENT_ID + ") REFERENCES " + TABLE_EVENTS + "(" + COLUMN_EVENT_ID + "))";
        db.execSQL(createSavedEventsTable);

        // Insert events with correct dates
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-07", "5 pm & 7 pm");
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-08", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-14", "5 pm & 7 pm");
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-15", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-21", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Christmas City Express", "The Christmas City Express program is centered around the dramatic reading of a story of a young girl traveling to Muddy Creek Forks a hundred years ago to visit her grandparents for Christmas.", "2024-12-22", "1:30 pm & 3:30 pm & 5:30 pm");

    }

    public void insertEvent(SQLiteDatabase db, String title, String description, String date, String time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TIME, time);
        db.insert(TABLE_EVENTS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAVED_EVENTS);
        onCreate(db);
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                @SuppressLint("Range") int isAdmin = cursor.getInt(cursor.getColumnIndex(COLUMN_IS_ADMIN));

                User user = new User(username, email, password, isAdmin);
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }

    public void insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_IS_ADMIN, user.getIsAdmin());
        db.insert(TABLE_USERS, null, values);
    }

    public int getUserIdByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_USER_ID},
                COLUMN_USERNAME + "=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") int userId = cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID));
            cursor.close();
            return userId;
        }
        cursor.close();
        return -1; // User not found
    }
}
