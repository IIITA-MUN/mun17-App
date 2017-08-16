package com.sashank.iiitamun.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sashank.iiitamun.R;

/**
 * Created by sashank on 5/8/17.
 */

public class CommitteesFragment extends Fragment {

    public static final String ARG_OBJECT = "object";

    int[] mDetails = { R.string.detail_disec , R.string.detail_sc};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_committees, container, false);

        Bundle args = getArguments();
        int position = args.getInt(ARG_OBJECT);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");

        TextView textCommittees = (TextView) v.findViewById(R.id.tv_committees_detail);
        textCommittees.setText(mDetails[position]);
        textCommittees.setTypeface(tf);

        return v;
    }
}
