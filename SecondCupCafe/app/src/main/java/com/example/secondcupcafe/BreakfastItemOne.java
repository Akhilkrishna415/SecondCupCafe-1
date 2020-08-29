package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * This class helps to add the breakfast item to the cart
 * @author naveen sadineni
 */

public class BreakfastItemOne extends AppCompatActivity {
Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_item_one);

        order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method helps to move from breakfast screen to cart screen
             */

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cart.class);
                startActivity(i);
            }
        });
    }
}