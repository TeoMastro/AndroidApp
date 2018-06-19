package com.example.terrorizer.teopiotrpromitheuths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        EditText user = (EditText) findViewById(R.id.user);
        String username = user.getText().toString();

        EditText pass = (EditText) findViewById(R.id.pass);
        String password = pass.getText().toString();


    }
}
