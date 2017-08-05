package com.sashank.iiitamun.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sashank.iiitamun.AboutMUNActivity;
import com.sashank.iiitamun.Activities.CommitteesActivity;
import com.sashank.iiitamun.R;

public class HomeFragment extends Fragment{

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        TextView mAboutMun = (TextView) v.findViewById(R.id.tv_aboutMun);
        TextView mCommittees = (TextView) v.findViewById(R.id.tv_committees);

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
        return v;
    }

}
