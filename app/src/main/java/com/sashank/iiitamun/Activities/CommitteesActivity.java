package com.sashank.iiitamun.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.sashank.iiitamun.Adapters.CommitteesPagerAdapter;
import com.sashank.iiitamun.R;

public class CommitteesActivity extends AppCompatActivity {

    CommitteesPagerAdapter mCommitteesPagerAdapter;
    ViewPager mViewPager;

    private void setupViewpager() {
        mCommitteesPagerAdapter = new CommitteesPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mCommitteesPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committees);
        setupViewpager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // When the home button is pressed, take the user back to the VisualizerActivity
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
