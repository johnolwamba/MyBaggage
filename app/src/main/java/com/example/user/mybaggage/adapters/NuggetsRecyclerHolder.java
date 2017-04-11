package com.example.user.mybaggage.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mybaggage.R;

/**
 * Created by apple on 08/04/2017.
 */

public class NuggetsRecyclerHolder extends RecyclerView.ViewHolder {

    TextView txtNuggetDescription;
    ImageView imgIcon;

    public NuggetsRecyclerHolder(View itemView) {
        super(itemView);

        txtNuggetDescription= (TextView) itemView.findViewById(R.id.txtNuggetDescription);
        imgIcon= (ImageView) itemView.findViewById(R.id.imgIcon);


    }
}
