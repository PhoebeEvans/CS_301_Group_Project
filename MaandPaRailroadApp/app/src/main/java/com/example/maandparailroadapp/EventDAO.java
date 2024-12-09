package com.example.maandparailroadapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Phoebe
 * @date 12/9/2024
 * @description EventDAO for the events page
 */

public class EventDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public EventDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Inserting a new event
    public long insertEvent(Event event) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, event.getTitle());
        values.put(DatabaseHelper.COLUMN_DESCRIPTION, event.getDescription());
        values.put(DatabaseHelper.COLUMN_DATE, event.getDate());
        values.put(DatabaseHelper.COLUMN_TIME, event.getTime());

        return db.insert(DatabaseHelper.TABLE_EVENTS, null, values);
    }

    // Getting all events
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        Cursor cursor = db.query(DatabaseHelper.TABLE_EVENTS, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Event event = new Event(
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIME))
                );
                events.add(event);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return events;
    }

    // Saving an event for a user


    public void saveEventForUser(int userId, int eventId) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USER_ID, userId);
        values.put(DatabaseHelper.COLUMN_EVENT_ID, eventId);
        long result = db.insert(DatabaseHelper.TABLE_SAVED_EVENTS, null, values);

        // Log the result of the insert operation
        if (result == -1) {
            Log.e("EventDAO", "Failed to save event for user with userId: " + userId + " and eventId: " + eventId);
        } else {
            Log.d("EventDAO", "Event saved successfully for user with userId: " + userId + " and eventId: " + eventId);
        }
    }


    // Getting saved events for a user
    public List<Event> getSavedEventsForUser(int userId) {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_EVENTS + " e INNER JOIN " + DatabaseHelper.TABLE_SAVED_EVENTS + " s ON e." + DatabaseHelper.COLUMN_ID + " = s." + DatabaseHelper.COLUMN_EVENT_ID + " WHERE s." + DatabaseHelper.COLUMN_USER_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(userId)});

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Event event = new Event(
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIME))
                );
                events.add(event);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return events;
    }

    public List<Event> getEventsByDate(String date) {
        List<Event> events = new ArrayList<>();
        String selection = DatabaseHelper.COLUMN_DATE + " = ?";
        String[] selectionArgs = { date };
        Cursor cursor = db.query(DatabaseHelper.TABLE_EVENTS, null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Event event = new Event(
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIME))
                );
                events.add(event);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return events;
    }

}
