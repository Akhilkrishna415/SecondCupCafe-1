package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Accountsettings extends AppCompatActivity {

    TextView personalSettings;
    TextView rating;
    TextView Contactus;
    TextView Payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        personalSettings = findViewById(R.id.textView);
        personalSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Personalsettings.class);
                startActivity(i);
            }
        });
        rating=findViewById(R.id.textView4);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Rating.class);
                startActivity(i);

            }
        });
        Contactus=findViewById(R.id.textView3);
        Contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Contactus.class);
                startActivity(i);

            }
        });
        Payment=findViewById(R.id.textView2);
        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Payment.class);
                startActivity(i);
            }
        });



    }

}