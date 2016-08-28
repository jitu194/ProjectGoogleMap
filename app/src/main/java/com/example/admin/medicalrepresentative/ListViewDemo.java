package com.example.admin.medicalrepresentative;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 4/16/2016.
 */
public class ListViewDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewdemo);

        //Setting up a title on the toolbar.

        Toolbar t= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Medicines");

        int[] image = {R.drawable.crocinadvance, R.drawable.liptor, R.drawable.nexium, R.drawable.plavix, R.drawable.advair};
        String[] names = {"Crocin Advance fast release 500 mg", "Liptor Astovastatin 20 mg", "Nexium Esomeprazole 40 mg", "Plavix Clopidogrel 75 mg", "Advair Diskus 250mcg-50mcg"};
        String[] mrp = {"Rs. 30", "Rs. 349.92", "Rs. 244.64", "Rs. 101.40", "Rs. 293.64"};
        String[] tab = {"15 tablets", "30 tablets", "14 capsules", "28 tablets", "60 dozes"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        ListView lv = (ListView) findViewById(R.id.listView);
        MyList ml = new MyList(this, image, names, mrp, tab);
        lv.setAdapter(ml);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}