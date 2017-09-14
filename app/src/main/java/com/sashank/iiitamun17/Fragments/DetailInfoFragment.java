package com.sashank.iiitamun17.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.sashank.iiitamun17.R;

public class DetailInfoFragment extends DialogFragment{

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.detail_dialog,null);

        builder.setView(view);
        return builder.create();
    }

}
