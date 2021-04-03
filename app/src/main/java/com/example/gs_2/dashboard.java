package com.example.gs_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {
    private TextView n,d,q,r,t;
    Button po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        n=findViewById(R.id.n1);
        d=findViewById(R.id.d1);
        q=findViewById(R.id.q1);
        r=findViewById(R.id.r1);
        t=findViewById(R.id.totaltxt);

        po=findViewById(R.id.pobtn);


        n.setText(getIntent().getStringExtra("name"));
        d.setText(getIntent().getStringExtra("desc"));
        q.setText(getIntent().getStringExtra("qty"));
        r.setText(getIntent().getStringExtra("ppk"));

        int r0 = Integer.parseInt(r.getText().toString().trim());
        int q0 = Integer.parseInt(q.getText().toString().trim());
        int ni = 40 +r0 * q0 ;
        t.setText(String.valueOf(ni));


        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        //Set home as selected
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
        //Perform ItemSelectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        return true;

                    case R.id.home:
                        Intent launchNextActivity;
                        launchNextActivity = new Intent(getApplicationContext(), Home.class);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(launchNextActivity);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(dashboard.this, "ऑर्डर की पुष्टि की गई", Toast.LENGTH_LONG).show();

//                String sqty = q.getText().toString().trim();
//                String spname = n.getText().toString().trim();
//                String sttl = t.getText().toString().trim();
//                String sdesc = d.getText().toString().trim();
                Intent launchNextActivity;

                launchNextActivity = new Intent(getApplicationContext(), Home.class);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(launchNextActivity);






            }
        });


    }
}