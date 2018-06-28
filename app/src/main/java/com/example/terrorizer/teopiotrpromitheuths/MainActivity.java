package com.example.terrorizer.teopiotrpromitheuths;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button newOrder;
    Button pelatis;
    Button simerinesParaggelies;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

        simerinesParaggelies= (Button) findViewById(R.id.ordersToday);
        simerinesParaggelies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSimerinesParaggelies();
            }
        });

        Date date = new Date();
        Locale locale = new Locale("el", "GR");
        String dateprint = new SimpleDateFormat("EEEE dd-MM-yyy",locale).format(date);
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(dateprint);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        //cal.add(Calendar.HOUR_OF_DAY, 15);
        //(int) AlarmManager.INTERVAL_DAY
        cal.set(Calendar.HOUR_OF_DAY,10);
        cal.set(Calendar.MINUTE,56);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY, broadcast);
    }

    public void openOrder(){  //kaleitai mesw toy onClickListener
        Intent order = new Intent(MainActivity.this , NewOrder.class);
        startActivity(order);
    }

    public void openPelatis(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , Pelatis.class);
        startActivity(pelatis);
    }

    public void openSimerinesParaggelies(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , ShowPelates.class);
        startActivity(pelatis);
    }

    public void addTableRow(){  //dynamikh dhmiourgia table rows
        int arithmosShmerinwnParaggeliwn=2; //o shmerinos arithmos paraggeliwn
        int i=0;
        TableRow seira = new TableRow(this);
        TextView team1 = new TextView(this);
        TextView team2 = new TextView(this);
        TextView team3 = new TextView(this);
        //TableLayout table1 = (TableLayout)findViewById(table);
        for(i=0;i<=arithmosShmerinwnParaggeliwn;i++){

        }
    }

}
