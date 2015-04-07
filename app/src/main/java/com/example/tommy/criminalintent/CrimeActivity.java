package com.example.tommy.criminalintent;

import android.support.v4.app.FragmentActivity;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected android.support.v4.app.Fragment createFragment() {
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);
    }
}
