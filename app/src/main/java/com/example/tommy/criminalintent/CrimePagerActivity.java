package com.example.tommy.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by tommy on 4/7/2015.
 */
public class CrimePagerActivity extends FragmentActivity implements CrimeFragment.Callbacks {
    private static final String TAG = "CrimePager";
    private ViewPager mViewPager;
    private ArrayList<Crime> mCrimes;

    public void onCrimeUpdated(Crime crime) {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mCrimes = CrimeLab.get(this).getmCrimes();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int pos) {
                Crime crime = mCrimes.get(pos);
                Log.d(TAG, "CrimePager:getItem"+pos);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                Log.d(TAG, "CrimePager:getCount"+mCrimes.size());
                return mCrimes.size();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}

            public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {}

            public void onPageSelected(int pos) {
                Crime crime = mCrimes.get(pos);
                if (crime.getmTitle() != null) {
                    setTitle(crime.getmTitle());
                }
            }
        });

        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i=0; i<mCrimes.size(); i++) {
            if (mCrimes.get(i).getmId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
