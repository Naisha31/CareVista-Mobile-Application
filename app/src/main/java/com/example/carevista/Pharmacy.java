package com.example.carevista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.carevista.DiscountedProducts;
import com.example.carevista.DiscountedProductAdapter;
import com.example.carevista.CategoryAdapter;
import com.example.carevista.RecentlyViewed;
import com.example.carevista.RecentlyViewedAdapter;
import com.example.carevista.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import com.example.carevista.R.drawable;

public class Pharmacy extends AppCompatActivity {


    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;
    TextView allCategory;

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        imageview=findViewById(R.id.imageView);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pharmacy.this,Cart.class);
                startActivity(i);
            }
        });


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pharmacy.this, AllCategory.class);
                startActivity(i);
            }
        });

        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, drawable.sofra_discount));
        discountedProductsList.add(new DiscountedProducts(2, drawable.zinc_discount));
        discountedProductsList.add(new DiscountedProducts(3, drawable.multivit_discount));
        discountedProductsList.add(new DiscountedProducts(4, drawable.ben_discount));


        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, drawable.ic_home_fruits));
        categoryList.add(new Category(2, drawable.ic_home_fish));
        categoryList.add(new Category(3, drawable.ic_home_meats));
        categoryList.add(new Category(4, drawable.ic_home_veggies));


        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Dolo 650 Tablet", "A commonly used analgesic (pain reliever) and antipyretic (fever reducer) medication containing paracetamol", "30", "15", "tablets", drawable.dolo_bg, drawable.dolo));
        recentlyViewedList.add(new RecentlyViewed("Crocin Tablet", "A brand of over-the-counter medication commonly used to relieve pain and reduce fever, primarily containing paracetamol", "18", "20", "tablets", drawable.crocin_bg, drawable.crocin));
        recentlyViewedList.add(new RecentlyViewed("Soframycin Cream", "A topical antibiotic cream used to treat various skin infections, cuts, burns, and wounds- All Moms favourite cream!", "45", "30", "g", drawable.cream_bg, drawable.cream));
        recentlyViewedList.add(new RecentlyViewed("Benadryl Syrup", "An antihistamine medication used to relieve symptoms of allergies, such as sneezing, itching, watery eyes, and runny nose", "132", "150", "ml", drawable.benadryl_bg, drawable.benadryl));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }
    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

}