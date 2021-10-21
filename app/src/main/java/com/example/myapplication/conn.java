package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class conn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conn);
    }
    public void seeker(View view) {
        Intent SeekerPage = new Intent(conn.this, edit_seeker.class);
        startActivity(SeekerPage);
    }
    public void recruiter(View view) {
        Intent RecruiterPage = new Intent(conn.this, recruitermain.class);
        startActivity(RecruiterPage);
    }
}