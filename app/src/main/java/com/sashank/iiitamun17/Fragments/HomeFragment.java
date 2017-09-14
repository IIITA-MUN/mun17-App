package com.sashank.iiitamun17.Fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sashank.iiitamun17.Activities.AboutMUNActivity;
import com.sashank.iiitamun17.Activities.AboutUsActivity;
import com.sashank.iiitamun17.Activities.CommitteesActivity;
import com.sashank.iiitamun17.R;

public class HomeFragment extends Fragment{

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");

        ImageView mAboutMun = (ImageView) v.findViewById(R.id.iv_about_mun);
        ImageView mCommittees = (ImageView) v.findViewById(R.id.iv_committees);
        ImageView mAboutUs = (ImageView) v.findViewById(R.id.iv_about_us);
        ImageView mApply = (ImageView) v.findViewById(R.id.iv_apply);
        ImageView mBlog = (ImageView) v.findViewById(R.id.iv_blog);

        TextView title = (TextView) getActivity().findViewById(R.id.tv_activity_name);
        title.setText(R.string.title_home);
        title.setTypeface(tf);

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

        mApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyFragment fg = new ApplyFragment();
                fg.show(getFragmentManager(),"ApplyFragment");
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


    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null)
            startActivity(intent);
    }
}
