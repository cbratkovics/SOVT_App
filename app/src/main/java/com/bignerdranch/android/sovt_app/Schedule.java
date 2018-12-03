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
    private static final String KEY_INDEX = "View";
    private FragmentTransaction transaction;
    private int mTransactionIndex = 0;
    private ImageButton mImageButtonGeneral;
    private ImageButton mImageButtonCompetition;
    private LinearLayout mButtonGeneral;
    private LinearLayout mButtonCompetition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG , "Schedule-onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SOVT");

        mButtonGeneral = findViewById(R.id.general_schedule_button);
        mButtonCompetition = findViewById(R.id.competition_schedule_button);
        mImageButtonGeneral = findViewById(R.id.general_schedule_img);
        mImageButtonCompetition= findViewById(R.id.competition_schedule_img);

        if(savedInstanceState != null){
            mTransactionIndex = savedInstanceState.getInt(KEY_INDEX);
        }
        setUpView();

        mButtonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTransactionIndex = 0;
                setUpView();
            }
        });

        mButtonCompetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTransactionIndex = 1;
                setUpView();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        Log.d(TAG,"Schedule-onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mTransactionIndex);
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

    public void setDefaultIc(){
        mImageButtonGeneral.setImageResource(R.drawable.ic_action_schedule);
        mImageButtonCompetition.setImageResource(R.drawable.ic_action_schedule);
    }

    public void setUpView(){
        switch(mTransactionIndex){
            case 0:
                setDefaultIc();
                mImageButtonGeneral.setImageResource(R.drawable.ic_action_schedule_pressed);
                Fragment generalSchedule= new GeneralSchedule();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.schedule, generalSchedule);
                transaction.commit();
                break;
            case 1:
                setDefaultIc();
                mImageButtonCompetition.setImageResource(R.drawable.ic_action_schedule_pressed);
                Fragment competitionSchedule= new CompetitionSchedule();
                transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.schedule, competitionSchedule);
                transaction.commit();
                break;
        }
    }
}