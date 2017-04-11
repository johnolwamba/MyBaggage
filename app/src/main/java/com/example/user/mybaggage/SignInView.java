package com.example.user.mybaggage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignInView extends AppCompatActivity {
    TextView txtForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_view);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnProfile = (Button) findViewById(R.id.btnProfile);
        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(SignInView.this, HomeFirst.class);
                startActivity(login);
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ForgotPassword = new Intent(SignInView.this,ForgotPassword.class);
                startActivity(ForgotPassword);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createProfile = new Intent(SignInView.this, CreateProfileView.class);
                startActivity(createProfile);
            }
        });





    }
}
