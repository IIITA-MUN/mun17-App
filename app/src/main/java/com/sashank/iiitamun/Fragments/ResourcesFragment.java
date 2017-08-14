package com.sashank.iiitamun.Fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TextView;

import com.sashank.iiitamun.R;

public class ResourcesFragment extends Fragment{

    private final String mReutersUrl = "https://in.reuters.com/";
    private final String mFactbookUrl = "https://www.cia.gov/library/publications/the-world-factbook/";
    private final String mWorldBankUrl = "https://data.worldbank.org/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_resources,container,false);

        TextView mReuters = (TextView) v.findViewById(R.id.tv_reuters);
        TextView mFactbook = (TextView) v.findViewById(R.id.tv_cia_world_factbook);
        TextView mWorldbank = (TextView) v.findViewById(R.id.tv_world_bank);
        TextView mUnhrcBg = (TextView) v.findViewById(R.id.tv_bg_unhrc);
        TextView mEuBg = (TextView) v.findViewById(R.id.tv_bg_eu);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");
        mReuters.setTypeface(tf);
        mFactbook.setTypeface(tf);
        mWorldbank.setTypeface(tf);
        mUnhrcBg.setTypeface(tf);
        mEuBg.setTypeface(tf);


        mReuters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mReutersUrl);
            }
        });

        mFactbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mFactbookUrl);

            }
        });

        mWorldbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mWorldBankUrl);
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
