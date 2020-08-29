package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * This class helps to display the coffee items added for cart
 * @author naveen sadineni
 */

public class CoffeeDrinkOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_drink_one);

        Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method is used to display the ordered coffee item to the cart page
             */

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cart.class);
                startActivity(i);


            }
        });
    }
}