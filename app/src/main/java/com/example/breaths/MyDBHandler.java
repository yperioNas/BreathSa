package com.example.breaths;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "breathSDB.db";
    //Table condition
    public static final String TABLE_CONDITIONS= "conditions_Table";
    public static final String COLUMN_CONDITIONS_ID = "id_conditions";
    public static final String COLUMN_CONDITION = "condition";
    //Table Pollutants
    public static final String TABLE_POLLUTANTS = "pollutants_Table";
    public static final String COLUMN_POLLUTANTS_ID = "id_pollutants";
    public static final String COLUMN_POLLUTANT  = "pollutant";
    public static final String COLUMN_POLLUTANTS_LOW= "low";
    public static final String COLUMN_POLLUTANTS_MEDIUM= "medium";
    public static final String COLUMN_POLLUTANTS_HIGH= "high";
    public static final String COLUMN_POLLUTANTS_DANGER= "danger";
    //Table Text
    public static final String TABLE_TEXT= "text_Table";
    public static final String COLUMN_INDEX = "index_Text";
    public static final String COLUMN_TEXT = "text";
    //Table User
    public static final String TABLE_USER= "conditions_Table";
    public static final String COLUMN_USER_ID = "id_user";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_LOCATION = "location";



    //Constructor
    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Table condition
        String CREATE_TABLE_CONDITIONS = "CREATE TABLE " +
                TABLE_CONDITIONS + "(" +
                COLUMN_CONDITIONS_ID + " INTEGER PRIMARY KEY," +
                COLUMN_CONDITION + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_CONDITIONS);
        //Create
        String CREATE_TABLE_POLLUTANTS = "CREATE TABLE " +
                TABLE_POLLUTANTS + "(" +
                COLUMN_POLLUTANTS_ID + " INTEGER PRIMARY KEY," +
                COLUMN_POLLUTANT + " TEXT," +
                COLUMN_POLLUTANTS_LOW + " INTEGER," +
                COLUMN_POLLUTANTS_MEDIUM + " INTEGER," +
                COLUMN_POLLUTANTS_HIGH + " INTEGER," +
                COLUMN_POLLUTANTS_DANGER + " INTEGER" +")";
        db.execSQL(CREATE_TABLE_POLLUTANTS);
        //Create
        String CREATE_TABLE_TEXT = "CREATE TABLE " +
                TABLE_TEXT + "(" +
                COLUMN_CONDITIONS_ID + " INTEGER PRIMARY KEY," +
                COLUMN_POLLUTANTS_ID + " INTEGER,"+
                COLUMN_INDEX + " INTEGER," +
                COLUMN_TEXT + " TEXT" +")";
        db.execSQL(CREATE_TABLE_TEXT);
        //Create
        String CREATE_TABLE_USER = "CREATE TABLE " +
                TABLE_USER + "(" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY," +
                COLUMN_USER_NAME + " TEXT," +
                COLUMN_LOCATION + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_USER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONDITIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLLUTANTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEXT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }







}