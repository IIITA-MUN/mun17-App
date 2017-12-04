package com.sashank.iiitamun17.Fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.sashank.iiitamun17.Activities.ApplyActivity;
import com.sashank.iiitamun17.R;

public class ApplyFragment extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Apply As:")
                .setItems(R.array.apply_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position) {
                            case 0:
                                Intent i = new Intent(getContext(), ApplyActivity.class);
                                i.putExtra("LINK", "https://docs.google.com/forms/d/e/1FAIpQLSfHE_mLQEqx5JylrIu9mK6QtRBgPep39UoWKg6xLf1dN6i_AA/viewform?c=0&w=1");
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getContext(), ApplyActivity.class);
                                in.putExtra("LINK", "https://docs.google.com/forms/d/e/1FAIpQLScplEIggX-A3kqjI_71a2YcHyXhNYlFHUv8g4LPSqCBCWaeJg/viewform?c=0&w=1&includes_info_params=true");
                                startActivity(in);
                                break;
                        }
                    }
                });
        return builder.create();

    }
}
