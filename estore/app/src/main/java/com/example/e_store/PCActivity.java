package com.example.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PCActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"HP", "DELL", "ASUS", "LENOVO"};

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
                 li.delete(i.position);

                break;
            default:

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
            reférence.setText(" 2Y6A0EA-16");
            libellé.setText("HP gamer i7");
            desc.setText("Ecran 15.6 FULL HD - Processeur Intel Core i7-10750H");
            prix.setText("3000 DT");
            image.setImageResource(R.drawable.hp);
        } else if (pos == 1) {
            reférence.setText(" 3593I7S-16");
            libellé.setText("DELL i7");
            desc.setText("Ecran 15.6 Full HD - Processeur Intel Core i7-1065G7");
            prix.setText("2100DT");
            image.setImageResource(R.drawable.dell);
        } else if (pos == 2) {
            reférence.setText("X542UF-GO123");
            libellé.setText("ASUS i5 ");
            desc.setText("Ecran 15.6 HD LED - Processeur Intel Core i5-8250U ");
            prix.setText("1750 DT");
            image.setImageResource(R.drawable.asus);
        } else {

            reférence.setText(" 80L0008EFE");
            libellé.setText("LENOVO");
            desc.setText("Ecran 15.6 HD LED - Processeur Intel Core i3-4005U 4é Génération, 1.7 GHz ");
            prix.setText("850 DT");
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