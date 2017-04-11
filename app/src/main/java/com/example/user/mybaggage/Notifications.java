package com.example.user.mybaggage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.user.mybaggage.adapters.AlertDialogManager;
import com.example.user.mybaggage.adapters.NotificationsRecyclerAdapter;
import com.example.user.mybaggage.adapters.NuggetsRecyclerAdapter;

import java.util.ArrayList;

public class Notifications extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<String> listnotificationID = new ArrayList();
    ArrayList<String> listflightNo = new ArrayList();
    ArrayList<String> listluggageNo = new ArrayList();
    ArrayList<String> listDate = new ArrayList();
    ArrayList<String> listCheckin = new ArrayList();
    ArrayList<String> listSorted = new ArrayList();
    ArrayList<String> listLoaded = new ArrayList();
    ArrayList<String> listExit = new ArrayList();

    ProgressDialog pDialog;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

      recyclerView= (RecyclerView) findViewById(R.id.notificationsRecycler);
        prepareData();
        Log.d("listNugget_size",listflightNo.size()+"");

        NotificationsRecyclerAdapter adapter=new NotificationsRecyclerAdapter(Notifications.this,listnotificationID.toArray(new String[listnotificationID.size()]),
                listflightNo.toArray(new String[listflightNo.size()]),listluggageNo.toArray(new String[listluggageNo.size()]),
                listDate.toArray(new String[listDate.size()]),listCheckin.toArray(new String[listCheckin.size()]),
                listSorted.toArray(new String[listSorted.size()]),listLoaded.toArray(new String[listLoaded.size()]),listExit.toArray(new String[listExit.size()]));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Notifications.this));

    }


    public void prepareData(){

        listnotificationID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listDate.add("12-09-2017");
        listCheckin.add("1");
        listSorted.add("1");
        listLoaded.add("1");
        listExit.add("1");

        listnotificationID.add("2");
        listflightNo.add("123455");
        listluggageNo.add("L_21");
        listDate.add("12-09-2017");
        listCheckin.add("1");
        listSorted.add("1");
        listLoaded.add("1");
        listExit.add("1");

        listnotificationID.add("3");
        listflightNo.add("12345555");
        listluggageNo.add("L_21");
        listDate.add("12-09-2017");
        listCheckin.add("1");
        listSorted.add("1");
        listLoaded.add("1");
        listExit.add("1");

        listnotificationID.add("1");
        listflightNo.add("12345");
        listluggageNo.add("L_21");
        listDate.add("12-09-2017");
        listCheckin.add("1");
        listSorted.add("1");
        listLoaded.add("1");
        listExit.add("1");




    }


    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(Notifications.this,HomeFirst.class);
        startActivity(i);
        Notifications.this.finish();

    }

}
