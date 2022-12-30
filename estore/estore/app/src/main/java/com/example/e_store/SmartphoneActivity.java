package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SmartphoneActivity extends AppCompatActivity {
ListView li;
String [] bd= new String[] {"Iphone","Samsung","Huawei","Nokia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);
        li=findViewById(R.id.li);
        Intent b=getIntent();
        ArrayAdapter<String> k= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,bd);
        li.setAdapter(k);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ShowMyDialog( i);
            }
        });
    }

    private void ShowMyDialog(int pos) {
        Dialog dialog = new Dialog(SmartphoneActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence= dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix =dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image =dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText("MQ023AA/A");
            libellé.setText("Iphone 14");
            desc.setText(" Ecran:6.1 Stockage 128 Go Processeur Apple A16  ");
            prix.setText("6 275 DT");
            image.setImageResource(R.drawable.iphone14);
        }
        else if(pos == 1) {
            reférence.setText(" SM-A12-128-BK");
            libellé.setText("samsung A12");
            desc.setText("Double SIM - Ecran 6.5  RAM 4 Android 10  ");
            prix.setText("695DT");
            image.setImageResource(R.drawable.samsung);
        }
        else if(pos==2) {
            reférence.setText(" MATE10-LTE-GO");
            libellé.setText("Huawei");
            desc.setText(" 128 GB Android 8.1 batterie  4000 mAh ");
            prix.setText("900 DT");
            image.setImageResource(R.drawable.huawei);
        }
        else {

            reférence.setText("NOKIA-7.2-GR");
            libellé.setText("Nokia");
            desc.setText(" Batterie 3500mAh  Couleur Vert Ecran 6.3 Full HD+ 1080 x 2340 pixels");
            prix.setText("800DT");
            image.setImageResource(R.drawable.nokia);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(SmartphoneActivity.this, Ajouter.class);
                startActivity(l);
                break;
            case R.id.it2:
                Intent k=new Intent(SmartphoneActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
    }
}