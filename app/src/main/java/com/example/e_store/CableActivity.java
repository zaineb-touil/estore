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

public class CableActivity extends AppCompatActivity {
    ListView list;
    String[] bd = new String[]{"cable hdmi", "cable usb", "cable vga", "cable réseau"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable);
        list = findViewById(R.id.li);
        Intent m = getIntent();
        ArrayAdapter<String> p = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        list.setAdapter(p);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                ShowMyDailog(i);
            }


        });
    }

    private void ShowMyDailog(int pos) {

        Dialog dialog = new Dialog(CableActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText("HDMI1.5M-P");
            libellé.setText("cable hdmi");
            desc.setText("Câble HDMI Plat - Mâle / Mâle - Longueur 1.5M - Couleur Noir");
            prix.setText("3,700DT");
            image.setImageResource(R.drawable.cablehdmi);
        } else if (pos == 1) {
            reférence.setText("ECB-DU4AWC");
            libellé.setText("Câble USB");
            desc.setText("Câble USB vers Micro USB pour tablette et smartphone - Couleur Blanc");
            prix.setText("2,300DT");
            image.setImageResource(R.drawable.cableusb);
        } else if (pos == 2) {
            reférence.setText("VGA-3M");
            libellé.setText("cable usb");
            desc.setText("Câble VGA - Male-Male - Longueur 3M");
            prix.setText("5,400");
            image.setImageResource(R.drawable.cablevga);
        } else {

            reférence.setText("WT-2038A-1M");
            libellé.setText("cable réseau");
            desc.setText("Câble Réseau CAT 5E UTP - Longueur 1M - Couleur Gris");
            prix.setText("1,600DT");
            image.setImageResource(R.drawable.cablereseau);
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



                Intent l= new Intent(CableActivity.this,Ajouter.class);
                startActivity(l);
                break;
            case R.id.it2:
                Intent k=new Intent(CableActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
}}