package com.example.user.mybaggage.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.mybaggage.R;

/**
 * Created by apple on 09/04/2017.
 */

public class NotificationsRecyclerAdapter extends  RecyclerView.Adapter<NotificationsRecyclerHolder> {

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    private String[] notificationID;
    private String[] flightNo;
    private String[] luggageNo;
    private String[] date;
    private String[] checkin;
    private String[] sorted;
    private String[] loaded;
    private String[] exit;


    Context context;
    LayoutInflater inflater;
    public NotificationsRecyclerAdapter(Context context,String[] notificationID, String[] flightNo, String[] luggageNo,
                                        String[] date,String[] checkin, String[] sorted,String[] loaded,String[] exit) {
        this.context=context;
        this.notificationID = notificationID;
        this.flightNo = flightNo;
        this.luggageNo = luggageNo;
        this.date = date;
        this.checkin = checkin;
        this.sorted = sorted;
        this.loaded = loaded;
        this.exit = exit;

        inflater=LayoutInflater.from(context);
    }
    @Override
    public NotificationsRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.notifications_list_item, parent, false);

        NotificationsRecyclerHolder viewHolder=new NotificationsRecyclerHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationsRecyclerHolder holder, int position) {
        holder.txtFlightNo.setText(flightNo[position]);
        holder.txtLuggageNo.setText(luggageNo[position]);
        holder.txtDate.setText(date[position]);
    }


    @Override
    public int getItemCount() {
        return notificationID.length;
    }



}


