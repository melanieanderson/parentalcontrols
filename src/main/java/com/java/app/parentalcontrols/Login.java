package com.java.app.parentalcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocal userLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        userLocal = new UserLocal(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:

                User user = new User(null,null);
                userLocal.storeUserData(user);
                userLocal.setUserLoggedIn(true);

                break;

            case R.id.tvRegisterLink:

                startActivity(new Intent(this, Register.class));

                break;
        }
    }
}
