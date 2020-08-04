package com.example.secondcupcafe;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button go2order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        videoView = findViewById(R.id.simpleVideoView);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);


//        Uri uri = Uri.parse("https://www.youtube.com/embed/TIyI2jVviI4");
        String mediaName = "medianame";
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/" + mediaName);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        videoView.start();

        go2order = findViewById(R.id.go2order);
        go2order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),Order.this);
                Toast.makeText(getApplicationContext(), "Going to order now!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
