package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class proionta extends AppCompatActivity {

    Button diaxhrhshProiontwn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proionta);

        diaxhrhshProiontwn = (Button)findViewById(R.id.diaxeirhProiontonEdit);
        diaxhrhshProiontwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiaxeirhshProiontwn();
            }
        });
    }

    public void openDiaxeirhshProiontwn(){  //kaleitai mesw toy onClickListener
        Intent diaxeirhshProiontwn = new Intent(this , diaxhrhshProiontos.class);
        startActivity(diaxeirhshProiontwn);
    }
}
