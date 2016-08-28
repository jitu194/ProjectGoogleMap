package com.example.admin.medicalrepresentative;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by Admin on 3/1/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    //Creating the SQLiteDatabase object.
    SQLiteDatabase db;

    //Assingning the names to database .
    private  static final int DATABASE_VERSION=1;
    private  static  final String DATABASE_NAME="registration.db";
    private  static  final String TABLE_NAME="registration";
    private  static  final String FIRSTNAME="fn";
    private  static  final String LASTNAME="ln";
    private  static  final String EMAIL="email";
    private  static  final String USERNAME="un";
    private  static  final String PASSWORD="passwd";
    private  static  final String CONFIRMPASSWORD="confirmPassword";

    private  static  final String TABLE_CREATE="create table registration(fn text not null,ln text not null,email text not null,un text not null," +
            "passwd text not null,confirmPassword not null);";



    //Create the constructor for the DatabaseHelper.
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME ,null, DATABASE_VERSION);
    }

    //Insert the value.
    public void insertContact(Contact c)
    {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(FIRSTNAME,c.getfn());
        values.put(LASTNAME,c.getLn());
        values.put(EMAIL,c.getEmail());
        values.put(USERNAME,c.getUn());
        values.put(PASSWORD,c.getPasswd());
        values.put(CONFIRMPASSWORD,c.getConfirmPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    //Get the Username and Password to login.
    public  String searchPass(String un)
    {
        db=this.getReadableDatabase();
        String query="select un,passwd from "+TABLE_NAME;
        Cursor c=db.rawQuery(query,null);
        String a;
        String b="Not Found";
        if (c.moveToFirst())
        {
            do {
                a=c.getString(c.getColumnIndex("un"));
                if (a.equals(un))
                {
                    b=c.getString(c.getColumnIndex("passwd"));
                    break;
                }
            }
            while (c.moveToNext());
        }
        return  b;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        this.db=db;
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
