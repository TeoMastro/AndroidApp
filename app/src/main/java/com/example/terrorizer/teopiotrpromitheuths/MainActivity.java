package com.example.terrorizer.teopiotrpromitheuths;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button newOrder;
    Button pelatis;
    Button simerinesParaggelies;
    Button proionta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //notificationSystem

        Calendar calc = Calendar.getInstance();
        calc.set(Calendar.HOUR_OF_DAY,15);
        calc.set(Calendar.MINUTE,00);
        calc.set(Calendar.SECOND,30);
        if (calc.getTime().compareTo(new Date()) < 0) calc.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(),NotificationReciever.class);
        intent.setAction("MY_NOTIFICATION_MESSAGE");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calc.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        CalendarView calendarView= findViewById(R.id.calendarView2);
        newOrder = findViewById(R.id.newOrder);  //edw kanw to button na fortwnei allo activity
        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

        pelatis = findViewById(R.id.newPelatis);  //edw kanw to button na fortwnei allo activity
        pelatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPelatis();
            }
        });

        simerinesParaggelies= findViewById(R.id.ordersToday);
        simerinesParaggelies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSimerinesParaggelies();
            }
        });

        proionta = findViewById(R.id.product);
        proionta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProionta();
            }
        });
        Date date = new Date();
        Locale locale = new Locale("el", "GR");
        String dateprint = new SimpleDateFormat("EEEE dd-MM-yyy",locale).format(date);
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(dateprint);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,dayOfMonth);
                Date c = calendar.getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);
                Intent intent = new Intent(MainActivity.this, orderbydate.class);
                intent.putExtra("date",formattedDate);
                startActivity(intent);
            }
        });
    }

    public void openOrder(){  //kaleitai mesw toy onClickListener
        Intent order = new Intent(MainActivity.this , NewOrder.class);
        startActivity(order);
    }

    public void openPelatis(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , ShowPelates.class);
        startActivity(pelatis);
    }

    public void openSimerinesParaggelies(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , OrdersToday.class);
        startActivity(pelatis);
    }

    public void openProionta(){  //kaleitai mesw toy onClickListener
        Intent openProion = new Intent(MainActivity.this , showItems.class);
        startActivity(openProion);
    }


}
