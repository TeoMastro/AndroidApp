package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowPelates extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pelates);
        mListView = (ListView) findViewById(R.id.list);

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
    }

    public void loadCustomer() {
        String temp = dbHandler.loadAllCustomer().toString();
        String qusChoice = temp.substring(1,temp.length() - 1);
        String[] arrayList = qusChoice.split(",");
        ArrayList choiceList = new ArrayList<String>();
        for (int i = 0; i < arrayList.length; i++) {

            choiceList.add(arrayList[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(ShowPelates.this,R.layout.support_simple_spinner_dropdown_item, choiceList );
        mListView.setAdapter(adapter);
    }


}
