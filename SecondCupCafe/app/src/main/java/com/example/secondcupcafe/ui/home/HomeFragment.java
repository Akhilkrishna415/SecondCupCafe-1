package com.example.secondcupcafe.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.secondcupcafe.R;

/**
 * Fragment class for the home page
 * inflates the home page
 * @author nikhil grover
 */
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        VideoView video = (VideoView) rootView.findViewById(R.id.simpleVideoView);
        video.setVideoURI(Uri.parse("android.resource://" +getActivity().getPackageName()+ "/raw/" + R.raw.medianame));
        video.start();
        video.requestFocus();

        Button go2order;
        go2order = rootView.findViewById(R.id.go2order);
        go2order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),Order.this);
                Toast.makeText(getActivity().getApplicationContext(), "Going to order now!",
                        Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

}
