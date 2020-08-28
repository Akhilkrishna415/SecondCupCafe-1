package com.example.secondcupcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Editprofile extends AppCompatActivity {
    private static final String TAG="TAG";
    EditText profilefullname,profileemail,profilenumber;
    Button saveBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent data=getIntent();
        String fullname=data.getStringExtra("fullname");
        String email=data.getStringExtra("Email");
        String Phonenumber=data.getStringExtra("Phonenumber");

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        user=fAuth.getCurrentUser();

        profilefullname=findViewById(R.id.ETFirstname);
        profileemail=findViewById(R.id.ETemail);
        profilenumber=findViewById(R.id.ETphnumber);
        saveBtn=findViewById(R.id.saveprofileinfo);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(profilefullname.getText().toString().isEmpty() || profileemail.getText().toString().isEmpty() || profilenumber.getText().toString().isEmpty()){
                    Toast.makeText(Editprofile.this,"one or many fields are empty",Toast.LENGTH_SHORT).show();
                    return;
                }

                final String email =profileemail.getText().toString();
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docref=fStore.collection("Users").document(user.getUid());
                        Map<String,Object> edited = new HashMap<>();
                        edited.put("Email",email);
                        edited.put("Name",profilefullname.getText().toString());
                        edited.put("Phone Number",profilenumber.getText().toString());
                        docref.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Editprofile.this,"profile updated",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Personalsettings.class));
                                finish();
                            }
                        });
                        Toast.makeText(Editprofile.this,"Email is changed ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Editprofile.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        profilefullname.setText(fullname);
        profileemail.setText(email);
        profilenumber.setText(Phonenumber);

    }
}