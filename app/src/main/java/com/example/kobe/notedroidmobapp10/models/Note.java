package com.example.kobe.notedroidmobapp10.models;

/**
 * Created by kobe on 5/05/2017.
 */

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Note implements Comparable, Serializable {
    private int id;
    private String titel, inhoud;
    private Date aanmaakDatum, laatsteWijziging;

    public Note() {
    }

    public Note(String titel, String inhoud, Date aanmaakDatum, Date laatsteWijziging) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakDatum = aanmaakDatum;
        this.laatsteWijziging = laatsteWijziging;
    }

    public static Comparator<Note> sorteerTitelComp() {
        Comparator comp = new Comparator<Note>(){
            @Override
            public int compare(Note o1, Note o2) {
                return o1.getTitel().compareTo(o2.getTitel());

            }
        };
        return comp;
    }

    public static Comparator<Note> sorteerDatumComp() {
        Comparator comp = new Comparator<Note>(){
            @Override
            public int compare(Note o1, Note o2) {
                return o1.getAanmaakDatum().compareTo(o2.getAanmaakDatum());
            }
        };
        return comp;
    }


    public static Comparator<Note> sorteerDatumCompReverse() {
        Comparator comp = new Comparator<Note>(){
            @Override
            public int compare(Note o1, Note o2) {
                return (o1.getAanmaakDatum().compareTo(o2.getAanmaakDatum())) * -1;
            }
        };
        return comp;
    }


    public int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public Date getLaatsteWijziging() {
        return laatsteWijziging;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
