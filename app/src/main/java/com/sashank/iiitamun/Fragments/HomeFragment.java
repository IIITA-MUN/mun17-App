package com.sashank.iiitamun.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.sashank.iiitamun.Activities.AboutMUNActivity;
import com.sashank.iiitamun.Activities.AboutUsActivity;
import com.sashank.iiitamun.Activities.CommitteesActivity;
import com.sashank.iiitamun.Activities.DeveloperActivity;
import com.sashank.iiitamun.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HomeFragment extends Fragment{

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");

        TextView mAboutMun = (TextView) v.findViewById(R.id.tv_aboutMun);
        TextView mCommittees = (TextView) v.findViewById(R.id.tv_committees);
        TextView mAboutUs = (TextView) v.findViewById(R.id.tv_aboutUs);
        TextView mApply = (TextView) v.findViewById(R.id.tv_apply);
        TextView mBlog = (TextView) v.findViewById(R.id.tv_blog);

        ImageView mLocateUs = (ImageView) v.findViewById(R.id.iv_locate_us);
        ImageView mCredits = (ImageView) v.findViewById(R.id.iv_credits);

        TextView title = (TextView) getActivity().findViewById(R.id.tv_activity_name);
        title.setText(R.string.title_home);
        title.setTypeface(tf);


        mAboutMun.setTypeface(tf);
        mCommittees.setTypeface(tf);
        mAboutUs.setTypeface(tf);
        mApply.setTypeface(tf);


        mAboutMun.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), AboutMUNActivity.class);
                startActivity(i);
            }
        });

        mCommittees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CommitteesActivity.class);
                startActivity(i);
            }
        });

        mAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AboutUsActivity.class));
            }
        });

        mLocateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInMap();
            }
        });

        mCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DeveloperActivity.class));
            }
        });

        mApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://mun.iiita.ac.in/home/apply.html");
            }
        });

        mBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://iiitamun17.wordpress.com/");
            }
        });

        return v;
    }

    public void openInMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<25.4304161>,<81.770679>" +
                "?q=<25.4304161>,<81.770679>(Indian Institute of Information Technology, Allahabad)"));

        if (intent.resolveActivity(getActivity().getPackageManager()) != null)
            startActivity(intent);

        //Location = 25.4304161,81.770679
    }

    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null)
            startActivity(intent);
    }
}
