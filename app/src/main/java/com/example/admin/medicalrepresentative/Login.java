package com.example.admin.medicalrepresentative;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Admin on 2/10/2016.
 */
public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //Create the DatabaseHelper object.
    DatabaseHelper helper=new DatabaseHelper(this);
    Button b;
    EditText fn;
    EditText ln;
    EditText email;
    EditText un;
    EditText passwd;
    EditText confirmPassword;
    String sfn,sln,semail,susername,spasswd,scpasswd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Setting up a title on the toolbar.

        Toolbar t= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");


        final Button register = (Button)findViewById(R.id.next);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Firstname Edittext Validations
                EditText firstnameEditText = (EditText) findViewById(R.id.firstName);
                sfn = firstnameEditText.getText().toString();
                if (sfn.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a firstname", LENGTH_SHORT).show();
                    // Show Error on edittext
                    firstnameEditText.setError("Your message");
                    return;
                }

                //Lastname Edittext Validations
                EditText lastnameEditText = (EditText) findViewById(R.id.lastName);
                sln = lastnameEditText.getText().toString();
                if (sln.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a lastname", LENGTH_SHORT).show();
                    // Show Error on edittext
                    lastnameEditText.setError("Your message");
                    return;
                }
                //Email Edittext Validations
                EditText emailEditText = (EditText) findViewById(R.id.email);
                semail = emailEditText.getText().toString();
                if (semail.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a email", LENGTH_SHORT).show();
                    // Show Error on edittext
                    emailEditText.setError("Your message");
                    return;
                }

                //Username Edittext Validations
                EditText usernameEditText = (EditText) findViewById(R.id.userName);
                susername = usernameEditText.getText().toString();
                if (susername.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a username", LENGTH_SHORT).show();
                    // Show Error on edittext
                    usernameEditText.setError("Your message");
                    return;
                }

                //Password Edittext Validations
                EditText passwordEditText = (EditText) findViewById(R.id.password);
                spasswd = passwordEditText.getText().toString();
                if (spasswd.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a password", LENGTH_SHORT).show();
                    // Show Error on edittext
                    passwordEditText.setError("Your message");
                    return;
                }

                //Confirm Password Edittext Validations
                EditText cpasswordEditText = (EditText) findViewById(R.id.confirmPassword);
                scpasswd = cpasswordEditText.getText().toString();
                if (scpasswd.matches("")) {
                    // Show Toast
                    Toast.makeText(Login.this, "You did not enter a confirm password", LENGTH_SHORT).show();
                    // Show Error on edittext
                    cpasswordEditText.setError("Your message");
                    return;
                }
                if (v.getId() == R.id.next)
                {
                    //Get the id of each field.
                    fn = (EditText)findViewById(R.id.firstName);
                    ln = (EditText)findViewById(R.id.lastName);
                    email = (EditText)findViewById(R.id.email);
                    un = (EditText)findViewById(R.id.userName);
                    passwd = (EditText)findViewById(R.id.password);
                    confirmPassword = (EditText)findViewById(R.id.confirmPassword);

                    //get the value and parse it to toString() method.
                    String First = fn.getText().toString();
                    String Last = ln.getText().toString();
                    String Email = email.getText().toString();
                    String UserName = un.getText().toString();
                    String Password = passwd.getText().toString();
                    String ConfirmPassword = confirmPassword.getText().toString();

                    //Check the two passwords are equal.
                    if (Password.equals(ConfirmPassword))
                    {
                        Contact c = new Contact();
                        c.setFn(First);
                        c.setLn(Last);
                        c.setEmail(Email);
                        c.setUn(UserName);
                        c.setPasswd(Password);
                        c.setConfirmPassword(ConfirmPassword);
                        helper.insertContact(c);
                        Intent i = new Intent(Login.this,Signup.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Password doesnt match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //Changing colour of Edittext.
         fn = (EditText)findViewById(R.id.firstName);
        //Changing focus colour.
        fn.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                    v.setBackgroundResource(R.drawable.rounds);
            }
        });

        //Changing colour of Edittext.
         ln = (EditText)findViewById(R.id.lastName);
        //Changing focus colour.
        ln.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    v.setBackgroundResource(R.drawable.rounds);
            }
        });


        //Changing colour of Edittext.
         email = (EditText)findViewById(R.id.email);
        //Changing focus colour.
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    v.setBackgroundResource(R.drawable.lost_focus);
                }
        });

        //Changing colour of Edittext.
         un = (EditText)findViewById(R.id.userName);
        //Changing focus colour.
        un.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    v.setBackgroundResource(R.drawable.rounds);
                }
        });

        //Changing colour of Edittext.
         passwd = (EditText)findViewById(R.id.password);
        //Changing focus colour.
        passwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    v.setBackgroundResource(R.drawable.rounds);
                }
        });

        //Changing colour of Edittext.
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        //Changing focus colour.
        confirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                    v.setBackgroundResource(R.drawable.rounds);
                }
        });
    }

    public void sendMessage(View v)
    {
        String message  = ((Button)v).getText().toString();
        if(message.equals("Register"))
        {
            Intent i = new Intent(this,Signup.class);
            startActivity(i);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;

    }

    public void onBackPressed() {
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }
}
