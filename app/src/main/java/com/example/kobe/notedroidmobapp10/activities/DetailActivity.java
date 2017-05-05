package com.example.kobe.notedroidmobapp10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kobe.notedroidmobapp10.R;
import com.example.kobe.notedroidmobapp10.models.Note;
import com.example.kobe.notedroidmobapp10.models.NoteLijstDAO;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


public class DetailActivity extends AppCompatActivity {
    private Button btnSave, btnCancel, btnDelete;
    private EditText etTitel, etInhoud;
    Intent detailIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        NoteLijstDAO.getInstance();

        btnSave = (Button) findViewById(R.id.btn_save);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        etTitel = (EditText) findViewById(R.id.et_title);
        etInhoud = (EditText) findViewById(R.id.et_notitie);

        if(getIntent().getBooleanExtra("aanvullen", false)) {
            Note n = (Note) getIntent().getSerializableExtra("selectie");

            etTitel.setText(n.getTitel());
            etInhoud.setText(n.getInhoud());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTitel.getText().toString().length() > 0) {
                    NoteLijstDAO.addNotitie(etTitel.getText().toString(), etInhoud.getText().toString(), new Date(), new Date());
                    detailIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(detailIntent);
                    //TODO entry wijzigen
                } else {
                    Toast.makeText(getApplicationContext(), "Er is geen titel, zo niet eh!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTitel.setText("");
                etInhoud.setText("");
                detailIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(detailIntent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detailIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(detailIntent);
            }
        });
    }
}
