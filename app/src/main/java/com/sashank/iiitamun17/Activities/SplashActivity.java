package com.sashank.iiitamun17.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sashank.iiitamun17.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView mDaysLeft = (TextView) findViewById(R.id.tv_days_left);
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/SourceSansPro-Regular.ttf");

        /*try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            // Here Set your Event Date
            Date futureDate = dateFormat.parse("2017-10-07");
            Date currentDate = new Date();
            //Log.d("DAY " , futureDate.toString());
            //Log.d("DAY " , currentDate.toString());
            if (!currentDate.after(futureDate)) {
                long diff = futureDate.getTime()
                        - currentDate.getTime();
                long days = diff / (24 * 60 * 60 * 1000);
                String daysLeft = Long.toString(days) + " DAYS TO GO!";
                mDaysLeft.setText(daysLeft);
                Log.d("DAYS LEFT" , Long.toString(days));
                mDaysLeft.setTypeface(tf);
            }
            else{
                mDaysLeft.setVisibility(View.GONE);
            }

        }catch(Exception e){
            e.printStackTrace();
        }*/

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}
