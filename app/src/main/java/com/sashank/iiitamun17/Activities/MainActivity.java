package com.sashank.iiitamun17.Activities;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sashank.iiitamun17.Fragments.HomeFragment;
import com.sashank.iiitamun17.R;
import com.sashank.iiitamun17.Fragments.ResourcesFragment;
import com.sashank.iiitamun17.Fragments.SecretariatFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    ResourcesFragment resourcesFragment;
    SecretariatFragment secretariatFragment;

    BottomNavigationView navigationView;
    FragmentManager fm;
    Boolean exitToast;

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

        exitToast = true;
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_custom);
        ((TextView)findViewById(R.id.tv_activity_name)).setText(R.string.app_name);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.getMenu().getItem(1).setChecked(true);
        setFragment(homeFragment);
    }

    private void setFragment(Fragment f) {
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (fm.getFragments() == null) {
            ft.add(R.id.frame, f).commit();
            return;
        }
        if (fm.getFragments().contains(f)) {
            for (Fragment fragment : fm.getFragments()) {
                if (fragment != null) {
                    ft.hide(fragment);
                }
            }
            ft.show(f);
        } else {
            for (Fragment fragment : fm.getFragments()) {
                if (fragment != null) {
                    ft.hide(fragment);
                }
            }
            ft.add(R.id.frame, f);
        }

        if(f instanceof HomeFragment)
            setMainTitle(R.string.title_home);
        else if(f instanceof ResourcesFragment)
            setMainTitle(R.string.title_resources);
        else if(f instanceof SecretariatFragment)
            setMainTitle(R.string.title_secretariat);

        ft.commit();
    }

    private void setMainTitle(int StringVal) {
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/SourceSansPro-Regular.ttf");
        TextView title = (TextView) findViewById(R.id.tv_activity_name);
        title.setText(StringVal);
        title.setTypeface(tf);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.locate_us:
                openInMap();
                return true;
            case R.id.rate_us:
                return true;
            case R.id.web:
                openWebPage("http://mun.iiita.ac.in");
                return true;
            case R.id.credits:
                startActivity(new Intent(this,DeveloperActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openInMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<25.4304161>,<81.770679>" +
                "?q=<25.4304161>,<81.770679>(Indian Institute of Information Technology, Allahabad)"));

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

        //Location = 25.4304161,81.770679
    }

    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getPackageManager())!= null)
            startActivity(intent);
    }
}

