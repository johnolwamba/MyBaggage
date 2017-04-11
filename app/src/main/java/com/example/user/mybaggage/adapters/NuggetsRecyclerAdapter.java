package com.example.user.mybaggage.adapters;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mybaggage.R;

/**
 * Created by apple on 08/04/2017.
 */

public class NuggetsRecyclerAdapter extends  RecyclerView.Adapter<NuggetsRecyclerHolder> {

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    private String[] nuggetID;
    private String[] nuggetDescription;
    private String[] nuggetImage;

    Context context;
    LayoutInflater inflater;
    public NuggetsRecyclerAdapter(Context context,String[] nuggetID, String[] nuggetDescription,String[] nuggetImage) {
        this.context=context;
        this.nuggetID = nuggetID;
        this.nuggetDescription = nuggetDescription;
        this.nuggetImage = nuggetImage;

       inflater=LayoutInflater.from(context);
    }
    @Override
    public NuggetsRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.nuggets_list_item, parent, false);

        NuggetsRecyclerHolder viewHolder=new NuggetsRecyclerHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NuggetsRecyclerHolder holder, int position) {
        holder.txtNuggetDescription.setText(nuggetDescription[position]);

        Resources res = context.getResources();
        String mDrawableName = nuggetImage[position];
        int resID = res.getIdentifier(mDrawableName , "drawable", context.getPackageName());
        holder.imgIcon.setImageResource(resID);

        //holder.tv2.setText(cardNo[position]);
    }


    @Override
    public int getItemCount() {
        return nuggetID.length;
    }



}


