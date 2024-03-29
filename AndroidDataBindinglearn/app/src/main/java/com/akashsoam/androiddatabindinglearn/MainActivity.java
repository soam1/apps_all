package com.akashsoam.androiddatabindinglearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.akashsoam.androiddatabindinglearn.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public class ClickEventHandler{
        private Context mContext;

        public ClickEventHandler(Context context) {
            mContext = context;
        }
        public void textViewClick(View view){
            Toast.makeText(mContext, "textview is clicked", Toast.LENGTH_SHORT).show();
        }
        public void textViewClickWithParams(View view, String category){
            Toast.makeText(mContext, category, Toast.LENGTH_SHORT).show();

        }
    }
    private ClickEventHandler mClickEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMyviewmodel(new MyViewModel());
        activityMainBinding.getMyviewmodel().taskName = "Programming";

        activityMainBinding.setTaskCategory("Business");

        activityMainBinding.tv3.setText(R.string.health_bulk);


        mClickEventHandler = new ClickEventHandler(this);
        activityMainBinding.setClickEventHandler(mClickEventHandler);


    }
}