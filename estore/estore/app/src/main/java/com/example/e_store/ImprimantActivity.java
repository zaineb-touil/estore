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

public class ImprimantActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"Imprimant hp", "Imprimant epson", "Imprimant samsung", "Imprimant canon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimant);
        li = findViewById(R.id.li);
        Intent c = getIntent();
        ArrayAdapter<String> g = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(g);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                ShowMyDailog(i);
            }
        });
    }

    private void ShowMyDailog(int pos) {
        Dialog dialog = new Dialog(ImprimantActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText(" V1N03C");
            libellé.setText("HP");
            desc.setText("Multifonction 3en1 Jet d'encre HP Deskjet 2630 - Sans fil - Impression, copie, numérisation - Format A4");
            prix.setText("90DT");
            image.setImageResource(R.drawable.hp1);
        } else if (pos == 1) {
            reférence.setText("C11CJ68403");
            libellé.setText("EPSON");
            desc.setText("EPSON L3210 3En1 Couleur - Fonctions: Impression, Copie et Scan - Format Papier: A4 ");
            prix.setText("560DT");
            image.setImageResource(R.drawable.epson);
        } else if (pos == 2) {
            reférence.setText("SS272S");
            libellé.setText("Samsung");
            desc.setText("Imprimante Laser Monochrome - Vitesse d'impression: Jusqu'à 20 ppm - Résolution d'impression: 1200 x 1200 ppp");
            prix.setText("250 DT");
            image.setImageResource(R.drawable.sam);
        } else {

            reférence.setText("G-1420");
            libellé.setText("Canon ");
            desc.setText("Imprimante CANON Pixma G-1420 - Fonctions: Impression - Technologie d'impression:Jet d'encre Couleur -Vitesse d'impression:env 9,1 ipm en noir, env 5 ipm en couleur");
            prix.setText("500 DT");
            image.setImageResource(R.drawable.lenovo);
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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(ImprimantActivity.this, Ajouter.class);
                startActivity(l);

                break;
            case R.id.it2:
                Intent k=new Intent(ImprimantActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
    }
}