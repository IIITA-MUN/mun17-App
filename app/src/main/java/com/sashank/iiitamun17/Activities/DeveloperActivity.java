package com.sashank.iiitamun17.Activities;

import android.graphics.Typeface;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.sashank.iiitamun17.R;

public class DeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        ActionBar actionBar = this.getSupportActionBar();

        // Set the action bar back button to look like an up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/RobotoCondensed-Regular.ttf");

        Typeface tfb = Typeface.createFromAsset(getAssets(),
                "fonts/RobotoCondensed-Bold.ttf");

        ((TextView)findViewById(R.id.tv_app_developer)).setTypeface(tfb);
        ((TextView)findViewById(R.id.tv_app_developer_name)).setTypeface(tf);
        ((TextView)findViewById(R.id.tv_creatives)).setTypeface(tfb);
        ((TextView)findViewById(R.id.tv_creatives_name1)).setTypeface(tf);
        ((TextView)findViewById(R.id.tv_creatives_name2)).setTypeface(tf);

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
