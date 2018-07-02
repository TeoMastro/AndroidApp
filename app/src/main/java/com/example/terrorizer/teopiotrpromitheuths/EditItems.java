package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditItems extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);
    Spinner My_spinner;
    EditText onomaProiontos;
    EditText timhProiontos;
    EditText varosProiontos;
    EditText kibProiontos;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaxhrhsh_proiontos);

        My_spinner = (Spinner) findViewById(R.id.chooseProionEdit);
        ArrayList<String> my_array;

        My_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                onomaProiontos = (EditText) findViewById(R.id.onomaProiontosEdit);
                timhProiontos = (EditText) findViewById(R.id.TimhEdit);
                varosProiontos = (EditText) findViewById(R.id.VarosEdit);
                kibProiontos = (EditText) findViewById(R.id.KibEdit);
                int pid = parentView.getSelectedItemPosition() + 1;
                Items item = dbHandler.loadItems(pid);
                if(item != null){
                    onomaProiontos.setText(item.getItemName());
                    timhProiontos.setText(item.getItemPrice());
                    varosProiontos.setText(item.getItemVaros());
                    kibProiontos.setText(item.getItemKib());
                } else {
                    onomaProiontos.setText("NO MOFO FOUND");
                    }
            }
                @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
         });
    }

}

