package com.example.admin.medicalrepresentative;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Admin on 4/17/2016.
 */
public class Contents {
    int[] image;
    String[] names;
    String[] mrp;
    String[] tabs;
    Context context;

    Contents(Activity context, int[] image, String[] medname, String[] medmrp, String[] medtabs) {
        this.image = image;
        this.names = medname;
        this.mrp = medmrp;
        this.tabs = medtabs;
        this.context = context;
    }
}
