package com.example.secondcupcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    Button btnSignUp;
    Button btnExistngUser;
    public EditText emailId, password;
    TextView tvSignin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUp = findViewById(R.id.signUp);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailAddress);
        password = findViewById(R.id.userPassword);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String email = emailId.getText().toString();
                        String pwd = password.getText().toString();
                        if (email.isEmpty()){
                            emailId.setError("Please enter the email ID");
                            emailId.requestFocus();
                        }
                        else if (pwd.isEmpty() && pwd.length() <6){
                            password.setError("Please enter the password with more than 6 characters");
                            password.requestFocus();
                        }
                        else if (email.isEmpty() && pwd.isEmpty()){
                            Toast.makeText(Signup.this,"Fields are Empty!",Toast.LENGTH_SHORT).show();
                        }
                        else  if (!email.isEmpty() && !pwd.isEmpty()){
                            mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(Signup.this,"SignUp Unsuccesful, PLease try again",Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(Signup.this,"Registration Successful. You will be redirected to login page now.",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Signup.this,Login.class));
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(Signup.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                        }
                    }
        });
        btnExistngUser = findViewById(R.id.existingUser);
        btnExistngUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

    }
}