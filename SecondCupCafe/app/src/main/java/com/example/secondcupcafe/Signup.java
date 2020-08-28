package com.example.secondcupcafe;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
public class Signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button btnSignUp;
    Button btnExistngUser;
    public EditText emailId, password, firstName, mobileNumber, birthDate;
    TextView tvSignin;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fstore;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUp = findViewById(R.id.signUp);
        mFirebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        emailId = findViewById(R.id.emailAddress);
        password = findViewById(R.id.userPassword);
        firstName = findViewById(R.id.editTextPersonName);
        mobileNumber = findViewById(R.id.editTextPhone2);
        birthDate = findViewById(R.id.editTextDate);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailId.getText().toString();
                final String pwd = password.getText().toString();
                final String fname = firstName.getText().toString();
                final String mnumber = mobileNumber.getText().toString();
                final String bdate = birthDate.getText().toString();
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
                                Toast.makeText(Signup.this,"SignUp Unsuccessful, PLease try again using another email!",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                FirebaseUser vuser = mFirebaseAuth.getCurrentUser();
                                vuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(Signup.this,"Verification email has been sent",Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: Email not sent"+ e.getMessage());
                                    }
                                });
                                Toast.makeText(Signup.this,"Registration Successful. You will be redirected to login page now.",Toast.LENGTH_SHORT).show();
                                userID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fstore.collection("Users").document(userID);
                                Map<String,Object> user = new HashMap<>();
                                user.put("Name", fname);
                                user.put("Email", email);
                                user.put("D.O.B", bdate);
                                user.put("Phone Number", mnumber);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user profile is created for"+ userID);
                                    }
                                });
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













