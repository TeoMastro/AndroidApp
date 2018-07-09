package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showItems extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 2);
    ListView mListView;
    Button addItem;
    Button editItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);
        mListView = (ListView) findViewById(R.id.listProion);
        addItem = (Button) findViewById(R.id.AddItems);
        editItem = (Button) findViewById(R.id.EditItems);

        loadItem();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long mylng) {
                Intent intent = new Intent(showItems.this,ViewItemProfile.class);
                String name =(mListView.getItemAtPosition(pos).toString());
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });
        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditItem();
            }
        });
    }
    public void onResume() {
        super.onResume();
        loadItem();
    }

    public void loadItem() {
        String temp = dbHandler.loadAllItems().toString();
        if(temp != null && !temp.isEmpty()) {
            String qusChoice = temp.substring(0, temp.length() - 1);
            String[] arrayList = qusChoice.split(",");
            ArrayList<String> choiceList = new ArrayList<String>();
            for (int i = 0; i < arrayList.length; i++) {

                choiceList.add(arrayList[i]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.mytextview, choiceList);
            mListView.setAdapter(adapter);
        }else {

        }
    }

    public void addItem(){  //kaleitai mesw toy onClickListener
        Intent item = new Intent(this , AddItems.class);
        startActivity(item);
    }
    public void EditItem(){  //kaleitai mesw toy onClickListener
        Intent item2 = new Intent(this , EditItems.class);
        startActivity(item2);
    }
}
