package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditPelates extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaxhrhsh_pelatwn);

        ArrayList<String> my_array = new ArrayList<String>();

        my_array = getTableValues();
        Spinner My_spinner = (Spinner) findViewById(R.id.Spinner1);
        ArrayAdapter<String> my_Adapter = new ArrayAdapter<String>(this, R.layout.spinner_row, my_array);
        My_spinner.setAdapter(my_Adapter);
    }
    public ArrayList<String> getTableValues() {

        ArrayList<String> my_array = new ArrayList<String>();
        String temp = dbHandler.loadAllCustomer().toString();
        String qusChoice = temp.substring(1,temp.length() - 1);
        String[] arrayList = qusChoice.split(",");
        for (int i = 0; i < arrayList.length; i++) {

            my_array.add(arrayList[i]);
        }
        return my_array;
    }
}
