package com.sashank.iiitamun.Adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sashank.iiitamun.*;
import com.sashank.iiitamun.Utils.SecretariatPerson;


import java.util.List;

public class SecretariatAdapter extends RecyclerView.Adapter<SecretariatAdapter.AdapterViewHolder> {

    private List<SecretariatPerson> secretariatPersonList;
    Context context;

    public SecretariatAdapter(Context context, List<SecretariatPerson> secretariatPersonList){
        this.secretariatPersonList = secretariatPersonList;
        this.context = context;
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mDescription;
        private final ImageButton mCall;
        private final ImageButton mEmail;
        private final ImageButton mFaceBook;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mDescription = (TextView) itemView.findViewById(R.id.tv_details);

            mCall = (ImageButton) itemView.findViewById(R.id.bt_call);
            mEmail = (ImageButton) itemView.findViewById(R.id.bt_email);
            mFaceBook = (ImageButton) itemView.findViewById(R.id.bt_facebook);

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
        holder.mTitle.setText(secretariatPersonList.get(position).getName());
        holder.mDescription.setText(secretariatPersonList.get(position).getDesignation());

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
    }

    @Override
    public int getItemCount() {
        return secretariatPersonList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return secretariatPersonList.get(position).isLeft()? 0 : 1 ;
    }

    public static Intent getOpenFacebookIntent(Context context, String Id) {

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

}