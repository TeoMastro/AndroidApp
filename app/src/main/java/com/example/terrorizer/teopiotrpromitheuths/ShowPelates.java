package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowPelates extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    ListView mListView;
    Button addpelati;
    Button editpelati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pelates);
        mListView = (ListView) findViewById(R.id.list);
        addpelati = (Button) findViewById(R.id.AddPelates);
        editpelati = (Button) findViewById(R.id.EditPelates);

        loadCustomer();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long mylng) {
                Intent intent = new Intent(ShowPelates.this,ViewPelatisProfile.class);
                String name =(mListView.getItemAtPosition(pos).toString());
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        addpelati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPelati();
            }
        });
        editpelati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditPelati();
            }
        });
    }
    public void onResume() {
        super.onResume();
        loadCustomer();
    }

    public void loadCustomer() {
        String temp = dbHandler.loadAllCustomer().toString();
        if(temp != null && !temp.isEmpty()) {
            String qusChoice = temp.substring(0, temp.length() - 1);
            String[] arrayList = qusChoice.split(",");
            ArrayList<String> choiceList = new ArrayList<String>();
            for (int i = 0; i < arrayList.length; i++) {

                choiceList.add(arrayList[i]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(ShowPelates.this, R.layout.support_simple_spinner_dropdown_item, choiceList);
            mListView.setAdapter(adapter);
        }else {

        }
    }

    public void addPelati(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(ShowPelates.this , AddPelates.class);
        startActivity(pelatis);
    }
    public void EditPelati(){  //kaleitai mesw toy onClickListener
        Intent pelatis2 = new Intent(ShowPelates.this , EditPelates.class);
        startActivity(pelatis2);
    }

}
