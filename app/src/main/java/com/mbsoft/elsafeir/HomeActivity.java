package com.mbsoft.elsafeir;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.google.gson.Gson;
import com.mbsoft.elsafeir.Adapters.CategoryAdapter;
import com.mbsoft.elsafeir.Adapters.ProductAdapter;
import com.mbsoft.elsafeir.Models.CategoryModel;
import com.mbsoft.elsafeir.Models.ProductModel;
import com.mbsoft.elsafeir.Utils.Constants;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    PagerIndicator pagerIndicator;
    HashMap<String, String> url_maps;
    private com.daimajia.slider.library.SliderLayout  mDemoSlider1;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter,productAdapter2,productAdapter3,productAdapter4;
    ArrayList<CategoryModel> categoryModels;
    ArrayList<ProductModel> productModels,productModels2,productModels3,productModels4;
    RecyclerView RV,RV1,RV2,RV3,RV4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Slider Identifier
        mDemoSlider1 = (SliderLayout) findViewById(R.id.slider);
        pagerIndicator = findViewById(R.id.custom_indicator);

        RV = findViewById(R.id.RV);
        categoryModels = new ArrayList<>();
        categoryModels.add(new CategoryModel("Catgry1 "));
        categoryModels.add(new CategoryModel("8salat"));
        categoryModels.add(new CategoryModel("Conditions"));
        categoryModels.add(new CategoryModel("test"));
        categoryModels.add(new CategoryModel("test"));
        categoryModels.add(new CategoryModel("test"));
        categoryModels.add(new CategoryModel());
        categoryModels.add(new CategoryModel());
        categoryModels.add(new CategoryModel());
        categoryModels.add(new CategoryModel());
        categoryAdapter = new CategoryAdapter(categoryModels, HomeActivity.this, new CategoryAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {
                 Intent intent = new Intent(HomeActivity.this,SpecificCategoryActivity.class);
                 intent.putExtra(""+ Constants.Title,categoryModels.get(position).getName());
                 startActivity(intent);
            }
        });
        RV.setAdapter(categoryAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL,false);
        RV.setLayoutManager(mLayoutManager);

        // Most recent products RecyclerView

        RV1 = findViewById(R.id.RV1);
        productModels2 = new ArrayList<>();
        productModels2.add(new ProductModel("1111 LE","1022 LE","50 % ","duhekufgefuygfkusvjhsgfsjvdag" +
                "vchsgvcsadgvchagadsvjgvdajcgsdhagcshashfdsyew"));
        productModels2.add(new ProductModel("8765 LE","1022 LE","50 % ","duhekufgefuygfkuyew"));
        productModels2.add(new ProductModel("9000 LE","1022 LE","50 % ","duhekusfnvjkdbs khvfgefuygfkuyew"));
        productModels2.add(new ProductModel("8799 LE","1022 LE","50 % ","duhekufgefuygfkuyew"));
        productModels2.add(new ProductModel("1111 LE","1022 LE","50 % ","duhekufgefhsbvhjdfsuygfkuyew"));
        productModels2.add(new ProductModel("1111 LE","1022 LE","50 % ","duhekufgefuygfkuyew"));
        productAdapter = new ProductAdapter(productModels2, "0",HomeActivity.this, new ProductAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        RV1.setAdapter(productAdapter);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        //  GridLayoutManager mGridManager = new GridLayoutManager(HomeActivity.this, 2,1,false);
            GridLayoutManager mGridManager = new GridLayoutManager(HomeActivity.this, 1,GridLayout.HORIZONTAL,false);

        RV1.setLayoutManager(mGridManager);

// new product offers RecyclerView


        RV2 = findViewById(R.id.RV2);
        productModels = new ArrayList<>();
        productModels.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkusvjhsgfsjvdag" +
                "vchsgvcsadgvchagadsvjgvdajcgsdhagcshashfdsyew"));
        productModels.add(new ProductModel("8765", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("9000", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("8799", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productAdapter2 = new ProductAdapter(productModels, "1", HomeActivity.this, new ProductAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        RV2.setAdapter(productAdapter2);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL,false);
        RV2.setLayoutManager(mLayoutManager2);

        //TVs and projectors RecyclerView
        RV3 = findViewById(R.id.RV3);
        productModels3 = new ArrayList<>();
        productModels3.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkusvjhsgfsjvdag" +
                "vchsgvcsadgvchagadsvjgvdajcgsdhagcshashfdsyew"));
        productModels3.add(new ProductModel("8765", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels3.add(new ProductModel("9000", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels3.add(new ProductModel("8799", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels3.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels3.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productAdapter3 = new ProductAdapter(productModels3, "1", HomeActivity.this, new ProductAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        RV3.setAdapter(productAdapter3);
        LinearLayoutManager mLayoutManager3 = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL,false);
        RV3.setLayoutManager(mLayoutManager3);

//Air conditioners RecyclerView
        RV4 = findViewById(R.id.RV4);
        productModels4 = new ArrayList<>();
        productModels4.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkusvjhsgfsjvdag" +
                "vchsgvcsadgvchagadsvjgvdajcgsdhagcshashfdsyew"));
        productModels4.add(new ProductModel("8765", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels4.add(new ProductModel("9000", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels4.add(new ProductModel("8799", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels4.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productModels4.add(new ProductModel("1111", "1022 LE", "50 % ", "duhekufgefuygfkuyew"));
        productAdapter4 = new ProductAdapter(productModels4, "1", HomeActivity.this, new ProductAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(int position) {

            }
        });
        RV4.setAdapter(productAdapter4);
        LinearLayoutManager mLayoutManager4 = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL,false);
        RV4.setLayoutManager(mLayoutManager4);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);









    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //to remove the 3 dots in toolbar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    //get Image and pass to slider
//    private void get_home_sliders() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Connectors.connectionServices.BaseURL)
//                .addConverterFactory(GsonConverterFactory
//                        .create(new Gson())).build();
//        Connectors.connectionServices getRegistrationsConnectionServices =
//                retrofit.create(Connectors.connectionServices.class);
//        getRegistrationsConnectionServices.get_Sliders().enqueue(new Callback<StatusModel>() {
//            @Override
//            public void onResponse(Call<StatusModel> call, Response<StatusModel> response) {
//                Log.d("TTT", "onResponse: " + response.toString());
//                StatusModel statusModel = response.body();
//                if (statusModel.getStatus()) {
//
//                    ArrayList<String> Title = new ArrayList<>();
//                    for (int i = 0; i < statusModel.getSliders().size(); i++) {
//                        T = statusModel.getSliders().get(i).getId();
//
//                        url_maps.put("http://www.makfi-sa.com/mkfy/prod_img/" + statusModel.getSliders().get(i).getName(), T);
//                        Title.add("" + statusModel.getSliders().get(i).getName());
//
//
//                    }
//                    ///////////////
//                    Hawk.put(Constants.images, Title);
//                    Hawk.put("y333", "0");
//                    ///////////////
//                    for (String name : url_maps.keySet()) {
//                        CustomSliderView textSliderView = new CustomSliderView(ClientHomeActivity.this);
//                        // initialize a SliderLayout
//                        textSliderView
//                                .description(url_maps.get(name))
//                                .image(name)
//                                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
//                                    @Override
//                                    public void onSliderClick(BaseSliderView slider) {
//                                        startActivity(new Intent(ClientHomeActivity.this, SliderAcivity1.class));
//
//                                    }
//                                })
//                                .setScaleType(BaseSliderView.ScaleType.Fit);
//                        //add your extra information
//                        textSliderView.bundle(new Bundle());
//                        textSliderView.getBundle()
//                                .putString("extra", name);
//
//                        mDemoSlider1.addSlider(textSliderView);
//                    }
//
//                    mDemoSlider1.setPresetTransformer(SliderLayout.Transformer.Default);
//                    mDemoSlider1.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//                    mDemoSlider1.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
//                    mDemoSlider1.setCustomAnimation(new DescriptionAnimation());
//                    mDemoSlider1.setDuration(3000);
//                    mDemoSlider1.setCustomIndicator(pagerIndicator1);
//
//
//                    //setSliderViews(IMGs, Descs);
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<StatusModel> call, Throwable t) {
//                Snackbar.make(parentLayout, "" + getString(R.string.noInternetConnecion), Snackbar.LENGTH_LONG)
//                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
//                        .show();
//            }
//        });
//
//    }

}
