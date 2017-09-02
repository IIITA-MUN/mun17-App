package com.sashank.iiitamun.Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sashank.iiitamun.R;

public class DisecSheetFragment extends BottomSheetDialogFragment{


    @Override
    public void setupDialog(Dialog dialog, int style) {

        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.res_detail_sheet, null);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");


        TextView mLink1 = ((TextView) contentView.findViewById(R.id.tv_sheet1));
        TextView mLink2 = ((TextView) contentView.findViewById(R.id.tv_sheet2));
        TextView mLink3 = ((TextView) contentView.findViewById(R.id.tv_sheet3));

        mLink1.setTypeface(tf);
        mLink2.setTypeface(tf);
        mLink3.setTypeface(tf);

        ((ImageView) contentView.findViewById(R.id.iv_sheet1)).setImageResource(R.drawable.un_logo);
        ((ImageView) contentView.findViewById(R.id.iv_sheet2)).setImageResource(R.drawable.pdf);
        ((ImageView) contentView.findViewById(R.id.iv_sheet3)).setImageResource(R.drawable.pdf);


        mLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("http://www.un.org/en/ga/first/");
            }
        });


        mLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openWebPage(mWorldBankUrl);
                Toast.makeText(getContext(),"Will be out soon!",Toast.LENGTH_SHORT).show();

            }
        });


        mLink3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openWebPage(mFactbookUrl);
                //Toast.makeText(getContext(),"Will be out soon!",Toast.LENGTH_SHORT).show();
                openWebPage("https://docs.google.com/spreadsheets/d/1vW9L9g4Ps01Ppj_znxJge7-YTOsGeybGuCuKmPqdJ3o/edit?ts=599814e8#gid=1203201757");
            }
        });


        dialog.setContentView(contentView);

    }

    public void openWebPage(String url) {
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null)
            startActivity(intent);
    }

}