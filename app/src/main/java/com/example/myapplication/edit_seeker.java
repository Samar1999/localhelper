package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class edit_seeker extends AppCompatActivity {
    ImageView viewImage;
    public  Bitmap bitmapImage;
    /*private int requestCode;
    final int CAMERA_INTENT = 51;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_seeker);
        viewImage = (ImageView) findViewById(R.id.profile_image_seeker_edit);
        Button photobtn = (Button)this.findViewById(R.id.newphoto);
        photobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(edit_seeker.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.menu, null);
                builder.setCancelable(false);
                builder.setView(dialogView);

                TextView imageViewADPPCamera = dialogView.findViewById(R.id.camera);

                TextView imageViewADPPGallery = dialogView.findViewById(R.id.gallery);
                TextView cancel = dialogView.findViewById(R.id.cancel);

                final AlertDialog alertdialog = builder.create();
                alertdialog.show();

                imageViewADPPCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkAndRequestPermissions()) {
                            takePictureFromCamera();
                            alertdialog.dismiss();
                        }
                    }
                });

                imageViewADPPGallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        takePictureFromGallery();
                        alertdialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertdialog.dismiss();
                    }
                });

            }
        });
    }

    public void updatedata(View view) {
        Intent RegisterPage = new Intent(edit_seeker.this, seekermain.class);
        /*ByteArrayOutputStream _bs = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.PNG, 50, _bs);
        RegisterPage.putExtra("byteArray",_bs.toByteArray());*/
        startActivity(RegisterPage);
    }

    /*public void newphoto(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(edit_seeker.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.menu, null);
        builder.setCancelable(false);
        builder.setView(dialogView);

        TextView imageViewADPPCamera = dialogView.findViewById(R.id.camera);

        TextView imageViewADPPGallery = dialogView.findViewById(R.id.gallery);
        TextView cancel = dialogView.findViewById(R.id.cancel);

        final AlertDialog alertdialog = builder.create();
        alertdialog.show();

        imageViewADPPCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndRequestPermissions()) {
                    takePictureFromCamera();
                    alertdialog.dismiss();
                }
            }
        });

        imageViewADPPGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePictureFromGallery();
                alertdialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertdialog.dismiss();
            }
        });
    }*/

    private void takePictureFromGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }

    private void takePictureFromCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, 2);
        }
    }

    /*public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_INTENT);
            }
            else
            {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }*/

    private boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            int cameraPermission = ActivityCompat.checkSelfPermission(edit_seeker.this, Manifest.permission.CAMERA);
            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(edit_seeker.this, new String[]{Manifest.permission.CAMERA}, 20);
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImageUri = data.getData();
                    viewImage.setImageURI(selectedImageUri);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
                    viewImage.setImageBitmap(bitmapImage);
                }
                break;

        }

    }
}