package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    String [] mod=new String[]{"Ordinateurs Portables","Modem","Imprimantes","Cables"};
    int[]imageitem={R.drawable.ordinteur,R.drawable.modem,R.drawable.imprt,R.drawable.cabl};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=findViewById(R.id.grid);
        GridAdapter g=new GridAdapter(this,mod,imageitem);
        grid.setAdapter(g);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                switch (i){
                    case 0:
                        Intent a= new Intent(MainActivity.this,PCActivity.class);
                        startActivity(a);
                        break;
                    case 1:

                        Intent b= new Intent(MainActivity.this,ModemActivity.class);
                        startActivity(b);
                        break;
                    case 2:
                        Intent c=new Intent(MainActivity.this,ImprimantActivity.class);
                        startActivity(c);
                        break;
                    case 3:
                        Intent m= new Intent(MainActivity.this, CableActivity.class);
                        startActivity(m);
                        break;
                }

            }
        });
    }
}