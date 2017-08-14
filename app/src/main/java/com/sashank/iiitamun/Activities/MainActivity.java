package com.sashank.iiitamun.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.StackView;
import android.widget.TextView;
import android.widget.Toast;

import com.sashank.iiitamun.Fragments.HomeFragment;
import com.sashank.iiitamun.R;
import com.sashank.iiitamun.Fragments.ResourcesFragment;
import com.sashank.iiitamun.Fragments.SecretariatFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    ResourcesFragment resourcesFragment;
    SecretariatFragment secretariatFragment;

    BottomNavigationView navigationView;
    FragmentManager fm;
    private boolean backTrace;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(homeFragment);
                    return true;
                case R.id.navigation_resources:
                    setFragment(resourcesFragment);
                    return true;
                case R.id.navigation_secretariat:
                    setFragment(secretariatFragment);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        init();
    }

    private void assignViews() {
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private void init() {
        homeFragment = new HomeFragment();
        resourcesFragment = new ResourcesFragment();
        secretariatFragment = new SecretariatFragment();

        backTrace = false;

        /*ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().
                inflate(R.layout.actionbar_custom, null);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(actionBarLayout);*/


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_custom);
        ((TextView)findViewById(R.id.tv_activity_name)).setText(R.string.app_name);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.getMenu().getItem(1).setChecked(true);
        setFragment(homeFragment);
    }

    private void setFragment(Fragment f) {
        fm = getSupportFragmentManager();
        if (fm.getFragments() == null) {
            fm.beginTransaction().add(R.id.frame, f).commit();
            return;
        }
        if (fm.getFragments().contains(f)) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment fragment : fm.getFragments()) {
                if (fragment != null) {
                    ft.hide(fragment);
                }
            }
            ft.show(f);
            ft.commit();
        } else {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment fragment : fm.getFragments()) {
                if (fragment != null) {
                    ft.hide(fragment);
                }
            }
            ft.add(R.id.frame, f);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

