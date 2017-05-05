package com.example.kobe.notedroidmobapp10.models;

/**
 * Created by kobe on 5/05/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.kobe.notedroidmobapp10.activities.DetailActivity;

import java.util.ArrayList;
import java.util.Date;

public class NoteLijstDAO {
    private SQLHelper dbHelper;
    private static SQLiteDatabase db;

    private static NoteLijstDAO ourInstance = new NoteLijstDAO();

    public static NoteLijstDAO getInstance() {
        return ourInstance;
    }

    public void openConnection(Context context1) {
        dbHelper = new SQLHelper(context1);
        db = dbHelper.getWritableDatabase();
    }

    public NoteLijstDAO(Context context2) {
        dbHelper = new SQLHelper(context2);
    }

    public  void open() {
        db = dbHelper.getWritableDatabase();
    }

    public  void close() {
        dbHelper.close();
    }

    private NoteLijstDAO() {

    }

    public static void addNotitie(Note n) {
        ContentValues cv = new ContentValues();
        cv.put("COLUMN_TITEL", n.getTitel());
        cv.put("COLUMN_INHOUD", n.getInhoud());
        cv.put("COLUMN_DATUM_AANMAAK", new Date().toString());
        cv.put("COLUMN_DATUM_AANGEPAST", new Date().toString());



        db.insert("noteDroidDB", null, cv);

    }



    public ArrayList<Note> getNotitieLijst() {
        ArrayList<Note> notitieLijst = new ArrayList<>();


        //TODO invullen


        return notitieLijst;
    }

    public void delete(Note n)
    {
        int id = n.getId();
        db.delete("notes", "_id =" + id, null);
    }
}
