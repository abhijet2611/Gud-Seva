package com.example.gs_2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class editprofile extends AppCompatActivity {
    Button updbtn;
    EditText name,address,aadhar,ifcs,accno,phhno,emmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        updbtn    = findViewById(R.id.submitbtn);
        name      = findViewById(R.id.prdtnm);
        address   = findViewById(R.id.ppk);
        aadhar    = findViewById(R.id.qty);
        ifcs      = findViewById(R.id.dc);
        phhno     = findViewById(R.id.phno);
        emmail    = findViewById(R.id.email);

        updbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String saadhar = aadhar.getText().toString().trim();
                String sifsc = ifcs.getText().toString().trim();
                String saccno = accno.getText().toString().trim();
                String sname = name.getText().toString().trim();
                String sphhno = phhno.getText().toString().trim();
                String semail = emmail.getText().toString().trim();
                String saddress = address.getText().toString().trim();

                if(TextUtils.isEmpty(sname)||TextUtils.isEmpty(sphhno)||TextUtils.isEmpty(semail)||TextUtils.isEmpty(saddress)||TextUtils.isEmpty(saadhar)||TextUtils.isEmpty(sifsc)||TextUtils.isEmpty(saccno)){
                    Toast.makeText( editprofile.this , "Empty fields not allowed", Toast.LENGTH_LONG).show();
                }
                else if(saadhar.length()!=12){aadhar.setError("Exactly 12 Numbers");}
                else if(sifsc.length()<12){ifcs.setError("Enter 12 or more Characters");}
                else if(saccno.length()<12){accno.setError("Enter 12 or more Characters");}
                else if(sphhno.length()!=10){phhno.setError("Enter 10 Characters");}
                else {  Toast.makeText(editprofile.this, "Profile Updated", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Home.class)); }

            }
        });

    }
}