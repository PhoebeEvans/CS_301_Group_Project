package com.example.maandparailroadapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
                Event event = new Event(
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

