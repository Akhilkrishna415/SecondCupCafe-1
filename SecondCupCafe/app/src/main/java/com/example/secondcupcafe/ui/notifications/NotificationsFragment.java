package com.example.secondcupcafe.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.secondcupcafe.Contactus;
import com.example.secondcupcafe.Login;
import com.example.secondcupcafe.Payment;
import com.example.secondcupcafe.Personalsettings;
import com.example.secondcupcafe.R;
import com.example.secondcupcafe.Rating;
import com.example.secondcupcafe.Signup;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Fragment class for the profile page
 * inflates the personal settings page
 * @author nikhil grover
 */
public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        TextView personalSettings,payment,rating,contactUs;
        Button Signout;

        personalSettings = root.findViewById(R.id.textView);
        personalSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), Personalsettings.class);
                startActivity(i);
            }
        });
        rating=root.findViewById(R.id.textView4);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), Rating.class);
                startActivity(i);

            }
        });
        contactUs=root.findViewById(R.id.textView3);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), com.example.secondcupcafe.Contactus.class);
                startActivity(i);

            }
        });
        payment=root.findViewById(R.id.textView2);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), Payment.class);
                startActivity(i);
            }
        });
        Signout = root.findViewById(R.id.logout);
        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
                startActivity(intent);
            }
        });
    return root;
    }
}
