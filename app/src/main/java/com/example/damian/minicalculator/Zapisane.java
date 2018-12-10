package com.example.damian.minicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Zapisane extends AppCompatActivity {
    private TextView textViewSaved;

    private void init() {

        textViewSaved = findViewById(R.id.textViewSaved);
        textViewSaved.setText("siema");

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zapisane);
        init();
    }
}