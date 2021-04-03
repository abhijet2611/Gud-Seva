package com.example.gs_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    Button plus,minus,addtocart;
    LinearLayout ll1;
    private TextView num ;
    int n=1;

    Button plus2,minus2,addtocart2;
    LinearLayout ll2;
    private TextView num2 ;
    int n2=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        plus=findViewById(R.id.plusbtn);
        minus=findViewById(R.id.minusbtn);
        num=findViewById(R.id.qtytxt);
        addtocart=findViewById(R.id.addtocartbtn);
        ll1=findViewById(R.id.llcd);


        plus2=findViewById(R.id.plusbtn2);
        minus2=findViewById(R.id.minusbtn2);
        num2=findViewById(R.id.qtytxt2);
        addtocart2=findViewById(R.id.addtocartbtn2);
        ll2=findViewById(R.id.llcd2);


        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        //Set home as selected
        bottomNavigationView.setSelectedItemId(R.id.home);
        //Perform ItemSelectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



        //for first layout
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k= num.getText().toString().trim();
                n = Integer.parseInt(k);
                n++;
                k=String.valueOf(n);
                num.setText(k);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k= num.getText().toString().trim();
                int t = Integer.parseInt(k);
                if(t>1){
                    t--;
                    k=String.valueOf(t);
                    num.setText(k);
                }

            }
        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sqty = num.getText().toString().trim();
                String sppk = "87";
                String sdesc = "चॉकलेट के साथ बहुत स्वादिष्ट गुड़";
                String spname = "Chocolate Gud";
                Intent intent = new Intent(getApplicationContext(), dashboard.class);
                intent.putExtra("name", spname);
                intent.putExtra("ppk", sppk);
                intent.putExtra("qty", sqty);
                intent.putExtra("desc", sdesc);
                ll1.setVisibility(View.GONE);
                startActivity(intent);
            }
        });



        //for second layout
        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k= num2.getText().toString().trim();
                n2 = Integer.parseInt(k);
                n2++;
                k=String.valueOf(n2);
                num2.setText(k);
            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k= num2.getText().toString().trim();
                int t = Integer.parseInt(k);
                if(t>1){
                    t--;
                    k=String.valueOf(t);
                    num2.setText(k);
                }

            }
        });

        addtocart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sqty = num2.getText().toString().trim();
                String sppk = "52";
                String sdesc = "यह ऑर्गेनिक गुड़ बेहद पौष्टिक है";
                String spname = "Organic Gud";
                Intent intent = new Intent(getApplicationContext(), dashboard.class);
                intent.putExtra("name", spname);
                intent.putExtra("ppk", sppk);
                intent.putExtra("qty", sqty);
                intent.putExtra("desc", sdesc);
                ll2.setVisibility(View.GONE);
                startActivity(intent);
            }
        });







    }


    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        }
        else {
            Toast.makeText(this, "बाहर निकलने के लिए वापस दबाएँ.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }


}
