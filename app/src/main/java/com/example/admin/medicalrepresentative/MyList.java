package com.example.admin.medicalrepresentative;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 4/16/2016.
 */
public class MyList extends ArrayAdapter
{


    Activity a;
    int[] image;
    String [] names;
    String [] mrp;
    String [] tab;

    //Create the constructor of the class.
    public MyList(Activity a, int image[], String names[], String mrp[], String tab[])
    {
        super(a,R.layout.mylist,names);
        this.a =a;
        this.image =image;
        this.names =names;
        this.mrp =mrp;
        this.tab=tab;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = a.getLayoutInflater();
        convertView=inflater.inflate(R.layout.mylist, null, false);
        TextView medn = (TextView) convertView.findViewById(R.id.med);
        ImageView iv= (ImageView) convertView.findViewById(R.id.image);
        iv.setImageResource(image[position]);
        medn.setText(names[position]);
        return convertView;
    }




}
