package com.bignerdranch.android.sovt_app;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//based on BNR ch 8 & 9 -> ContactList
/** part of model layer **/

//this is a singleton class, allows only one instance of itself to be created
public class ContactList {

    private static ContactList sContactList;
    private static final String TAG = "ContactList";

    private List<Contact> mContacts;


    //public get method that is called to initialize an instance of ContactList
    public static ContactList get(Context context) {
        Log.d(TAG, "getContactList(context): " + context);

        //if no instance, call private constructor
        if (sContactList == null) {
            sContactList = new ContactList(context);
        }

        //return the newly created ContactList, or the one that was there before
        return sContactList;
    }


    //private constructor that reads the team info from csv into a list of contacts
    private ContactList(Context context) {
        Log.d(TAG, "CL constructor called with context: " + context);
        mContacts = new ArrayList<>();
        readTeamInfo(context);
    }


    //returns the list of contacts
    public List<Contact> getContacts() {
        return mContacts;
    }

    public Contact getContact(UUID id) {
        for (Contact contact : mContacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }


    //PUT DOCUMENTATION / CREDIT HERE
    //reads in the team info from the specified raw resource file
    private void readTeamInfo(Context context) {
        Log.d(TAG, "readTeamInfo() called");
        InputStream is = context.getResources().openRawResource(R.raw.winter_teams);

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
                Contact contact = new Contact(tokens[0], tokens[1], tokens[2]);
                mContacts.add(contact);

                Log.d(TAG, "Just created: "+ contact);
            }
        } catch (IOException e) {
            Log.i(TAG, "Error reading data on line" + line);
            e.printStackTrace();
        }
    }
}
