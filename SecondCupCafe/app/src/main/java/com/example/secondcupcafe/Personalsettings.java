package com.example.secondcupcafe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Personalsettings extends AppCompatActivity {
    Button edit_profile;
    TextView fullname,Email,Phonenumber;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String UserID;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_settings);

        fullname=findViewById(R.id.ETFirstname);
        Email=findViewById(R.id.ETemail);
        Phonenumber=findViewById(R.id.ETphnumber);

        fAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        UserID=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference=fstore.collection("Users").document(UserID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                Phonenumber.setText(documentSnapshot.getString("Phone Number" ));
                fullname.setText(documentSnapshot.getString("Name"));
                Email.setText(documentSnapshot.getString("Email"));

            }
        });

        edit_profile=findViewById(R.id.button2);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Editprofile.class);
                i.putExtra("fullname",fullname.getText().toString());
                i.putExtra("Email",Email.getText().toString());
                i.putExtra("Phonenumber",Phonenumber.getText().toString());
                startActivity(i);
            }
        });



    }
}