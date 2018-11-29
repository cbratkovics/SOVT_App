package com.bignerdranch.android.sovt_app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class Schedule extends AppCompatActivity {

    private static final String TAG = "Schedule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Log.d(TAG , "onCreate Started!");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SOVT");

        LinearLayout mButtonGeneral = findViewById(R.id.general_schedule_button);
        LinearLayout mButtonCompetition = findViewById(R.id.competition_schedule_button);
        final ImageButton mImageButtonGeneral = findViewById(R.id.general_schedule_img);
        final ImageButton mImageButtonCompetition= findViewById(R.id.competition_schedule_img);

        Fragment generalSchedule= new GeneralSchedule();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.schedule, generalSchedule);
        transaction.addToBackStack(null);
        transaction.commit();

        mButtonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDefaultIc(mImageButtonGeneral,mImageButtonCompetition);
                mImageButtonGeneral.setImageResource(R.drawable.ic_action_schedule_pressed);

                Fragment generalSchedule= new GeneralSchedule();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.schedule, generalSchedule);
                transaction.commit();
            }
        });

        mButtonCompetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDefaultIc(mImageButtonGeneral,mImageButtonCompetition);
                mImageButtonCompetition.setImageResource(R.drawable.ic_action_schedule_pressed);

                Fragment competitionSchedule= new CompetitionSchedule();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.schedule, competitionSchedule);
                transaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.go_home:
                Intent intent = new Intent(Schedule.this, MainMenu.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void setDefaultIc(ImageButton general, ImageButton competition){
        general.setImageResource(R.drawable.ic_action_schedule);
        competition.setImageResource(R.drawable.ic_action_schedule);
    }
}