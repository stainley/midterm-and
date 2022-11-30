package com.minexsoft.androidmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private String username;
    private String password;

    private EditText usernameText;

    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameText = findViewById(R.id.createUserTxt);
        passwordText = findViewById(R.id.createPassTxt);


        Button register = findViewById(R.id.registerUserPassBtn);
        register.setOnClickListener(view -> {
            username = usernameText.getText().toString();
            password = passwordText.getText().toString();

            Intent homeIntent = new Intent();
            homeIntent.putExtra("username", username);
            homeIntent.putExtra("password", password);

            Toast.makeText(this, "Username has been registered", Toast.LENGTH_LONG).show();
            setResult(RESULT_OK, homeIntent);
            finish();
        });
    }

}