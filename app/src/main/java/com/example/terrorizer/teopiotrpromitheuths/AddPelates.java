package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddPelates extends AppCompatActivity {
    EditText onomapelati;
    EditText addresspelati;
    EditText thlpelati;
    EditText afmpelati;
    EditText jobpelati;
    EditText doipelati;
    EditText tkpelati;
    LinearLayout mainLayout;
    Button AddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelatis);

        AddBtn = (Button)findViewById(R.id.AddBtn);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
            }
        });
    }

    public void addCustomer() {
        onomapelati = (EditText)findViewById(R.id.OnomaPelati);
        addresspelati = (EditText)findViewById(R.id.AddressPelati);
        thlpelati = (EditText)findViewById(R.id.ThlPelati);
        afmpelati = (EditText)findViewById(R.id.AFMPelati);
        jobpelati = (EditText)findViewById(R.id.JobPelati);
        doipelati = (EditText)findViewById(R.id.DOIpelati);
        tkpelati = (EditText)findViewById(R.id.TKPelati);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String name = onomapelati.getText().toString();
        String address = addresspelati.getText().toString();
        String thl = thlpelati.getText().toString();
        String afm = afmpelati.getText().toString();
        String doi = doipelati.getText().toString();
        String job = jobpelati.getText().toString();
        String tk = tkpelati.getText().toString();
        if (name.matches("") || address.matches("") || thl.matches("") || afm.matches("") || doi.matches("") || job.matches("") || tk.matches("")) {
            Toast.makeText(this, "Έχει κενά πεδία", Toast.LENGTH_SHORT).show();
            return;
        }else {

            Customer customer = new Customer(name, address, thl, afm, job, doi, tk);
            dbHandler.addCustomer(customer);
            onomapelati.setText("");
            addresspelati.setText("");
            thlpelati.setText("");
            afmpelati.setText("");
            jobpelati.setText("");
            doipelati.setText("");
            tkpelati.setText("");


        mainLayout = (LinearLayout)findViewById(R.id.linearAddBtn);
        MessageBox("Ο Πελάτης " + name + " προσθέθηκε με επιτυχία! \n Αν θέλετε μπορείτε να προσθέσετε καινουργιο πελάτη");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

        finish();
        }
    }

    public void MessageBox(String message)
    {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
