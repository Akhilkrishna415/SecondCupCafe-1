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

public class CoffeeMenu extends AppCompatActivity {

    ListView Coffeelist;
    String mTitle[] ={"Mocha","Expresso","Black coffee","capaccinno","turkish","latte"};
    int image[] ={R.drawable.cofone,R.drawable.coftwo,R.drawable.cofthree,R.drawable.cofee};
    //img and title in array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_menu);

        Coffeelist = findViewById(R.id.listtwo);
        //creating adapter class
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();
        for (int x = 0; x < 5; x++){
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
        ListView simpleListview = (ListView)findViewById(R.id.listtwo);
        simpleListview.setAdapter(simpleAdapter);

        simpleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {

                    Intent i = new Intent(getApplicationContext(),CoffeeDrinkOne.class);
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
