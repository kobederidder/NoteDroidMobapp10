package com.example.kobe.notedroidmobapp10.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import com.example.kobe.notedroidmobapp10.R;
import com.example.kobe.notedroidmobapp10.models.Note;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kobe on 5/05/2017.
 */

public class NotitieAdapter extends BaseAdapter implements Filterable {
    //TODO: filter bijstellen
    @Override
    public Filter getFilter() {
        return null;
    }

    private class ViewHolder{
        public TextView tvTitel;
        public TextView tvAanmaakDatum;
    }

    private ViewHolder holder;
    private static ArrayList<Note> notitieLijst;
    private Activity context;

    public NotitieAdapter(Activity context , ArrayList<Note> notitieLijst) {
        this.notitieLijst = notitieLijst;
        this.context = context;

        Collections.sort(notitieLijst);
    }


    public static void sorteerTitelOplopend() {
        Collections.sort(notitieLijst, Note.sorteerTitelComp());
    }

    public static void sorteerDatumOplopend() {
        Collections.sort(notitieLijst, Note.sorteerDatumComp());
    }

    public static void sorteerDatumAflopend() {
        Collections.sort(notitieLijst, Note.sorteerDatumCompReverse());
    }



    @Override
    public int getCount() {
        return notitieLijst.size();
    }

    @Override
    public Object getItem(int position) {
        return notitieLijst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return notitieLijst.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = context.getLayoutInflater().inflate(R.layout.notitie_row, parent, false);

            holder = new ViewHolder();

            holder.tvTitel = (TextView) convertView.findViewById(R.id.tv_titel);
            holder.tvAanmaakDatum = (TextView) convertView.findViewById(R.id.tv_aanmaakdatum);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = notitieLijst.get(position);

        holder.tvTitel.setText(note.getTitel());
        holder.tvAanmaakDatum.setText(note.getAanmaakDatum().toString());

        return convertView;
    }

}
