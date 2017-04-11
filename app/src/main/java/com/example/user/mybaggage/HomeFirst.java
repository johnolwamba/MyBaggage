package com.example.user.mybaggage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class HomeFirst extends AppCompatActivity {
ImageButton imgNuggets,imgLogout,imgNotifications,imgProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgProfile = (ImageButton) findViewById(R.id.imgProfile);
        imgNuggets = (ImageButton) findViewById(R.id.imgNuggets);
        imgLogout = (ImageButton) findViewById(R.id.imgLogout);
        imgNotifications = (ImageButton) findViewById(R.id.imgNotifications);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFirst.this,MyProfile.class);
                startActivity(i);
            }
        });

        imgNuggets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFirst.this,Nuggets.class);
                startActivity(i);
            }
        });

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call logout
            }
        });

        imgNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFirst.this,Notifications.class);
                startActivity(i);
            }
        });






    }

}
