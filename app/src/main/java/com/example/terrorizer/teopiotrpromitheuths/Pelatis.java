package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Pelatis extends AppCompatActivity {
    EditText onomapelati;
    EditText addresspelati;
    EditText thlpelati;
    EditText afmpelati;
    EditText jobpelati;
    EditText doipelati;
    EditText tkpelati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelatis);
    }
    public void addCustomer(View view) {
        onomapelati = (EditText)findViewById(R.id.onomaPelati);
        addresspelati = (EditText)findViewById(R.id.addressPelati);
        thlpelati = (EditText)findViewById(R.id.thlPelati);
        afmpelati = (EditText)findViewById(R.id.afmPelati);
        jobpelati = (EditText)findViewById(R.id.jobPelati);
        doipelati = (EditText)findViewById(R.id.doiPelati);
        tkpelati = (EditText)findViewById(R.id.tkPelati);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String name = onomapelati.getText().toString();
        String address = addresspelati.getText().toString();
        String thl = thlpelati.getText().toString();
        String afm = afmpelati.getText().toString();
        String doi = doipelati.getText().toString();
        String job = jobpelati.getText().toString();
        String tk = tkpelati.getText().toString();

        Customer customer = new Customer(name,address,thl,afm,job,doi,tk);
        dbHandler.addCustomer(customer);
        onomapelati.setText("");
        addresspelati.setText("");
    }
}
