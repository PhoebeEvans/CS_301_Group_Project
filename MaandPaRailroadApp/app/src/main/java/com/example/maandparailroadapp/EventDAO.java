package com.example.maandparailroadapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.maandparailroadapp.database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public EventDAO(Context context) {
        dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }

    // Getting all events
    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {
                DBHelper.COLUMN_EVENT_ID,
                DBHelper.COLUMN_TITLE,
                DBHelper.COLUMN_DESCRIPTION,
                DBHelper.COLUMN_DATE,
                DBHelper.COLUMN_TIME
        };
        Cursor cursor = db.query(DBHelper.TABLE_EVENTS, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_EVENT_ID));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIME));

                // Puts it in event form and adds it to the list
                Event event = new Event(id, title, description, date, time);
                eventList.add(event);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Returns the List<Event>
        return eventList;
    }

    // Saving an event for a user
    public void saveEventForUser(int userId, int eventId) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_USER_ID, userId);
        values.put(DBHelper.COLUMN_EVENT_ID, eventId);
        long result = db.insert(DBHelper.TABLE_SAVED_EVENTS, null, values);

        // Log the result of the insert operation
        if (result == -1) {
            Log.e("EventDAO", "Failed to save event for user with userId: " + userId + " and eventId: " + eventId);
        } else {
            Log.d("EventDAO", "Event saved successfully for user with userId: " + userId + " and eventId: " + eventId);
        }
    }



    // Getting saved events for all users
    public List<SavedEvent> getSavedEventsForAllUsers() {
        List<SavedEvent> savedEvents = new ArrayList<>();
        String query = "SELECT u." + DBHelper.COLUMN_USER_ID + ", u." + DBHelper.COLUMN_USERNAME + ", u." + DBHelper.COLUMN_EMAIL + ", " +
                "e." + DBHelper.COLUMN_EVENT_ID + ", e." + DBHelper.COLUMN_TITLE + ", e." + DBHelper.COLUMN_DESCRIPTION + ", e." + DBHelper.COLUMN_DATE + ", e." + DBHelper.COLUMN_TIME + " " +
                "FROM " + DBHelper.TABLE_SAVED_EVENTS + " s " +
                "INNER JOIN " + DBHelper.TABLE_USERS + " u ON s." + DBHelper.COLUMN_USER_ID + " = u." + DBHelper.COLUMN_USER_ID + " " +
                "INNER JOIN " + DBHelper.TABLE_EVENTS + " e ON s." + DBHelper.COLUMN_EVENT_ID + " = e." + DBHelper.COLUMN_EVENT_ID;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int eventId = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_EVENT_ID));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIME));
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_USERNAME));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EMAIL));

                // Create User and Event objects
                User user = new User(username, email, "", 0); // Assuming password and isAdmin fields are not required here
                Event event = new Event(eventId, title, description, date, time);
                SavedEvent savedEvent = new SavedEvent(user, event);

                // Add to list
                savedEvents.add(savedEvent);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return savedEvents;
    }

    // Getting events by date
    public List<Event> getEventsByDate(String date) {
        List<Event> events = new ArrayList<>();
        String selection = DBHelper.COLUMN_DATE + " = ?";
        String[] selectionArgs = { date };
        Cursor cursor = db.query(DBHelper.TABLE_EVENTS, null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Event event = new Event(
                        cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_EVENT_ID)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIME))
                );
                events.add(event);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return events;
    }

    //saved events for user
    public List<SavedEvent> getSavedEventsForUser(int userId) {
        List<SavedEvent> savedEvents = new ArrayList<>();
        String query = "SELECT u." + DBHelper.COLUMN_USER_ID + ", u." + DBHelper.COLUMN_USERNAME + ", u." + DBHelper.COLUMN_EMAIL + ", " +
                "e." + DBHelper.COLUMN_EVENT_ID + ", e." + DBHelper.COLUMN_TITLE + ", e." + DBHelper.COLUMN_DESCRIPTION + ", e." + DBHelper.COLUMN_DATE + ", e." + DBHelper.COLUMN_TIME + " " +
                "FROM " + DBHelper.TABLE_SAVED_EVENTS + " s " +
                "INNER JOIN " + DBHelper.TABLE_USERS + " u ON s." + DBHelper.COLUMN_USER_ID + " = u." + DBHelper.COLUMN_USER_ID + " " +
                "INNER JOIN " + DBHelper.TABLE_EVENTS + " e ON s." + DBHelper.COLUMN_EVENT_ID + " = e." + DBHelper.COLUMN_EVENT_ID + " " +
                "WHERE s." + DBHelper.COLUMN_USER_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(userId)});

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int eventId = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_EVENT_ID));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TITLE));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TIME));
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_USERNAME));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EMAIL));

                // Create User and Event objects
                User user = new User(username, email, "", 0); // Assuming password and isAdmin fields are not required here
                Event event = new Event(eventId, title, description, date, time);
                SavedEvent savedEvent = new SavedEvent(user, event);

                // Add to list
                savedEvents.add(savedEvent);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return savedEvents;
    }

}
