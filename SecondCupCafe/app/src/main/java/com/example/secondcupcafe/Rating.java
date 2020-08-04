package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    private RatingBar rBar;
    private TextView tView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        rBar = (RatingBar) findViewById(R.id.ratingBar1);
//            tView = (TextView) findViewById(R.id.textview1);
        btn = (Button)findViewById(R.id.btnGet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int noofstars = rBar.getNumStars();
                float getrating = rBar.getRating();
//                    tView.setText("Rating: "+getrating+"/"+noofstars);
                Toast.makeText(getApplicationContext(), "Thank you for rating us. This keeps us motivated to improve our Application." , Toast.LENGTH_SHORT ).show();
            }
        });
    }
}
