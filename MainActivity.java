package com.example.yoh.one4all;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by shubhamjoshi on 09-06-2017.
 */

public class MainActivity extends Activity {

    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ET_NAME = (EditText)findViewById(R.id.Uname);
        ET_PASS = (EditText)findViewById(R.id.Upass);
    }

    public void userReg(View view)
    {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void userLogin(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();

        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);


    }




}
