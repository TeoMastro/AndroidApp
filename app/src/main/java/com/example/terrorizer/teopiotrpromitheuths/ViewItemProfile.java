package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewItemProfile extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    TextView name;
    ListView orderlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item_profile);


        name = (TextView) findViewById(R.id.namePelati);
        orderlist = (ListView) findViewById(R.id.listAllOrders);
        TextView addVal = (TextView) findViewById(R.id.addFieldVal);
        TextView phoneVal = (TextView) findViewById(R.id.phoneFieldVal);
        TextView afmVal = (TextView) findViewById(R.id.AFMFieldVal);

        Bundle extras = getIntent().getExtras();
            String myParam = extras.getString("name");
            name.setText(myParam);
        String qus = myParam.substring(myParam.indexOf("(") + 1, myParam.indexOf(")"));
        int pid = Integer.parseInt(qus);
        Items[] items = dbHandler.loadItemsList(pid);
        if(items != null){
            for ( int i=0; i<items.length; i++) {
                addVal.setText(items[i].getItemVaros());
                phoneVal.setText(items[i].getItemPrice() + " €");
                afmVal.setText(items[i].getItemKib());
            }
        }

        loadOrdersItem();
    }
    public void removeItem(View view) {
        Bundle extras = getIntent().getExtras();
        String myParam = extras.getString("name");
        name.setText(myParam);
        String qus = myParam.substring(myParam.indexOf("(") + 1, myParam.indexOf(")"));
        int pid = Integer.parseInt(qus);
        boolean result = dbHandler.deleteItem(pid);
        if (result) {
            Toast.makeText(this, "Το αντικείμενο " + myParam + " διαγράφηκε" , Toast.LENGTH_LONG).show();
            finish();
        } else
            Toast.makeText(this, "Δεν υπάρχει αυτο το αντικείμενο", Toast.LENGTH_LONG).show();
    }
    public void loadOrdersItem() {
        Bundle extras = getIntent().getExtras();
        String myParam = extras.getString("name");
        name.setText(myParam);
        String qus = myParam.substring(myParam.indexOf("(") + 1, myParam.indexOf(")"));
        int pid = Integer.parseInt(qus);
        String temp = dbHandler.loadOrderByItem(pid).toString();
        if(temp != null && !temp.isEmpty()) {
            String qusChoice = temp.substring(0, temp.length() - 1);
            String[] arrayList = qusChoice.split(",");
            ArrayList<String> choiceList = new ArrayList<String>();
            for (int i = 0; i < arrayList.length; i++) {

                choiceList.add(arrayList[i]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, choiceList);
            orderlist.setAdapter(adapter);
        }else {

        }
    }
}
