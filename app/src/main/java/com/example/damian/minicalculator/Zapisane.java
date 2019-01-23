package com.example.damian.minicalculator;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Zapisane extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zapisane);

        ArrayList<String> items = getIntent().getStringArrayListExtra(MainActivity.HISTORY);
        ListView listView = findViewById(R.id.resultListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.zapisane_item, items);
        listView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickBackToCalculator(View v) {
        this.finishAndRemoveTask();
    }
}