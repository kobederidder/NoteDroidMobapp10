package com.example.kobe.notedroidmobapp10.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kobe on 5/05/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "noteDroidDB";
    private final static int DB_VERSION = 1;
    private final static String TABLE_COMMENT = "notities";
    private final static String COLUMN_ID = "_id";
    private final static String COLUMN_TITEL = "titel";
    private final static String COLUMN_INHOUD = "inhoud";
    private final static String COLUMN_DATUM_AANMAAK = "datum_aanmaak";
    private final static String COLUMN_DATUM_AANGEPAST = "datum_aangepast";

    private final static String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_TITEL, COLUMN_INHOUD, COLUMN_DATUM_AANMAAK, COLUMN_DATUM_AANGEPAST};

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_COMMENT + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITEL + " TEXT NOT NULL," + COLUMN_INHOUD + " TEXT NOT NULL" + " );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: te weten komen wat hier moet
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}
