package com.akashsoam.fragmentintroduction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AndroidVersionInterface{
    private FrameLayout fragmentContainer;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragment_container);



        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        DemoFragment demoFragment = new DemoFragment();
        fragmentTransaction.add(fragmentContainer.getId(), demoFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onVersionItemClick(String versionName) {
        Toast.makeText(this, "Clicked "+versionName, Toast.LENGTH_SHORT).show();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("versionName", versionName);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_detail_container,detailFragment);
        fragmentTransaction.commit();
    }
}