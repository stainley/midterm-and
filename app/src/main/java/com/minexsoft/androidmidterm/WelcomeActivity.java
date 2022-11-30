package com.minexsoft.androidmidterm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView welcomeUser = findViewById(R.id.welcomeMessageTxt);

        Intent userLogged = getIntent();
        String username = userLogged.getStringExtra("username");
        welcomeUser.setText("Welcome " + username);
    }
}