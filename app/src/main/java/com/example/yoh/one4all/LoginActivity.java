package com.example.yoh.one4all;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSignIn, btnRegister;
    private EditText uName, uPass;
    private CheckBox rememberMe;
    private TextView forgotPass;
    private int reMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignIn=(Button) findViewById(R.id.LoginButton);
        btnSignIn.setOnClickListener(this);
        btnRegister=(Button) findViewById(R.id.RegisterButton);
        btnRegister.setOnClickListener(this);
        uName=(EditText) findViewById(R.id.Uname);
        uPass=(EditText) findViewById(R.id.Upass);
        rememberMe=(CheckBox) findViewById(R.id.RememberMeCheckBox);
        rememberMe.setOnClickListener(this);
        forgotPass=(TextView) findViewById(R.id.ForgotPasswordTextView);
        forgotPass.setOnClickListener(this);

        /*
        //Start the register activity
            btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registration = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registration);

                Toast registerToast = Toast.makeText(LoginActivity.this,"Register", Toast.LENGTH_SHORT);
                //LoginActivity.this=context
                registerToast.show();
            }
        });*/
    }


    @Override
    public void onClick(View v) {
            Toast.makeText(LoginActivity.this,"inside Switch",Toast.LENGTH_LONG);
            switch(v.getId()){
                case R.id.RegisterButton:
                    Log.d("ButtonClick","Register Button Clicked");
                    Intent registration = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(registration);

                    Toast registerToast = Toast.makeText(LoginActivity.this,"Register Here", Toast.LENGTH_SHORT);
                    //LoginActivity.this=context
                    registerToast.show();
                    break;
                case R.id.LoginButton:
                    Log.d("ButtonClick","Login Button Clicked");
                    Intent msgesView = new Intent(getApplicationContext(), MessageView.class);
                    startActivity(msgesView);

                    Toast loginToast = Toast.makeText(LoginActivity.this,"Signed In", Toast.LENGTH_SHORT);
                    //LoginActivity.this=context
                    loginToast.show();
                    break;
                case R.id.ForgotPasswordTextView:
                    Toast forgotPassToast = Toast.makeText(LoginActivity.this,"Email sent", Toast.LENGTH_SHORT);
                    //LoginActivity.this=context
                    forgotPassToast.show();
                    break;
                case R.id.RememberMeCheckBox:
                    if(rememberMe.isChecked()) {
                        reMe = 1;
                        Toast rememberMeToast = Toast.makeText(LoginActivity.this, "I will remember you!", Toast.LENGTH_SHORT);
                        rememberMeToast.show();
                    }
                    else
                        reMe=0;
                    break;
        }
    }
}
