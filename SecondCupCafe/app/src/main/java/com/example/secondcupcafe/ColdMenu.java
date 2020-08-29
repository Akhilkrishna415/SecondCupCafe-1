package com.example.secondcupcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class displays the all the cold category items
 * @author naveen sadineni
 */

public class ColdMenu extends AppCompatActivity {

    ListView Coldlist;
    String mTitle[] ={"Cold Coffee","Ice Tea","ice cap","Coca cola"};
    int image[] ={R.drawable.cold,R.drawable.coldtwo,R.drawable.coldthree,R.drawable.coldfour};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_menu);
        Coldlist = findViewById(R.id.coldlist);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();
        for (int x = 0; x < 4; x++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("ListTitle",mTitle[x]);
//            hm.put("ListDescription",ListviewDescription[x]);
            hm.put("ListImages",Integer.toString(image[x]));
            aList.add(hm);
        }
        String[] from = {
                "ListImages","ListTitle"
        };
        int[] to = {
                R.id.image,R.id.imagetitle
        };
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(),aList, R.layout.listview_frame,from,to);
        ListView simpleListview = (ListView)findViewById(R.id.coldlist);
        simpleListview.setAdapter(simpleAdapter);
        simpleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    Intent i = new Intent(getApplicationContext(), coldItemOne.class);
                    startActivity(i);
                    //code specific to first list item
                    //Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(getApplicationContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(getApplicationContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(getApplicationContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}