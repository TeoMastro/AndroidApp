package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewOrder extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    Spinner pelatisSpinner;
    Spinner itemSpinner;
    int minteger = 1;
    TextView itemList;
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        pelatisSpinner = (Spinner) findViewById(R.id.pelatisSpinner);
        itemSpinner = (Spinner) findViewById(R.id.itemSpinner);
        itemList = (TextView) findViewById(R.id.ItemListPrint);


        ArrayList<String> my_array;
        my_array = getPelatesValues();
        final ArrayAdapter<String> my_Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, my_array);
        pelatisSpinner.setAdapter(my_Adapter);

        ArrayList<String> itemarray;
        itemarray = getItemsValues();
        final ArrayAdapter<String> my_Adapters = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, itemarray);
        itemSpinner.setAdapter(my_Adapters);
    }
    public ArrayList<String> getPelatesValues() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<String> my_array = new ArrayList<String>();
        String temp = dbHandler.loadAllCustomer().toString();
        String qusChoice = temp.substring(0,temp.length() - 1);
        String[] arrayList = qusChoice.split(",");
        for (int i = 0; i < arrayList.length; i++) {

            my_array.add(arrayList[i]);
        }
        return my_array;
    }
    public ArrayList<String> getItemsValues() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<String> my_array = new ArrayList<String>();
        String temp = dbHandler.loadAllItems().toString();
        String qusChoice = temp.substring(0,temp.length() - 1);
        String[] arrayList = qusChoice.split(",");
        for (int i = 0; i < arrayList.length; i++) {

            my_array.add(arrayList[i]);
        }
        return my_array;
    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        if(minteger <= 1) {
            display(minteger);
        }else {
            minteger = minteger - 1;
            display(minteger);
        }
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(R.id.posotitaValue);
        displayInteger.setText("" + number);
    }

    public void ItemListUpdate(View view){
        String spinnerPelatisSub = pelatisSpinner.getSelectedItem().toString();
        String pelatisPrint = spinnerPelatisSub.substring(4);
        String spinnerItemSub = itemSpinner.getSelectedItem().toString();
        String itemPrint = spinnerItemSub.substring(4);
        result += System.getProperty("line.separator") +
                "Πελάτης: " + pelatisPrint + System.getProperty("line.separator")
                + "Προϊόν: " + itemPrint + System.getProperty("line.separator")
                + "Ποσότητα: " + String.valueOf(minteger) +
                System.getProperty("line.separator");
        itemList.setText(result);

        String pelatisnosubid = pelatisSpinner.getSelectedItem().toString();
        String qus1 = pelatisnosubid.substring(pelatisnosubid.indexOf("(") + 1, pelatisnosubid.indexOf(")"));
        int pid = Integer.parseInt(qus1);

        String itemnosubid = itemSpinner.getSelectedItem().toString();
        String qus2 = pelatisnosubid.substring(pelatisnosubid.indexOf("(") + 1, pelatisnosubid.indexOf(")"));
        int iid = Integer.parseInt(qus2);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        Orders orders = new Orders(pid,iid,minteger,formattedDate);
        dbHandler.addOrder(orders);


    }

}
