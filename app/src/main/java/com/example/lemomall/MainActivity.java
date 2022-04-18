package com.example.lemomall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lemomall.Adapter.SlideAdapter;
import com.example.lemomall.Adapter.TypesAdapter;
import com.example.lemomall.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ViewPager2 viewPager;
    private ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        TypesAdapter typesAdapter = new TypesAdapter(this, new String[]{"SUMMER FRUITS","NEW FRUITS", "WINTER FRUITS", "GREEN FRUITS"});
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(typesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (typesAdapter.getItem(i).equals("SUMMER FRUITS")){
                    startActivity(new Intent(MainActivity.this, SummerFruotsActivity.class));
                }
                else if (typesAdapter.getItem(i).equals("NEW FRUITS")){
                    startActivity(new Intent(MainActivity.this, NewFruitsActivity.class));
                }
                else if (typesAdapter.getItem(i).equals("WINTER FRUITS")){
                    startActivity(new Intent(MainActivity.this, WinterFruitsActivity.class));
                }
                else if (typesAdapter.getItem(i).equals("GREEN FRUITS")){
                    startActivity(new Intent(MainActivity.this, GreenFruitsActivity.class));
                }
            }
        });

        viewPager = findViewById(R.id.view_pager);
        List<Item> items = new ArrayList<>();
        items.add(new Item("SUMMER FRUITS", R.drawable.apple));
        items.add(new Item("NEW FRUITS", R.drawable.bananas));
        items.add(new Item("WINTER FRUITS", R.drawable.strawberry));
        items.add(new Item("GREEN FRUITS", R.drawable.fruit));
        viewPager.setAdapter(new SlideAdapter(items, viewPager));
        viewPager.setClipChildren(false);
        viewPager.setClipToPadding(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        viewPager.setPageTransformer(compositePageTransformer);


        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.menu);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout account, basket, orders, logout;
        account = dialog.findViewById(R.id.account);
        basket = dialog.findViewById(R.id.basket);
        orders = dialog.findViewById(R.id.orders);
        logout = dialog.findViewById(R.id.logout);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
            }
        });
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(MainActivity.this, BasketActivity.class));            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(MainActivity.this, OrdersActivity.class));            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
        dialog.show();
    }
}
