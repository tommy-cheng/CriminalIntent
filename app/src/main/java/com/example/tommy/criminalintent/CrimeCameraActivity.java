package com.example.tommy.criminalintent;


import android.support.v4.app.Fragment;
/**
 * Created by tommy on 4/17/2015.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
