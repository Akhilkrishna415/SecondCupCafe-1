package com.example.secondcupcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

/**
 * This class helps to reset the password if the user forgot the password
 * @author madhu nareddy
 */

public class ResetPassword extends AppCompatActivity {
    Button resetpwdbtn;
    TextView resetPass;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        resetpwdbtn=findViewById(R.id.resetbtn);
        resetPass=findViewById(R.id.resetMail);
        mFirebaseAuth = FirebaseAuth.getInstance();
        resetpwdbtn.setOnClickListener(new View.OnClickListener() {  //setting onclick listner for the reset password button
            @Override
            /**
             * This method is used to redirect to the login page after clicking reset password button
             */

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);

                //getting the entered text to string format

                String mail = resetPass.getText().toString();

                //using the firebase databse sending the link to your registered mail

                mFirebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override

                            /**
                             * This method is used to display the toast message when the function is success
                             */

                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ResetPassword.this, "Reset link sent to your mail", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override

                            /**
                             * This method is used display the toast message if the user enter the wrong information
                             */

                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ResetPassword.this, "Error! Reset link is not sent to your mail" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });
                    }
                });

            }

    }
