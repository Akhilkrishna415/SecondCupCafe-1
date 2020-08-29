package com.example.secondcupcafe;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Get Breakfast menu for Category Menu!</h1>
 * This breakfast menu displays all the breakfast items in this page.
 *
 * @author naveen sadineni
 * @version 1.0
 */
public class BreakfastMenu extends AppCompatActivity {
    //    ListView BreakFastlist;
    RecyclerView prodItemRecycler;
    BreakfastAdapter breakfastAdapter;
    FirebaseFirestore db;
    final List<BreakfastModel> breakfastList = new ArrayList<>();

    //    String mTitle[] ={"Donut","Bagel","Burger","croissant"};
//    int image[] ={R.drawable.breaktwo,R.drawable.breakthree,R.drawable.breakfour,R.drawable.breakone};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_menu);
        prodItemRecycler = findViewById(R.id.product_recycler);
        Log.d("sanjay", "Before finding Breakfast list view id");
//        BreakFastlist = findViewById(R.id.product_recycler);
        Log.d("sanjay", "Before finding Breakfast list loadMenu");
        loadBreakfastMenu();
//        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();
//        for (int x = 0; x < 4; x++){
//            HashMap<String, String> hm = new HashMap<String,String>();
//            hm.put("ListTitle",mTitle[x]);
////            hm.put("ListDescription",ListviewDescription[x]);
//            hm.put("ListImages",Integer.toString(image[x]));
//            aList.add(hm);
//        }
//        String[] from = {
//                "ListImages","ListTitle"
//        };
//        int[] to = {
//                R.id.image,R.id.imagetitle
//        };
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(),aList, R.layout.listview_frame,from,to);
//        ListView simpleListview = (ListView)findViewById(R.id.breaklist);
//        simpleListview.setAdapter(simpleAdapter);
//        simpleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                if (position == 0) {
//                    Intent i = new Intent(getApplicationContext(), BreakfastItemOne.class);
//                    startActivity(i);
//                    //code specific to first list item
//                    //Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
//                } else if (position == 1) {
//                    //code specific to 2nd list item
//                    Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
//                } else if (position == 2) {
//                    Toast.makeText(getApplicationContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
//                } else if (position == 3) {
//                    Toast.makeText(getApplicationContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
//                } else if (position == 4) {
//                    Toast.makeText(getApplicationContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    private void loadBreakfastMenu() {
        db = FirebaseFirestore.getInstance();
        Log.d("sanjay", "Entering Breakfast list loadMenu");
        db.collection("breakfast_menu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("sanjay", document.getId() + " => " + document.getData());
                                System.out.println("Hello" + document.getId() + " => " + document.getData());
                                String name = (String) document.getData().get("item_name");
                                String price = (String) document.getData().get("price");
                                String imageurl = (String) document.getData().get("item_image");
//                                getImage(id,image,name,description,size,price,productsList,subbrand,detail_image);
                                breakfastList.add(new BreakfastModel(name, price, imageurl));
                                setProdItemRecycler(breakfastList);
                                System.out.println("Hello" + document.getId() + " => " + document.getData() + "==> " + breakfastList.toString());
                            }
                        } else {
                            Log.d("", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    private void setProdItemRecycler(List<BreakfastModel> breakfastList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        breakfastAdapter = new BreakfastAdapter(this, breakfastList);
        prodItemRecycler.setAdapter(breakfastAdapter);
    }
}