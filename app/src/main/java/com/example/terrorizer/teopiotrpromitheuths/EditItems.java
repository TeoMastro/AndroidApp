package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditItems extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
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
        my_array = getTableValues();
        final ArrayAdapter<String> my_Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, my_array);
        My_spinner.setAdapter(my_Adapter);

        My_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                onomaProiontos = (EditText) findViewById(R.id.onomaProiontosEdit);
                timhProiontos = (EditText) findViewById(R.id.TimhEdit);
                varosProiontos = (EditText) findViewById(R.id.VarosEdit);
                kibProiontos = (EditText) findViewById(R.id.KibEdit);
                String text = parentView.getSelectedItem().toString();
                String qus = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
                int pid = Integer.parseInt(qus);
                Items items = dbHandler.loadItems(pid);
                if(items != null){
                    onomaProiontos.setText(items.getItemName());
                    timhProiontos.setText(items.getItemPrice());
                    varosProiontos.setText(items.getItemVaros());
                    kibProiontos.setText(items.getItemKib());
                } else {
                    onomaProiontos.setText("Not found");
                }
            }
                @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
         });
    }
    public ArrayList<String> getTableValues() {
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
    public void updateItem(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String text = My_spinner.getSelectedItem().toString();
        String qus = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
        int pid = Integer.parseInt(qus);
        String newname = onomaProiontos.getText().toString();
        String newprice = timhProiontos.getText().toString();
        String newvaros = varosProiontos.getText().toString();
        String newkib = kibProiontos.getText().toString();
        boolean result = dbHandler.updateItem(pid,newname,newprice,newvaros,newkib);
        if (result) {
            Toast.makeText(this, "UPDATED",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NOT FOUND",
                    Toast.LENGTH_LONG).show();
        }

        finish();
    }

}

