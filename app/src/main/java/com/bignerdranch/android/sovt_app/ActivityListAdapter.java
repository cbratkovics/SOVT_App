package com.bignerdranch.android.sovt_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityListAdapter extends ArrayAdapter<Activity> {
    private static final String TAG = "ActivityListAdapter";

    private Context mContext;
    int mResource;

    public ActivityListAdapter(Context context, int resource, ArrayList<Activity> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int posistion, View convertView, ViewGroup parent){
        String time = getItem(posistion).getTime();
        String event = getItem(posistion).getEvent();

        Activity activity = new Activity(time, event);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textViewTime = (TextView) convertView.findViewById(R.id.textView1);
        TextView textViewEvent = (TextView) convertView.findViewById(R.id.textView2);

        textViewTime.setText(time);
        textViewEvent.setText(event);

        return convertView;
    }
}
