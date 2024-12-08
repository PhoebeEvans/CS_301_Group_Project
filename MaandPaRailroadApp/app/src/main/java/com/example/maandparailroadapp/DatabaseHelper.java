package com.example.maandparailroadapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EVENTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TIME + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

        // Insert events
        insertEvent(db, "Motorcar train rides", "Motorcar train rides on all open days. The last train departs 45 minutes before closing.", "Sundays, June 2 - Sep. 1", "1-5 pm");
        insertEvent(db, "Mid-Atlantic Milling Days", "This weekend is the only time this year that guided tours of the upper floors of the mill will be offered.", "June 8", "11 am to 5 pm");
        insertEvent(db, "Mid-Atlantic Milling Days", "", "June 9", "1 pm to 5 pm");
        insertEvent(db, "Ice Cream Social", "Ice Cream Social", "June 29", "11 am to 5 pm");
        insertEvent(db, "Ice Cream Social", "Ice Cream Social", "June 30", "1 pm to 5 pm");
        insertEvent(db, "Discovery Day", "Discover secrets and treasures about our Heritage Village during these interactive 'Discovery' Days.", "July 13", "11 am to 5 pm");
        insertEvent(db, "Discovery Day", "Discover secrets and treasures about our Heritage Village during these interactive 'Discovery' Days.", "July 14", "1 pm to 5 pm");
        insertEvent(db, "Civil War Encampment", "Authentic uniformed soldiers and equipment.", "July 21", "1 pm to 5 pm");
        insertEvent(db, "Early American Autos", "Autos from the 1915 era visit Muddy Creek Forks.", "August 11", "1 pm to 5 pm");
        insertEvent(db, "Discovery Day", "Discover secrets and treasures about our Heritage Village during these interactive 'Discovery' Days.", "August 17", "11 am to 5 pm");
        insertEvent(db, "Discovery Day", "Discover secrets and treasures about our Heritage Village during these interactive 'Discovery' Days.", "August 18", "1 pm to 5 pm");
        insertEvent(db, "World War II Encampment", "Interactive WWII experience - armaments, equipment, uniforms, vehicles.", "August 24", "11 am to 5 pm");
        insertEvent(db, "World War II Encampment", "Interactive WWII experience - armaments, equipment, uniforms, vehicles.", "August 25", "1 pm to 5 pm");
        insertEvent(db, "Pumpkin Patch Excursions", "Ride the train to the pumpkin patch to pick your great pumpkin.", "October 5", "11 am to 4 pm");
        insertEvent(db, "Pumpkin Patch Excursions", "Ride the train to the pumpkin patch to pick your great pumpkin.", "October 6", "1 pm to 5 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 12", "11 am to 4 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 13", "1 pm to 5 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 19", "11 am to 4 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 20", "1 pm to 5 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 26", "11 am to 4 pm");
        insertEvent(db, "Fall Leaf Excursions", "", "October 27", "1 pm to 5 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 7", "5 pm & 7 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 8", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 14", "5 pm & 7 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 15", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 21", "1:30 pm & 3:30 pm & 5:30 pm");
        insertEvent(db, "Holiday Events", "Holiday events with multiple times.", "December 22", "1:30 pm & 3:30 pm & 5:30 pm");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        onCreate(db);
    }

    public void insertEvent(SQLiteDatabase db, String title, String description, String date, String time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TIME, time);
        db.insert(TABLE_EVENTS, null, values);
    }

}
