package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
    Button resetpwdbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        resetpwdbtn=findViewById(R.id.resetbtn);
        resetpwdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                Toast.makeText(getApplicationContext(),"Confirmation link has been sent to your email!",Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        });
    }
}