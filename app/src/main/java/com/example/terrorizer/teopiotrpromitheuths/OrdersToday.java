package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class OrdersToday extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simerines_paraggelies);
        result = (TextView) findViewById(R.id.fill11);

        ArrayList<String> my_array;
        my_array = getTableValues();

        float totalmoney=0;
        if(my_array.size() != 0) {
            for (int i = 0; i < my_array.size(); i++) {
                if(i==0) {
                    String firstname = my_array.get(i).substring(my_array.get(i).indexOf("(") + 1, my_array.get(i).indexOf(")"));
                    totalmoney = Float.parseFloat(my_array.get(i).substring(my_array.get(i).indexOf("{") + 1, my_array.get(i).indexOf("}")));
                    String orderline = my_array.get(i).substring(my_array.get(i).indexOf(">") + 1, my_array.get(i).indexOf("<"));
                    result.append(firstname);
                    result.append(System.getProperty("line.separator"));
                    result.append("_____________________________");
                    result.append(System.getProperty("line.separator"));
                    result.append(orderline);
                    result.append(System.getProperty("line.separator"));
                }else {
                    String prevname = my_array.get(i-1).substring(my_array.get(i-1).indexOf("(") + 1, my_array.get(i-1).indexOf(")"));
                    String pname = my_array.get(i).substring(my_array.get(i).indexOf("(") + 1, my_array.get(i).indexOf(")"));
                    String orderline = my_array.get(i).substring(my_array.get(i).indexOf(">") + 1, my_array.get(i).indexOf("<"));
                    if(prevname.matches(pname)) {
                        totalmoney = totalmoney + Float.parseFloat(my_array.get(i).substring(my_array.get(i).indexOf("{") + 1, my_array.get(i).indexOf("}")));
                        result.append(orderline);
                        result.append(System.getProperty("line.separator"));
                    }else{
                        result.append("Συνολική τιμή: " + totalmoney + " €");
                        totalmoney=0;
                        result.append(System.getProperty("line.separator"));
                        result.append(System.getProperty("line.separator"));
                        result.append(pname);
                        result.append(System.getProperty("line.separator"));
                        result.append("_____________________________");
                        result.append(System.getProperty("line.separator"));
                        result.append(orderline);
                        result.append(System.getProperty("line.separator"));
                    }
                }
            }
            result.append("Συνολική τιμή: " + totalmoney + " €");
        }
    }

    public ArrayList<String> getTableValues() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<String> my_array = new ArrayList<String>();
        String temp = dbHandler.TodayOrders().toString();
        if(!temp.isEmpty()) {
            String qusChoice = temp.substring(0, temp.length() - 1);
            String[] arrayList = qusChoice.split("/");
            for (int i = 0; i < arrayList.length; i++) {

                my_array.add(arrayList[i]);
            }
        }
        return my_array;
    }
}
