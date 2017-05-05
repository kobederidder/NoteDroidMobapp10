package com.example.kobe.notedroidmobapp10.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.kobe.notedroidmobapp10.R;
import com.example.kobe.notedroidmobapp10.models.Note;
import com.example.kobe.notedroidmobapp10.models.NoteLijstDAO;
import com.example.kobe.notedroidmobapp10.util.NotitieAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView notitieListView;
    private Button btnNieuw;
    Intent mainIntent;
    Intent specialIntent;
    NotitieAdapter notitieAdapter;
    public Intent preferencesIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notitieListView = (ListView) findViewById(R.id.lv_notitielijst);
        btnNieuw = (Button) findViewById(R.id.btn_nieuw);
        notitieAdapter = new NotitieAdapter(this, NoteLijstDAO.getInstance().getNotitieLijst());
        notitieListView.setAdapter(notitieAdapter);

        btnNieuw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(mainIntent);
            }
        });

        notitieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                specialIntent = new Intent(getApplicationContext(), DetailActivity.class);
                specialIntent.putExtra("aanvullen", true);
                specialIntent.putExtra("selectie", (Note) notitieAdapter.getItem(position));
                startActivity(specialIntent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        notitieAdapter.notifyDataSetChanged();
    }
}
