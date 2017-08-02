package com.sashank.iiitamun.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.sashank.iiitamun.Fragments.HomeFragment;
import com.sashank.iiitamun.R;
import com.sashank.iiitamun.Fragments.ResourcesFragment;
import com.sashank.iiitamun.Fragments.SecretariatFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    ResourcesFragment resourcesFragment;
    SecretariatFragment secretariatFragment;

    BottomNavigationView navigationView;

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

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.getMenu().getItem(1).setChecked(true);
        setFragment(homeFragment);
    }

    private void setFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_locateUs:
                openInMap();
                return true;
            case R.id.menu_credits:
            case R.id.menu_rateUs:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openInMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<25.4304161>,<81.770679>" +
                "?q=<25.4304161>,<81.770679>(Indian Institute of Information Technology, Allahabad)"));

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

        //Location = 25.4304161,81.770679
    }

}

