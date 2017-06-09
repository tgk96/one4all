package com.example.yoh.one4all;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS,ET_EMAIL_ADDR,ET_AGE,ET_CNF_PASS;
    String name,user_name,user_pass,email_addr,age,cnf_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ET_NAME = (EditText)findViewById(R.id.RegisterName);
        ET_USER_NAME = (EditText)findViewById(R.id.RegisterUname);
        ET_USER_PASS = (EditText)findViewById(R.id.RegisterPassword);
        ET_EMAIL_ADDR = (EditText)findViewById(R.id.RegisterEmail);
        ET_AGE = (EditText)findViewById(R.id.RegisterAge);
        ET_CNF_PASS = (EditText)findViewById(R.id.RegisterConfirmPassword);
    }

    public void userReg(View view)
    {
        name = ET_NAME.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        email_addr = ET_EMAIL_ADDR.getText().toString();
        age = ET_AGE.getText().toString();
        cnf_pass = ET_CNF_PASS.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method,name,user_name,user_pass,email_addr,age,cnf_pass);
        finish();

    }



}
