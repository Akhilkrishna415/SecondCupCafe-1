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
 * CoffeMenu  class to get the list of items for category Coffee
 * Utilising a list view items and setting to the Coffee menu xml
 * @author nikhil
 */
public class CoffeeMenu extends AppCompatActivity {
    final List<BreakfastModel> Coffeelist = new ArrayList<>();
    /*  ListView Coffeelist;
      String mTitle[] ={"Mocha","Expresso","Black coffee","capaccinno","turkish","latte"};
      int image[] ={R.drawable.cofone,R.drawable.coftwo,R.drawable.cofthree,R.drawable.cofee};
      */
    //img and title in array
    RecyclerView prodItemRecycler;
    BreakfastAdapter breakfastAdapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_menu);

        prodItemRecycler = findViewById(R.id.product_recycler);
        Log.d("sanjay", "Before finding Breakfast list view id");
//        BreakFastlist = findViewById(R.id.product_recycler);
        Log.d("sanjay", "Before finding Breakfast list loadMenu");
        loadCoffeeMenu();
     /*    Coffeelist = findViewById(R.id.listtwo);
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
    */
    }

    private void loadCoffeeMenu() {
        db = FirebaseFirestore.getInstance();
        Log.d("sanjay", "Entering coffee list loadMenu");
        db.collection("cofee_menu")
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
                                Coffeelist.add(new BreakfastModel(name, price, imageurl));
                                setProdItemRecycler(Coffeelist);
                                System.out.println("Hello" + document.getId() + " => " + document.getData() + "==> " + Coffeelist.toString());
                            }

                        } else {
                            Log.d("", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
    private void setProdItemRecycler(List<BreakfastModel> coffeelist) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        breakfastAdapter = new BreakfastAdapter(this, Coffeelist);
        prodItemRecycler.setAdapter(breakfastAdapter);
    }
}
