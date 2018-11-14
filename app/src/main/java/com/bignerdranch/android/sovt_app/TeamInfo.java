package com.bignerdranch.android.sovt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TeamInfo extends AppCompatActivity {

    private Button mHomeButton;
    private static final String TAG = "TeamInfo";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "TeamInfo onSaveInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        Log.d(TAG, "TeamInfo onCreate(Bundle) called");

        //return to home page button
        mHomeButton = (Button) findViewById(R.id.home_button);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamInfo.this, MainMenu.class));
            }
        });


        readTeamInfo();
    }

    private List<DelegationContact> mDelegationContacts = new ArrayList<DelegationContact>();
    private void readTeamInfo() {
        InputStream is = getResources().openRawResource(R.raw.winter_team_delegations);
        //parse csv line by line
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        //try catch to handle IOExceptions
        try {
            //Step over headers
            br.readLine();

            while ((line = br.readLine()) != null) {
                Log.d(TAG, "Line: " + line);

                //split data by ","
                String[] tokens = line.split(",");

                //Read the data
                DelegationContact contact = new DelegationContact(tokens[0], tokens[1], tokens[2]);
                mDelegationContacts.add(contact);

                Log.d(TAG, "Just created: "+ contact);
            }
        } catch (IOException e) {
            Log.i(TAG, "Error reading data on line" + line);
            e.printStackTrace();
        }
    }
}
