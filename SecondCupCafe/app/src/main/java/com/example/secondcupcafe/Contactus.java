package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * This class is used to display the contact information of the management of SecondCupCafe
 * @version 1.0
 * @author Akhil Krishna
 */

public class Contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }

    /**
     * This method is used to make a call to given number when he clicks on the call button
     * @param view
     */
    public void call(View view)
    {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:5135699966"));
        startActivity(call);
    }

    /**
     * This method helps user to send a mail to the given E mail address
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