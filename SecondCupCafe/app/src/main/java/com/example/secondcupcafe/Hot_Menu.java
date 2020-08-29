package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class helps to display the hot items added for the cart
 * @author naveen sadineni
 */

public class Hot_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot__menu);

        Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method helps to redirect to the cart page
             * when we click the order button
             */
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cart.class);
                startActivity(i);
            }
        });
    }
}