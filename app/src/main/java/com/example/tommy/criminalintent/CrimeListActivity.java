package com.example.tommy.criminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by tommy on 4/2/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
