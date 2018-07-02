package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddItems extends AppCompatActivity {
    EditText onomaProiontos;
    EditText timhProiontos;
    EditText varosProiontos;
    EditText kibProiontos;
    LinearLayout mainLayout;
    Button prosthikiProiontwn;
    Button diaxhrhshProiontwn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proionta);

        prosthikiProiontwn = (Button)findViewById(R.id.prosthikiProiontos);
        prosthikiProiontwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProion();
            }
        });
        diaxhrhshProiontwn = (Button)findViewById(R.id.diaxeirhProiontonEdit);
        diaxhrhshProiontwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiaxeirhshProiontwn();
            }
        });
    }

    public void addProion(){
        onomaProiontos = (EditText)findViewById(R.id.onomaProiontosAdd);
        timhProiontos = (EditText)findViewById(R.id.TimhAdd);
        varosProiontos = (EditText)findViewById(R.id.VarosAdd);
        kibProiontos = (EditText)findViewById(R.id.KibAdd);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String onoma = onomaProiontos.getText().toString();
        String timh = timhProiontos.getText().toString();
        String varos = varosProiontos.getText().toString();
        String kib = kibProiontos.getText().toString();

        Items item = new Items(onoma , timh , varos , kib);
        dbHandler.addItem(item);
        onomaProiontos.setText("");
        timhProiontos.setText("");
        varosProiontos.setText("");
        kibProiontos.setText("");

        mainLayout = (LinearLayout)findViewById(R.id.linearButtonAddProion);
        MessageBox("Το προιόν " + onoma + " προσθέθηκε με επιτυχία! \n Αν θέλετε μπορείτε να προσθέσετε καινούργιο προιόν");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

    }

    public void MessageBox(String message)
    {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void openDiaxeirhshProiontwn(){  //kaleitai mesw toy onClickListener
        Intent diaxeirhshProiontwn = new Intent(this , EditItems.class);
        startActivity(diaxeirhshProiontwn);
    }
}
