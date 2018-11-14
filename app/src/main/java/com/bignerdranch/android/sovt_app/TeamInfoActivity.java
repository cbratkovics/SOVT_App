package com.bignerdranch.android.sovt_app;


import android.support.v4.app.Fragment;
import android.util.Log;

public class TeamInfoActivity extends FragmentActivity {
    private static final String TAG = "TeamInfoActivity";

    @Override
    protected Fragment createFragment() {
        Log.d(TAG, "createFragment() called, creating TeamInfoFragment");
        return new TeamInfoFragment();
    }

}
