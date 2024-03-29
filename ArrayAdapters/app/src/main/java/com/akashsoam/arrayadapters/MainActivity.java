package com.akashsoam.arrayadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.android_versions));
//        listView.setAdapter(adapter);


        CustomAdapter adapter = new CustomAdapter(this, getAndroidVersions());
        listView.setAdapter(adapter);
    }

    private ArrayList<AndroidVersion> getAndroidVersions() {
        AndroidVersion version = new AndroidVersion();
        version.setVersionName("cupcake");
        version.setVersionNum(1.5);
        AndroidVersion version1 = new AndroidVersion();
        version.setVersionName("Donut");
        version.setVersionNum(2.0);
        AndroidVersion version2 = new AndroidVersion();
        version.setVersionName("Eclair");
        version.setVersionNum(3.0);
        AndroidVersion version3 = new AndroidVersion();
        version.setVersionName("Froyo");
        version.setVersionNum(3.2);
        AndroidVersion version4 = new AndroidVersion();
        version.setVersionName("Gingerbread");
        version.setVersionNum(3.5);
        AndroidVersion version5 = new AndroidVersion();
        version.setVersionName("Ice Cream sandwich");
        version.setVersionNum(3.7);
        AndroidVersion version6 = new AndroidVersion();
        version.setVersionName("jellybean");
        version.setVersionNum(3.9);

        ArrayList<AndroidVersion> versionArrayList = new ArrayList<>();
        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version2);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        versionArrayList.add(version);
        versionArrayList.add(version1);
        versionArrayList.add(version2);
        versionArrayList.add(version3);
        versionArrayList.add(version4);
        versionArrayList.add(version5);
        versionArrayList.add(version6);
        return versionArrayList;
    }
}