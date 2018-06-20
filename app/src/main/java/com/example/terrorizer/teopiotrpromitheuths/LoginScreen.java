package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                EditText pass = (EditText) findViewById(R.id.pass);
                TextView error = (TextView) findViewById(R.id.error);

                String username = user.getText().toString();
                String password = pass.getText().toString();

                if(username.equals("admin") && password.equals("123")) {
                    Intent main = new Intent(LoginScreen.this , MainActivity.class);
                    startActivity(main);
                 }else{
                    error.setText("ΔΕΝ ΕΙΝΑΙ ΔΥΝΑΤΗ Η ΣΥΝΔΕΣΗ, ΔΟΚΙΜΑΣΤΕ ΞΑΝΑ");
                    error.setTextSize(20);
                }
            }
        });



    }
}
