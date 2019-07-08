package com.mbsoft.elsafeir.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mbsoft.elsafeir.Models.CategoryModel;
import com.mbsoft.elsafeir.Models.ProductModel;
import com.mbsoft.elsafeir.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<ProductModel> productModels;
    private ProductAdapter.OnItemClick mOnItemClick;
    private Context context;
    String type;
    String x = "";

    public ProductAdapter(ArrayList<ProductModel> productModels, String type, Context context
            , ProductAdapter.OnItemClick mOnItemClick) {
        this.productModels = productModels;
        this.mOnItemClick = mOnItemClick;
        this.type = type;
        this.context = context;
    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, viewGroup, false);
        return new ProductAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ProductModel itemMode = productModels.get(i);

        if(type.equals("0")){
            viewHolder.old_price.setVisibility(View.GONE);
            viewHolder.discount_section.setVisibility(View.GONE);
        }

        viewHolder.percent.setText(itemMode.getPercent());
        //scratch on text
        viewHolder.old_price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        viewHolder.old_price.setText(itemMode.getOldPrice());
        viewHolder.new_price.setText(itemMode.getNewPrice());
        viewHolder.description.setText(itemMode.getDescription());
        viewHolder.add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.fav.setColorFilter(ContextCompat.getColor(context, R.color.red));

            }
        });
        viewHolder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        }


    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView product_image, add_to_cart,fav;
        TextView  percent,description,old_price,new_price,buy;
        LinearLayout discount_section;

        public ViewHolder(View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            percent = itemView.findViewById(R.id.percent);
            description = itemView.findViewById(R.id.description);
            old_price = itemView.findViewById(R.id.old_price);
            new_price = itemView.findViewById(R.id.new_price);
            add_to_cart = itemView.findViewById(R.id.add_to_cart);
            fav = itemView.findViewById(R.id.fav);
            buy = itemView.findViewById(R.id.buy);
            discount_section = itemView.findViewById(R.id.discount_section);

            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            itemView.getLayoutParams().width= (int) ((width)/2.3);
             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnItemClick.setOnItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClick {
        void setOnItemClick(int position);
    }
}