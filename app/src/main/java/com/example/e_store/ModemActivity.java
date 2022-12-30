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

public class  ModemActivity extends AppCompatActivity {
        ListView l;
        String [] bd= new String[] {"Modem Routeur Gigabit","LogiLink modem"};

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modem);
        l=findViewById(R.id.li);
        Intent b=getIntent();
        ArrayAdapter<String> k= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,bd);
        l.setAdapter(k);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println(i);
        ShowMyDialog( i);
        }
        });
        }

private void ShowMyDialog(int pos) {
        Dialog dialog = new Dialog(ModemActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence= dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix =dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image =dialog.findViewById(R.id.imag);

        if (pos == 0) {
        reférence.setText("TD-W8980");
        libellé.setText(" Modem Routeur Gigabit");
        desc.setText(" Modem Routeur Gigabit ADSL2+ sans fil N Double Bande N600 ");
        prix.setText("191,29DT");
        image.setImageResource(R.drawable.modemrouteur);

        }
        else if(pos == 1) {
        reférence.setText("11111286");
        libellé.setText("LogiLink modem");
        desc.setText("LogiLink Routeur modem WiFi ADSL2/2+, Annexe A, 300 Mbps");
        prix.setText("208,97DT");
        image.setImageResource(R.drawable.logilinkmodem);

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
        Intent l = new Intent(ModemActivity.this, Ajouter.class);
        startActivity(l);
        break;
        case R.id.it2:
        Intent k=new Intent(ModemActivity.this,Rechercher.class);
        startActivity(k);
        break;

        }

        return false;
        }
        }