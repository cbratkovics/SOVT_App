package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class General extends AppCompatActivity {

    private Button mHomeButton;
    private static final String TAG = "GeneralInfo";
    private Button mInfoButton;

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

        //return to home page button
        mHomeButton = (Button) findViewById(R.id.home_button);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mHomeButton clicked");
                startActivity(new Intent(General.this, MainMenu.class));
            }
        });

        //mInfo Button when clicked will open up a new activity "activity_pdf"
        //in which the pdf will be displayed
        mInfoButton = (Button) findViewById(R.id.info_button);
        mInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "mInfoButton clicked");
                Intent intent = new Intent(General.this, PDFActivity.class);
                intent.putExtra("ViewType", "assets");
                startActivity(intent);
            }
        });

    }
}