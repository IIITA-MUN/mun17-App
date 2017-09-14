package com.sashank.iiitamun17.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sashank.iiitamun17.R;

public class ResourcesFragment extends Fragment{



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_resources,container,false);

        ImageView mDisec = (ImageView) v.findViewById(R.id.iv_disec);
        ImageView mSc = (ImageView) v.findViewById(R.id.iv_sc);
        ImageView mMisc = (ImageView) v.findViewById(R.id.iv_misc);

        mDisec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisecSheetFragment dialog = new DisecSheetFragment();
                dialog.show(getActivity().getSupportFragmentManager(), "ModalFragment");

            }
        });

        mSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScSheetFragment dialog = new ScSheetFragment();
                dialog.show(getActivity().getSupportFragmentManager(), "ModalFragment");
            }
        });
        
        mMisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MiscSheetFragment dialog = new MiscSheetFragment();
                dialog.show(getActivity().getSupportFragmentManager(), "ModalFragment");
            }
        });



        /*TextView mReuters = (TextView) v.findViewById(R.id.tv_reuters);
        TextView mFactbook = (TextView) v.findViewById(R.id.tv_cia_world_factbook);
        TextView mWorldbank = (TextView) v.findViewById(R.id.tv_world_bank);
        TextView mDisecBg = (TextView) v.findViewById(R.id.tv_bg_disec);
        TextView mScBg = (TextView) v.findViewById(R.id.tv_bg_sc);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");
        mReuters.setTypeface(tf);
        mFactbook.setTypeface(tf);
        mWorldbank.setTypeface(tf);
        mDisecBg.setTypeface(tf);
        mScBg.setTypeface(tf);

        TextView title = (TextView) getActivity().findViewById(R.id.tv_activity_name);
        title.setText(R.string.title_resources);
        title.setTypeface(tf);

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

        mDisecBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Will be out soon!",Toast.LENGTH_LONG).show();
            }
        });

        mScBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Will be out soon!",Toast.LENGTH_LONG).show();
            }
        });*/


        return v;
    }



}
