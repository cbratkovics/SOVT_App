package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Navigation extends AppCompatActivity {

    private Button mHomeButton;
    private Button mMountainButton;
    private Button mLodgeButton;
    private Button mDirectionsButton;
    private static final String TAG = "Navigation";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Navigation onSaveInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Log.d(TAG, "Navigation onCreate(Bundle) called");

        //return to home page button
        mHomeButton = (Button) findViewById(R.id.home_button);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this, MainMenu.class));
            }
        });

        //button to display map of mountain
        mMountainButton = (Button) findViewById(R.id.mountain_map);
        mMountainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mMountainButton clicked");
                Intent intent = new Intent(Navigation.this, PicoMap.class);
                intent.putExtra("ViewType", "assets");
                startActivity(intent);
            }
        });

        //button to display map of lodging
        mLodgeButton = (Button) findViewById(R.id.lodge_map);
        mLodgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Navigation.this, MainMenu.class));
            }
        });

        //button to allow users to access google maps for directions
        mDirectionsButton = (Button) findViewById(R.id.directions);
        mDirectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Navigation.this, MainMenu.class));
            }
        });

    }
}
