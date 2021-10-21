package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText na,aadh,email,pwd,cpwd,st,pnc,cn,acn;

    /*String states[], Email = "", id, Contact_Number, Aadhar_Number, Street_No, Pincode, State, City, Gender = "", Password = "", Confirm_password = "", Profession = "", Type = "", Name = "", Alternate_Contact_Number;
    Spinner spinner_gender, spinner_profession, spinner_state, spinner_City;
    RadioButton radioButtonseeker, radioButtonrecruiter;
    EditText editTextEmail, editTextContact_No, editTextAadhar_No, editTextStreet, editTextPassword, editTextConfirmPassword, editTextPincode, editTextName, editTextAlternate_contact_No;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        na = (EditText) findViewById(R.id.editTextName);
        aadh = (EditText) findViewById(R.id.editTextAadhar_No);
        email = (EditText) findViewById(R.id.editTextEmail);
        pwd = (EditText) findViewById(R.id.editTextPassword);
        cpwd = (EditText) findViewById(R.id.editTextConfirmPassword);
        st = (EditText) findViewById(R.id.editTextStreet);
        pnc = (EditText) findViewById(R.id.editTextPincode);
        cn = (EditText) findViewById(R.id.editTextContact_No);
        acn = (EditText) findViewById(R.id.editTextAlternate_No);
    }
    public void test(View view) {
        String name = na.getText().toString();
        String aadhno = aadh.getText().toString();
        String emailid = email.getText().toString();
        String pass = pwd.getText().toString();
        String cpass = cpwd.getText().toString();
        String strt = st.getText().toString();
        String pinc = pnc.getText().toString();
        String cno = cn.getText().toString();
        String acno = acn.getText().toString();

        if(name.equals("") || aadhno.equals("") || emailid.equals("") || pass.equals("") || cpass.equals("") || strt.equals("") || pinc.equals("") || cno.equals("") || acno.equals("")) {
            Toast.makeText(getApplicationContext(), "All fields are required.",Toast.LENGTH_SHORT).show();
        }
        else if(!emailid.contains("@") || !emailid.contains(".com")){
            Toast.makeText(getApplicationContext(), "Invalid email.",Toast.LENGTH_SHORT).show();
        }
        else if(!pass.equals(cpass)){
            Toast.makeText(getApplicationContext(), "Passwords do not match.",Toast.LENGTH_SHORT).show();
        }
        else if(pinc.length()!=6){
            Toast.makeText(getApplicationContext(), "Incorrect Pincode",Toast.LENGTH_SHORT).show();
        }
        else if(aadhno.length()!=15){
            Toast.makeText(getApplicationContext(), "Incorrect Aadhar No.",Toast.LENGTH_SHORT).show();
        }
        else if(cno.length()!=10 || acno.length()!=10){
            Toast.makeText(getApplicationContext(), "Incorrect Phone No.",Toast.LENGTH_SHORT).show();
        }
        else if(cno.equals(acno)){
            Toast.makeText(getApplicationContext(), "Alternate No Required",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Registered successfully",Toast.LENGTH_SHORT).show();
            Intent RegisterPage = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(RegisterPage);
        }
    }

    public void onRadioButtonclicked(View view)
    {
        /*switch(view.getId())
        {
            case R.id.Radio_btn_seeker:
                if(radioButtonseeker.isChecked())
                {
                    spinner_profession.setEnabled(true);
                    spinner_profession.setClickable(true);
                    //Toast.makeText(SignUp.this,"Hello",Toast.LENGTH_SHORT).show();
                    Type = "Seeker";
                }
            case R.id.Radio_Btn_recruiter:
                if(radioButtonrecruiter.isChecked())
                {
                    spinner_profession.setEnabled(false);
                    spinner_profession.setClickable(false);
                    //Toast.makeText(SignUp.this,"Hello",Toast.LENGTH_SHORT).show();
                    Profession = "";
                    Type = "Recruiter";
                }
        }*/
    }
    /*private boolean validation()
    {
        boolean valid = true;

        if(Email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            valid = false;
        }

        if(! Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            editTextEmail.setError("Please Enter valid Email address");
            editTextEmail.requestFocus();
            valid = false;
        }
        if(Password.isEmpty())
        {
            editTextPassword.setError("Please Enter the password");
            editTextPassword.requestFocus();
            valid = false;
        }
        if(Password.length() < 6)
        {
            editTextPassword.setError("Minimum password length is 6");
            editTextPassword.requestFocus();
            valid = false;
        }
        if(Type == "SeekerProfile")
        {
            if(Profession.isEmpty())
            {
                spinner_profession.requestFocus();
                valid = false;
            }
        }
        if(Gender.isEmpty())
        {
            spinner_gender.requestFocus();
            valid = false;
        }
        if(Pincode.isEmpty())
        {
            editTextPincode.setError("Enter Pincode");
            editTextPincode.requestFocus();
            valid = false;
        }
        if(Contact_Number.isEmpty())
        {
            editTextContact_No.setError("Enter Mobile Number");
            editTextContact_No.requestFocus();
            valid = false;
        }
        if(Aadhar_Number.isEmpty())
        {

            editTextAadhar_No.setError("Enter Aadhaar");
            editTextAadhar_No.requestFocus();
            valid = false;

        }
        if(Street_No.isEmpty())
        {
            editTextStreet.setError("Enter the Stree Name or Number ");
            editTextStreet.requestFocus();
            valid = false;
        }
        if(Name.isEmpty())
        {
            editTextName.setError("Enter name");
            editTextName.requestFocus();
        }

        return valid;
    }*/
}