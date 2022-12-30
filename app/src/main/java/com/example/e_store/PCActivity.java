package com.example.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PCActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"ASUS", "acer", "lenovo", "hp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcactivity);
        li = findViewById(R.id.li);
        Intent a = getIntent();
        Intent p = getIntent();
        ArrayAdapter<String> h = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(h);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);

                ShowMyDialog(i);
            }


        });

        li.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
        li.setOnCreateContextMenuListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.it1:

        }
        return super.onContextItemSelected(item);


    }


    private void ShowMyDialog(int pos) {
        Dialog dialog = new Dialog(PCActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText("X509JB-EJ014T-8GO");
            libellé.setText("ASUS ");
            desc.setText("Ecran 15.6\" HD LED (1366 x 768 px) - Processeur: Intel Core i5-1035G1 Mémoire RAM: 8 Go DDR4 ");
            prix.setText("1860 DT");
            image.setImageResource(R.drawable.assus);
        } else if (pos == 1) {
            reférence.setText("NX.HNSEF.005");
            libellé.setText("ACER Aspire i7");
            desc.setText("Ecran 15.6 Full HD - Processeur Intel Core i7-1065G7 Système d'exploitation: Free Dos - Mémoire RAM: 8 Go DDR4");
            prix.setText("1939 DT");
            image.setImageResource(R.drawable.acer);
        } else if (pos == 2) {
            reférence.setText("20SM001JFE");
            libellé.setText("LENOVO");
            desc.setText("Ecran: 15.6\" FHD - Processeur : i3-1005G1  Système d'exploitation: Free Dos - Mémoire RAM: 4 Go");
            prix.setText("1399 DT");
            image.setImageResource(R.drawable.lenovo);

        } else {
            reférence.setText(" 2Y6A0EA-16");
            libellé.setText("HP gamer i7");
            desc.setText("Ecran 15.6 FULL HD - Processeur Intel Core i7-10750H");
            prix.setText("3000 DT");
            image.setImageResource(R.drawable.hpgamer);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(PCActivity.this, Ajouter.class);

                startActivity(l);
                break;

            case R.id.it2:
                Intent m = new Intent(PCActivity.this,Supprimer.class);
                startActivity(m);
                break;
        }

        return false;
    }
}