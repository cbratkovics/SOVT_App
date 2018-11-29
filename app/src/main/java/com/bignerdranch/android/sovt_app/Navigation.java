package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Navigation extends AppCompatActivity {

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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SOVT");

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

        //button to display map of lodge
        mLodgeButton = (Button) findViewById(R.id.lodge_map);
        mLodgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mLodgeButton clicked");
                Intent intent = new Intent(Navigation.this, LodgeMap.class);
                intent.putExtra("ViewType", "assets");
                startActivity(intent);
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
                Intent intent = new Intent(Navigation.this, MainMenu.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
