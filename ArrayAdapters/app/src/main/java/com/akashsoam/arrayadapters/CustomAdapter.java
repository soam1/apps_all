package com.akashsoam.arrayadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AndroidVersion> versionArrayList;

    public CustomAdapter(Context context, ArrayList<AndroidVersion> versionArrayList) {
        this.context = context;
        this.versionArrayList = versionArrayList;
    }

    @Override
    public int getCount() {
        if (versionArrayList != null && versionArrayList.size() > 0) return versionArrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return versionArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.version_list_item, parent, false);
        }
//        LinearLayout mainLayout = convertView.findViewById(R.id.)
        TextView txtVersionName = convertView.findViewById(R.id.tv_version_name);
        TextView txtVersionNum = convertView.findViewById(R.id.tv_version_num);

        txtVersionName.setText( versionArrayList.get(position).getVersionName());
        txtVersionNum.setText(String.format("version: %s", versionArrayList.get(position).getVersionNum()));

        return convertView;

    }
}
