package com.akashsoam.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.my_listview);

        String[] myPlanets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> myPlanetList = new ArrayList<>();
        myPlanetList.addAll(Arrays.asList(myPlanets));


        listAdapter = new ArrayAdapter<String>(this, R.layout.my_row, myPlanetList);
        mListView.setAdapter(listAdapter);

    }
}