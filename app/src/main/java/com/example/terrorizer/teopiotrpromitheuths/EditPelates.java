package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditPelates extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    Spinner My_spinner;
    EditText PelatisName;
    EditText PelatisAdd;
    EditText PelatisJob;
    EditText PelatisThl;
    EditText PelatisAFM;
    EditText PelatisDOI;
    EditText PelatisTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaxhrhsh_pelatwn);

        My_spinner = (Spinner) findViewById(R.id.Spinner1);
        ArrayList<String> my_array;
        my_array = getTableValues();
        final ArrayAdapter<String> my_Adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, my_array);
        My_spinner.setAdapter(my_Adapter);


        My_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                PelatisName = (EditText) findViewById(R.id.OnomaPelatiEdit);
                PelatisAdd = (EditText) findViewById(R.id.AddressPelatiEdit);
                PelatisJob = (EditText) findViewById(R.id.jobEdit);
                PelatisThl = (EditText) findViewById(R.id.ThlPelatiEdit);
                PelatisAFM = (EditText) findViewById(R.id.AFMPelatiEdit);
                PelatisDOI =  (EditText) findViewById(R.id.doiEdit);
                PelatisTK = (EditText) findViewById(R.id.tkEdit);
                String text = parentView.getSelectedItem().toString();
                String qus = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
                int pid = Integer.parseInt(qus);
                Customer customer = dbHandler.loadCustomer(pid);
                if(customer != null){
                    PelatisName.setText(customer.getPelatisName());
                    PelatisJob.setText(customer.getPelatisJob());
                    PelatisAdd.setText(customer.getPelatisAddress());
                    PelatisThl.setText(customer.getPelatisPhone());
                    PelatisAFM.setText(customer.getPelatisAFM());
                    PelatisDOI.setText(customer.getPelatisDOI());
                    PelatisTK.setText(customer.getPelatisTK());
                } else {
                    PelatisName.setText("NO MOFO FOUND");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
    public ArrayList<String> getTableValues() {
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
    public void updateCustomer(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String text = My_spinner.getSelectedItem().toString();
        String qus = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
        int pid = Integer.parseInt(qus);
        String newname = PelatisName.getText().toString();
        String newadd = PelatisAdd.getText().toString();
        String newphone = PelatisThl.getText().toString();
        String newafm = PelatisAFM.getText().toString();
        String newjob = PelatisJob.getText().toString();
        String newdoi = PelatisDOI.getText().toString();
        String newtk = PelatisTK.getText().toString();
        boolean result = dbHandler.updateCustomer(pid,newname,newadd,newphone,newafm,newjob,newdoi,newtk);
        if (result) {
            Toast.makeText(this, "UPDATE",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "NOT FOUND",
                    Toast.LENGTH_LONG).show();
        }
        finish();
    }

}
