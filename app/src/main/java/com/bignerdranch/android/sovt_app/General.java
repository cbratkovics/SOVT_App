package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.io.File;

public class General extends AppCompatActivity {

    private static final String TAG = "GeneralInfo";
    private Button mCompetitionButton;
    private Button mMealsButton;
    private Button mMedicalButton;
    private Button mWeatherButton;
    private Button mParkingButton;
    private Button mFriendsButton;
    private Button mOathButton;
    private Button mConcussionButton;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "GeneralInfo onSaveInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        Log.d(TAG, "GeneralInfo onCreate(Bundle) called");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //mCompetition Button when clicked will open up a new activity "activity_pdf"
        //in which the relevant pages of the pdf will be displayed
        mCompetitionButton = (Button) findViewById(R.id.competition_button);
        mCompetitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[2];
                page[0] = 3;
                page[1] = 4;
                Log.d(TAG, "mCompetitionButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mMealsButton = (Button) findViewById(R.id.meals_button);
        mMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[2];
                page[0] = 4;
                page[1] = 5;
                Log.d(TAG, "mMealsButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mMedicalButton = (Button) findViewById(R.id.medical_button);
        mMedicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[1];
                page[0] = 7;
                Log.d(TAG, "mMedicalButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mWeatherButton = (Button) findViewById(R.id.weather_button);
        mWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[1];
                page[0] = 8;
                Log.d(TAG, "mWeatherButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mParkingButton = (Button) findViewById(R.id.parking_button);
        mParkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[1];
                page[0] = 8;
                Log.d(TAG, "mParkingButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mFriendsButton = (Button) findViewById(R.id.friends_button);
        mFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[1];
                page[0] = 9;
                Log.d(TAG, "mFriendsButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mOathButton = (Button) findViewById(R.id.oath_button);
        mOathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[3];
                page[0] = 10;
                page[1] = 11;
                page[2] = 12;
                Log.d(TAG, "mOathButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        mConcussionButton = (Button) findViewById(R.id.concussion_button);
        mConcussionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] page = new int[1];
                page[0] = 13;
                Log.d(TAG, "mConcussionButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ViewType", "assets");
                extras.putIntArray("PAGE", page);
                intent.putExtras(extras);
                startActivity(intent);
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
                Intent intent = new Intent(General.this, MainMenu.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}