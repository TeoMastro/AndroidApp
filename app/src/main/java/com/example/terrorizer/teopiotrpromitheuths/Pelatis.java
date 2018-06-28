package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Pelatis extends AppCompatActivity {
    EditText onomapelati;
    EditText addresspelati;
    EditText thlpelati;
    EditText afmpelati;
    EditText jobpelati;
    EditText doipelati;
    EditText tkpelati;
    LinearLayout mainLayout;
    Button diaxeirhshPelatwnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelatis);

        diaxeirhshPelatwnButton = (Button)findViewById(R.id.diaxeirhProiontonEdit);
        diaxeirhshPelatwnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiaxeirhshPelatwn();
            }
        });
    }

    public void addCustomer(View view) {
        onomapelati = (EditText)findViewById(R.id.onomaProiontosEdit);
        addresspelati = (EditText)findViewById(R.id.VarosEdit);
        thlpelati = (EditText)findViewById(R.id.timhEdit);
        afmpelati = (EditText)findViewById(R.id.KivotioEdit);
        jobpelati = (EditText)findViewById(R.id.jobPelatiEdit);
        doipelati = (EditText)findViewById(R.id.doiPelatiEdit);
        tkpelati = (EditText)findViewById(R.id.tkPelatiEdit);

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
        thlpelati.setText("");
        afmpelati.setText("");
        jobpelati.setText("");
        doipelati.setText("");
        tkpelati.setText("");

        mainLayout = (LinearLayout)findViewById(R.id.linearButtonAddProion);
        MessageBox("Ο Πελάτης " + name + " προσθέθηκε με επιτυχία! \n Αν θέλετε μπορείτε να προσθέσετε καινουργιο πελάτη");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

    public void MessageBox(String message)
    {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void openDiaxeirhshPelatwn(){  //kaleitai mesw toy onClickListener
        Intent diaxeirhshPelatwn = new Intent(this , diaxhrhshPelatwn.class);
        startActivity(diaxeirhshPelatwn);
    }
}
