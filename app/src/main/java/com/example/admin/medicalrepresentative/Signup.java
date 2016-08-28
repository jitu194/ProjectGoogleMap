package com.example.admin.medicalrepresentative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Admin on 2/11/2016.
 */
public class Signup extends AppCompatActivity
{
    //Create the object of DatabaseHelper class.
    DatabaseHelper helper = new DatabaseHelper(this);

    Button b;
    String sUsername,sPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //Setting up a title on the toolbar.

        Toolbar t= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");

        Button login = (Button)findViewById(R.id.back);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEditText = (EditText) findViewById(R.id.userId);
                sUsername = usernameEditText.getText().toString();
                if (sUsername.matches("")) {
                    // Show Toast
                    Toast.makeText(Signup.this, "You did not enter a username", LENGTH_SHORT).show();
                    // Show Error on edittext
                    usernameEditText.setError("Your message");
                    return;
                }
                //Password Validation
                EditText usernamePassword = (EditText) findViewById(R.id.password);
                sPassword = usernamePassword.getText().toString();
                if (sPassword.matches("")) {
                    // Show Toast
                    Toast.makeText(Signup.this, "You did not enter a password", LENGTH_SHORT).show();
                    // Show Error on edittext
                    usernamePassword.setError("Your message");
                    return;
                }
                //Check the username and password of the registered user is correct.
                if (v.getId() == R.id.back) {
                    EditText username = (EditText) findViewById(R.id.userId);
                    EditText password = (EditText) findViewById(R.id.password);
                    String usernameone = username.getText().toString();
                    String passwordone = password.getText().toString();
                    String p = helper.searchPass(usernameone);

                    if (passwordone.equals(p)) {
                        Intent i = new Intent(Signup.this, Menu.class);
                        i.putExtra("username",username.getText().toString());
                        startActivity(i);
                    } else {
                        Toast.makeText(Signup.this, "Username and password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent = new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;

    }

    public void onBackPressed() {
        Intent intent = new Intent(Signup.this,MainActivity.class);
        startActivity(intent);
    }

}
