package com.mbsoft.elsafeir.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mbsoft.elsafeir.Models.CategoryModel;
import com.mbsoft.elsafeir.R;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryModel> categoryModels;
    private CategoryAdapter.OnItemClick mOnItemClick;
    private Context context;
    String x = "";

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels, Context context
            , CategoryAdapter.OnItemClick mOnItemClick) {
        this.categoryModels = categoryModels;
        this.mOnItemClick = mOnItemClick;
        this.context = context;
    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, viewGroup, false);
        return new CategoryAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CategoryModel itemMode = categoryModels.get(i);
        viewHolder.catgry_name.setText(itemMode.getName());
        }


    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView catgry_name;
        ImageView ctgry_image;

        public ViewHolder(View itemView) {
            super(itemView);
            catgry_name = itemView.findViewById(R.id.catgry_name);
            ctgry_image = itemView.findViewById(R.id.ctgry_image);
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