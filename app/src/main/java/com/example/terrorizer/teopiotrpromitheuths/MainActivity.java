package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button newOrder;
    Button pelatis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newOrder = (Button)findViewById(R.id.newOrder);  //edw kanw to button na fortwnei allo activity
        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

        pelatis = (Button)findViewById(R.id.newPelatis);  //edw kanw to button na fortwnei allo activity
        pelatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPelatis();
            }
        });

        Calendar calendar = Calendar.getInstance();  //gia thn hmerominia
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(currentDate);
    }

    public void openOrder(){  //kaleitai mesw toy onClickListener
        Intent order = new Intent(MainActivity.this , NewOrder.class);
        startActivity(order);
    }

    public void openPelatis(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , Pelatis.class);
        startActivity(pelatis);
    }


}
