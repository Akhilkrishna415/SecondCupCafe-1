package com.example.secondcupcafe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * This class helps to add the breakfast item to the cart
 *
 * @author naveen sadineni
 */

public class BreakfastItemOne extends AppCompatActivity {
    Button order;
    FirebaseFirestore db;
    TextView title, price;
    EditText quantity, instructions;
    private FirebaseUser curUser;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_item_one);

        title = findViewById(R.id.Subtitle);
        price = findViewById(R.id.item_pricev2);
        quantity = findViewById(R.id.quantity);
        instructions = findViewById(R.id.instructions);
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        final Bundle b = getIntent().getExtras();

        final String item_price = b.getString("Price");
        final String item_name = b.getString("Name");
//        final String p_image= b.getString("Image");
        curUser = auth.getCurrentUser();


        title.setText(item_name);
        price.setText(item_price);

        order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * This method helps to move from breakfast screen to order screen
             */

            public void onClick(View v) {

                final String userid = curUser.getUid();
                final String phone = String.valueOf(curUser.getPhoneNumber());
                final String email = String.valueOf(curUser.getEmail());
                final String item_qty = quantity.getText().toString();
                final String deliveryInstructions = instructions.getText().toString();

                Map<String, Object> order = new HashMap<>();
                order.put("userid", userid);
                order.put("Email", email);
//                order.put("phone", phone);
                order.put("Item_name", item_name);
                order.put("Item_price", item_price);
                order.put("Quantitiy", item_qty);
                order.put("Delivery_Instructions", deliveryInstructions);

                db.collection("Orders").add(order).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Your Order has been placed and is on your way.", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("ERROR", "Error writing document", e);
                            }
                        });

            }
        });
    }
}