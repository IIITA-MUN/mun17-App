package com.sashank.iiitamun.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sashank.iiitamun.Fragments.AboutUsFragment;
import com.sashank.iiitamun.Fragments.CommitteesFragment;
import com.sashank.iiitamun.R;

public class AboutUsPagerAdapter extends FragmentPagerAdapter {

    String[] mTitles = {
            "IIITA MUN",
            "SARASVA",
            "EFFERVESCENCE",
            "IIIT ALLAHABAD"
    };


        public AboutUsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new AboutUsFragment();
            Bundle args = new Bundle();
            args.putInt(AboutUsFragment.ARG_SECTION_NUMBER, position);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() { return mTitles.length; }
    }
