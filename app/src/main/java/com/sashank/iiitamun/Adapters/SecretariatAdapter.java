package com.sashank.iiitamun.Adapters;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sashank.iiitamun.*;
import com.sashank.iiitamun.Fragments.DetailInfoFragment;
import com.sashank.iiitamun.Fragments.SecretariatFragment;
import com.sashank.iiitamun.Utils.SecretariatPerson;


import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class SecretariatAdapter extends RecyclerView.Adapter<SecretariatAdapter.AdapterViewHolder> {

    private List<SecretariatPerson> secretariatPersonList;
    private Context context;
    private FragmentManager fm;

    public SecretariatAdapter(Context context, List<SecretariatPerson> secretariatPersonList, FragmentManager fragmentManager){
        this.secretariatPersonList = secretariatPersonList;
        this.context = context;
        this.fm = fragmentManager;
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mDescription;
        private final ImageView mCall;
        private final ImageView mEmail;
        private final ImageView mFaceBook;
        private final ImageView mProfile;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mDescription = (TextView) itemView.findViewById(R.id.tv_details);

            mCall = (ImageView) itemView.findViewById(R.id.bt_call);
            mEmail = (ImageView) itemView.findViewById(R.id.bt_email);
            mFaceBook = (ImageView) itemView.findViewById(R.id.bt_facebook);

            mProfile = (ImageView) itemView.findViewById(R.id.iv_profile);

        }
    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = null;
        switch (viewType){
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card , parent, false);
                break;
            case 1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card2 , parent, false);
                break;
        }
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/RobotoCondensed-Regular.ttf");
        Typeface tfb = Typeface.createFromAsset(context.getAssets(),
                "fonts/RobotoCondensed-Bold.ttf");

        holder.mTitle.setTypeface(tfb);
        holder.mDescription.setTypeface(tf);

        holder.mTitle.setText(secretariatPersonList.get(position).getName());
        holder.mDescription.setText(secretariatPersonList.get(position).getDesignation());
        holder.mProfile.setImageResource(secretariatPersonList.get(position).getImageRef());

        position = holder.getAdapterPosition();
        final int finalPosition = position;

        holder.mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callNumber = secretariatPersonList.get(finalPosition).getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +callNumber));
                context.startActivity(intent);
            }
        });

        holder.mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = secretariatPersonList.get(finalPosition).getEmailLink();
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",emailId, null));
                context.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

        holder.mFaceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fbId = secretariatPersonList.get(finalPosition).getFbLink();
                Intent intent = getOpenFacebookIntent(context,fbId);
                context.startActivity(intent);

            }
        });



        /*holder.mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailInfoFragment dialog = new DetailInfoFragment();
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                View view = inflater.inflate(R.layout.detail_dialog,null);

                String bio = secretariatPersonList.get(finalPosition).getBio();
                Log.d("BIO",bio);




                TextView detail = (TextView) view.findViewById(R.id.tv_person_detail_text);
                detail.setText(bio);

                Log.d("BIO_UPDATE",detail.getText().toString());

                dialog.show(fm, "ProfileDetailFragment");
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return secretariatPersonList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return secretariatPersonList.get(position).isLeft()? 0 : 1 ;
    }

    private static Intent getOpenFacebookIntent(Context context, String Id) {

        Intent intent = null;
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            String url = "https://www.facebook.com/"+Id;
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href="+url));
        } catch (Exception e) {
            // no Facebook app, revert to browser
            String url = "https://facebook.com/"+Id;
            intent = new Intent(Intent.ACTION_VIEW);
            intent .setData(Uri.parse(url));
        }
        return intent;
    }

    /*private void showPopup(View v){
        final LinearLayout mainLayout = (LinearLayout) v.findViewById(R.id.activity_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.popup_layout,mainLayout);


        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        parentView.getForeground().setAlpha( 220); // dim


        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
               parentView.getForeground().setAlpha(0); // restore
                return true;
            }
        });
    }*/
}