package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class seekermain extends AppCompatActivity {
    public ImageView _imv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekermain);
        /*_imv = (ImageView)findViewById(R.id.Img_profile_Seeker);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            Bitmap _bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
            _imv.setImageBitmap(_bitmap);
        }*/
    }
}