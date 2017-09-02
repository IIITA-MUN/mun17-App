package com.sashank.iiitamun.Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sashank.iiitamun.R;

public class MiscSheetFragment extends BottomSheetDialogFragment{

    private final String mReutersUrl = "https://in.reuters.com/";
    private final String mFactbookUrl = "https://www.cia.gov/library/publications/the-world-factbook/";
    private final String mWorldBankUrl = "https://data.worldbank.org/";

    @Override
    public void setupDialog(Dialog dialog, int style) {

        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.res_detail_sheet, null);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");


        TextView mWorldBank = ((TextView) contentView.findViewById(R.id.tv_sheet1));
        TextView mFactBook = ((TextView) contentView.findViewById(R.id.tv_sheet2));
        TextView mReuters = ((TextView) contentView.findViewById(R.id.tv_sheet3));
        TextView mAljazeera = ((TextView) contentView.findViewById(R.id.tv_sheet4));
        TextView mBritannica = ((TextView) contentView.findViewById(R.id.tv_sheet5));

        (contentView.findViewById(R.id.ll_sheet4)).setVisibility(View.VISIBLE);
        (contentView.findViewById(R.id.ll_sheet5)).setVisibility(View.VISIBLE);

        mWorldBank.setText(R.string.res_world_bank);
        mFactBook.setText(R.string.res_factbook);
        mReuters.setText(R.string.res_reuters);
        mAljazeera.setText(R.string.res_aljazeera);
        mBritannica.setText(R.string.res_britannica);

        mFactBook.setTypeface(tf);
        mReuters.setTypeface(tf);
        mWorldBank.setTypeface(tf);
        mAljazeera.setTypeface(tf);
        mBritannica.setTypeface(tf);

        ((ImageView) contentView.findViewById(R.id.iv_sheet1)).setImageResource(R.drawable.world_bank);
        ((ImageView) contentView.findViewById(R.id.iv_sheet2)).setImageResource(R.drawable.cia);
        ((ImageView) contentView.findViewById(R.id.iv_sheet3)).setImageResource(R.drawable.reuters);
        ((ImageView) contentView.findViewById(R.id.iv_sheet4)).setImageResource(R.drawable.aljazeera);
        ((ImageView) contentView.findViewById(R.id.iv_sheet5)).setImageResource(R.drawable.britannica);



        mWorldBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mWorldBankUrl);
            }
        });



        mFactBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mFactbookUrl);
            }
        });

        mReuters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(mReutersUrl);
            }
        });

        dialog.setContentView(contentView);

    }

    public void openWebPage(String url){
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null)
            startActivity(intent);
    }
}
