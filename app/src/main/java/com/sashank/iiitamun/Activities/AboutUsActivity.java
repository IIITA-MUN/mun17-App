package com.sashank.iiitamun.Activities;


import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import com.sashank.iiitamun.Adapters.AboutUsPagerAdapter;
import com.sashank.iiitamun.R;

public class AboutUsActivity extends AppCompatActivity {

    private AboutUsPagerAdapter mAboutUsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        mAboutUsPagerAdapter = new AboutUsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.vp_about_us);
        mViewPager.setAdapter(mAboutUsPagerAdapter);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // When the home button is pressed, take the user back to the HomeActivity
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}

