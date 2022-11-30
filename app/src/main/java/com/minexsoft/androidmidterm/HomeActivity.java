package com.minexsoft.androidmidterm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private EditText usernameTxt;
    private EditText passwordTxt;

    private static String username;
    private static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button registerBtn = findViewById(R.id.registerBtn);
        Button loginBtn = findViewById(R.id.loginBtn);

        usernameTxt = findViewById(R.id.usernameTextView);
        passwordTxt = findViewById(R.id.passwordTextView);

        Switch activeSwitch = findViewById(R.id.activeSwitch);
        activeSwitch.setChecked(true);

        activeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                registerBtn.setEnabled(true);
                loginBtn.setEnabled(true);
            } else {
                registerBtn.setEnabled(false);
                loginBtn.setEnabled(false);
            }
        });

        registerBtn.setOnClickListener(view -> {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivityForResult(registerIntent, 1, null);
        });

        loginBtn.setOnClickListener(view -> {

            if (!usernameTxt.getText().toString().equals("") && !passwordTxt.getText().toString().equals("")) {

                if (usernameTxt.getText().toString().equals(username) && passwordTxt.getText().toString().equals(password)) {
                    Intent welcomeScreen = new Intent(this, WelcomeActivity.class);
                    welcomeScreen.putExtra("username", usernameTxt.getText().toString());
                    startActivity(welcomeScreen);
                }
                else if (username == null || password == null) {
                    Toast.makeText(this, "No username " + usernameTxt.getText().toString() + " or " + " Password " + passwordTxt.getText().toString() + " in our database.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Username/Password is empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                username = data.getStringExtra("username");
                password = data.getStringExtra("password");
            }
        }
    }
}