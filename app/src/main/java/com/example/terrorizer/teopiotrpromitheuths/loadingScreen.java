package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class loadingScreen extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    for(int i=0;i<100;i++) {
                        progressBar.setProgress(i);
                        sleep(40);
                        //super.run();
                        //sleep(5000);
                    }
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(loadingScreen.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
