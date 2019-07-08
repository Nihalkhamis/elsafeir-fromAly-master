package com.mbsoft.elsafeir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbsoft.elsafeir.Adapters.ProductAdapter;
import com.mbsoft.elsafeir.Models.CategoryModel;
import com.mbsoft.elsafeir.Models.ProductModel;
import com.mbsoft.elsafeir.Utils.Constants;

import java.util.ArrayList;

public class SpecificCategoryActivity extends AppCompatActivity {

    ProductAdapter productAdapter;
    ArrayList<ProductModel> productModels;
    RecyclerView RV;
    ImageView back;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title = findViewById(R.id.title);
        if (getIntent().hasExtra(Constants.Title)) {
            title.setText(getIntent().getStringExtra(Constants.Title));
        } else {
            title.setText("");
        }
        RV = findViewById(R.id.RV);
        productModels = new ArrayList<>();
        productModels.add(new ProductModel("1111 LE", "1022 LE", "50 % ", "duhekufgefuygfkusvjhsgfsjvdag" +
                "vchsgvcsadgvchagadsvjgvdajcgsdhagcshashfdsyew"));
        productModels.add(new ProductModel("8765 LE", "10 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("9000 LE", "1022 LE", "50 % ", "duhekusfnvjkdbs khvfgefuygfkuyew"));
        productModels.add(new ProductModel("8799 LE", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("1111 LE", "1022 LE", "50 % ", "duhekufgefhsbvhjdfsuygfkuyew"));
        productModels.add(new ProductModel("1111 LE", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productAdapter = new ProductAdapter(productModels, "0", SpecificCategoryActivity.this, new ProductAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        RV.setAdapter(productAdapter);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //  GridLayoutManager mGridManager = new GridLayoutManager(HomeActivity.this, 2,1,false);
        GridLayoutManager mGridManager = new GridLayoutManager(SpecificCategoryActivity.this, 2, GridLayout.VERTICAL, false);

        RV.setLayoutManager(mGridManager);

    }
}
