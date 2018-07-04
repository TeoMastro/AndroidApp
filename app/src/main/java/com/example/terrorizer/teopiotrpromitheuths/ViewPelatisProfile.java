package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewPelatisProfile extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pelatis_profile);

        name = (TextView) findViewById(R.id.namePelati);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            String myParam = extras.getString("name");
            name.setText(myParam);
        }
    }
}
