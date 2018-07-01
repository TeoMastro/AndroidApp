package com.example.terrorizer.teopiotrpromitheuths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditProin extends AppCompatActivity {
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
        final ArrayAdapter<String> my_Adapter = new ArrayAdapter<String>(this, R.layout.spinner_row, my_array);
        My_spinner.setAdapter(my_Adapter);


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
            public void onNothingSelected(AdapterView<?> adapterView) {

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
            public void updateCustomer(View view) {
                MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
                int pid = My_spinner.getSelectedItemPosition() + 1;
                onomaProiontos = (EditText) findViewById(R.id.onomaProiontosAdd);
                String name = onomaProiontos.getText().toString();
                String timh = timhProiontos.getText().toString();
                String varos = varosProiontos.getText().toString();
                String kib = kibProiontos.getText().toString();
                boolean result = dbHandler.updateCustomer(pid,name,timh,varos,kib);
                if (result) {
                    Toast.makeText(this, "UPDATE",
                            Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(this, "NOT FOUND",
                            Toast.LENGTH_LONG).show();
            }
}
