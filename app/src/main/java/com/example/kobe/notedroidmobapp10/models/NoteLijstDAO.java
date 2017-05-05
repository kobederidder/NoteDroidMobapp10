package com.example.kobe.notedroidmobapp10.models;

/**
 * Created by kobe on 5/05/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

public class NoteLijstDAO {
    private SQLHelper dbHelper;
    private SQLiteDatabase db;

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

    public static void addNotitie(String titel, String inhoud, Date aanmaakDatum, Date laatsteWijziging) {

    }

    public ArrayList<Note> getNotitieLijst() {
        ArrayList<Note> notitieLijst = new ArrayList<>();


        //TODO invullen


        return notitieLijst;
    }
}
