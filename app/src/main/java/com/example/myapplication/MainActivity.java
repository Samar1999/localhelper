package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText na1,na2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        na1 = (EditText)findViewById(R.id.login_mail);
        na2 = (EditText)findViewById(R.id.login_pwd);

    }
    public void login(View view) {
        String email = na1.getText().toString();
        String pass = na2.getText().toString();

        if(email.equals("samar") && pass.equals("admin")){
            Toast.makeText(getApplicationContext(), "Login success",Toast.LENGTH_SHORT).show();
            Intent homepage = new Intent(MainActivity.this, conn.class);
            startActivity(homepage);
        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
        }
    }

    public void signup(View view) {
        Intent RegisterPage = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(RegisterPage);
    }
    public void forgotpassword(View view) {
        Intent RegisterPage = new Intent(MainActivity.this, forgotpassword.class);
        startActivity(RegisterPage);
    }
}