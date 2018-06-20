package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText user = (EditText) findViewById(R.id.user);
                String username = user.getText().toString();

                EditText pass = (EditText) findViewById(R.id.pass);
                String password = pass.getText().toString();
                TextView error = (TextView)findViewById(R.id.error);
                if(username.equals("admin") && password.equals("123")) {
                    Intent mainact = new Intent(LoginScreen.this , MainActivity.class);
                    startActivity(mainact);
                }else {
                    error.setText("ERROR TRY AGAIN");
                    error.setTextSize(20);
                    error.setVisibility(View.VISIBLE);
                }
            }
        });
        }
    }

