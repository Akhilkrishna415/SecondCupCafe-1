package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;
import  java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;

/**
 * This class is used to display the application logo before the login screen
 * @version 1.0
 * @author Akhil Krishna
 */
public class AppLogo extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_logo);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            /**
             * This method will redirect the user to the login page
             */
            public void run() {
                Intent intent = new Intent(AppLogo.this, Login.class);
                startActivity(intent);
            }},3000);
    }
}

