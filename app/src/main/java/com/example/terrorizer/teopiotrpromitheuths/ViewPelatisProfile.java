package com.example.terrorizer.teopiotrpromitheuths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewPelatisProfile extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pelatis_profile);

        name = (TextView) findViewById(R.id.namePelati);
        TextView addVal = (TextView) findViewById(R.id.addFieldVal);
        TextView phoneVal = (TextView) findViewById(R.id.phoneFieldVal);
        TextView afmVal = (TextView) findViewById(R.id.AFMFieldVal);
        TextView jobVal = (TextView) findViewById(R.id.proffesionFieldVal);
        TextView doiVal = (TextView) findViewById(R.id.doiFieldVal);
        TextView tkVal = (TextView) findViewById(R.id.taxCodeFieldVal);

        Bundle extras = getIntent().getExtras();
            String myParam = extras.getString("name");
            name.setText(myParam);
        String qus = myParam.substring(myParam.indexOf("(") + 1, myParam.indexOf(")"));
        int pid = Integer.parseInt(qus);
        Customer customer = dbHandler.loadCustomer(pid);
        if(customer != null){
            addVal.setText(customer.getPelatisAddress());
            phoneVal.setText(customer.getPelatisPhone());
            afmVal.setText(customer.getPelatisAFM());
            jobVal.setText(customer.getPelatisJob());
            doiVal.setText(customer.getPelatisDOI());
            tkVal.setText(customer.getPelatisTK());
        }
    }
}
