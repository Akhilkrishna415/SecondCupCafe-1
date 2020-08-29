package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * This class helps to display the cold  items added for cart
 * @author naveen sadineni
 */

public class coldItemOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_item_one);

       Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method is used to display the ordered cold item to the cart page
             */

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cart.class);
                startActivity(i);
            }
        });
    }
}