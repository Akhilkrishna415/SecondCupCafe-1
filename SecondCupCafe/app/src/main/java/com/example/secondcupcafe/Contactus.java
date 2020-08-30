package com.example.secondcupcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This class helps to display the contact info for the coffee shop
 * @author naveen sadineni/ nikhil grover
 */

public class Contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }

    /**
     * This method helps to dial to the number when we click on the calling button
     * @param view
     */

    public void call(View view)
    {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:5135699966"));
        startActivity(call);
    }

    /**
     * This method helps to redirect to the mail box when we click on the gmail logo
     * @param view
     */


    public void Mail(View view)
    {
        Intent Mail = new Intent(Intent.ACTION_SEND);
        String[] recipients={"mailto@gmail.com"};
        Mail.putExtra(Intent.EXTRA_EMAIL, recipients);
        Mail.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
        Mail.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
        Mail.putExtra(Intent.EXTRA_CC,"secondcupcafemontreal@gmail.com");
        Mail.setType("text/html");
        Mail.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(Mail, "Send mail"));
    }
}