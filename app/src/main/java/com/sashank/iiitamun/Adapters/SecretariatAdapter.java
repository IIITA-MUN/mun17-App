package com.sashank.iiitamun.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sashank.iiitamun.*;
import com.sashank.iiitamun.Utils.SecretariatPerson;


import java.util.List;

public class SecretariatAdapter extends RecyclerView.Adapter<SecretariatAdapter.AdapterViewHolder> {

    private List<SecretariatPerson> secretariatPersonList;

    public SecretariatAdapter(List<SecretariatPerson> secretariatPersonList){
        this.secretariatPersonList = secretariatPersonList;
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mDescription;


        public AdapterViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mDescription = (TextView) itemView.findViewById(R.id.tv_details);
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
    }

    @Override
    public int getItemCount() {
        return secretariatPersonList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return secretariatPersonList.get(position).isLeft()? 0 : 1 ;
    }
}