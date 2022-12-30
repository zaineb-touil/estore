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

public class PowerActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"Power bank BJ8", "Power Bank 3 Ultra ", "Power bank sans fil", "Power Bank Xiaomi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        li = findViewById(R.id.li);
        Intent m = getIntent();
        ArrayAdapter<String> p = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(p);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                ShowMyDailog(i);
            }


        });
    }

    private void ShowMyDailog(int pos) {

        Dialog dialog = new Dialog(PowerActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText(" V1N03Ck");
            libellé.setText("Power bank BJ8");
            desc.setText("Capacite: 30000mAh 111Wh  Input: Micro-USB / USB-C – 5V / 2A ");
            prix.setText("90DT");
            image.setImageResource(R.drawable.bj8);
        } else if (pos == 1) {
            reférence.setText("C11CJ68403");
            libellé.setText("Power Bank 3 Ultra");
            desc.setText("Capacité 10 000 mAh, 3.7V Puissance 22.5 W Charge rapideMicro-USB + USB 2x USB A");
            prix.setText("90DT");
            image.setImageResource(R.drawable.ultra);
        } else if (pos == 2) {
            reférence.setText("SS272S");
            libellé.setText("Power bank sans fil");
            desc.setText("Capacité 10000mAh Charge sans fil supportée (5w) Deux ports USB pour charge rapide (2A max chacun) Couleur dispo: Noir - Blanc");
            prix.setText("200 DT");
            image.setImageResource(R.drawable.sans);
        } else {

            reférence.setText("24270 ");
            libellé.setText("POWER BANK XIAOMI MI  ");
            desc.setText("Sortie USB: 2 USB Poids du produit: 0,243 kg Le poids du colis: 0,295 kg Dimensions: 147 * 71 * 14.2mm");
            prix.setText("80 DT");
            image.setImageResource(R.drawable.xiaomi);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
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



                Intent l= new Intent(PowerActivity.this,Ajouter.class);
                startActivity(l);
                break;
            case R.id.it2:
                Intent k=new Intent(PowerActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
}}