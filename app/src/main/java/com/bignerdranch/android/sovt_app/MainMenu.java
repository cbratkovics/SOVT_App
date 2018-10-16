package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button mNavigationButton;
    private Button mScheduleButton;
    private Button mTeamsButton;
    private Button mGeneralButton;
    private static final String TAG = "MainMenu";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "MainMenu onSaveInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainMenu onCreate(Bundle) called");
        setContentView(R.layout.activity_main_menu);

        //navigation button
        mNavigationButton = (Button) findViewById(R.id.navigation_button);
        mNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Navigation.class));
            }
        });

        //schedule button
        mScheduleButton = (Button) findViewById(R.id.schedules_button);
        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Schedule.class));
            }
        });

        //team info button
        mTeamsButton = (Button) findViewById(R.id.teams_button);
        mTeamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, TeamInfo.class));
            }
        });

        //general info button
        mGeneralButton = (Button) findViewById(R.id.general_button);
        mGeneralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, General.class));
            }
        });

    }
}
