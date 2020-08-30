package com.example.secondcupcafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * Adapter class for the Breakfast menu which controls the items display in the recycler view
 *
 * @author sanjay
 */
public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ProductViewHolder> {

    Context context;
    List<BreakfastModel> breakfastlist;


    /**
     * Constructor for the Breakfast Adapter
     * @param context
     * @param breakfastlist array list of the items of breakfast
     */
    public BreakfastAdapter(Context context, List<BreakfastModel> breakfastlist) {
        this.context = context;
        this.breakfastlist = breakfastlist;
    }

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {

//        Picasso.get().load(breakfastlist.get(position).getImageURL()).into(holder.prodImage);
        holder.prodName.setText(breakfastlist.get(position).getTitle());
        holder.prodPrice.setText(breakfastlist.get(position).getPrice() + " $");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, BreakfastItemOne.class);

                Bundle b = new Bundle();


                String name = breakfastlist.get(position).getTitle();
                String price = breakfastlist.get(position).getPrice();
//                String image = breakfastlist.get(position).getImageURL();


                b.putString("Name", name);
                b.putString("Price", price);
//                b.putString("Image", String.valueOf(image));


                i.putExtras(b);
                context.startActivity(i/*, activityOptions.toBundle()*/);
            }
        });


    }


    public int getItemCount() {
        return breakfastlist.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView prodImage;
        TextView prodName, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
//            prodImage = itemView.findViewById(R.id.product_img);
            prodName = itemView.findViewById(R.id.item_name);
            prodPrice = itemView.findViewById(R.id.item_price);

        }
    }

}
