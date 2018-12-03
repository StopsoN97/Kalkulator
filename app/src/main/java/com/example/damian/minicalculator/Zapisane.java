package com.example.damian.minicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.TextView;

import java.util.ArrayList;

public class Zapisane extends AppCompatActivity /*extends MainActivity*/ {
    //private TextView textViewSaved,textViewResult;

    /*private void init() {

     //textViewSaved.setText("siema");

     }*/

    //TextView tv1;

	//otwieranie nowego okienka
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zapisane);

        //B
        ArrayList<String> items = getIntent().getStringArrayListExtra(MainActivity.HISTORY);
        ListView listView = findViewById(R.id.ListViewResult);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.zapisane_item, items);
        //listView.setAdapter(adapter);
        
        //init();
    }
}