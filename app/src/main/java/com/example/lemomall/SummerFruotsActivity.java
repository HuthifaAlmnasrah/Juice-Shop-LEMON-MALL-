package com.example.lemomall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lemomall.Adapter.FruitAdapter;
import com.example.lemomall.Model.FruitItem;

import java.util.ArrayList;
import java.util.List;

public class SummerFruotsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView back, menu;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_fruots);

        initViews();
    }

    private void initViews() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title = findViewById(R.id.title);
        title.setText("SUMMER FRUITS");
        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        recyclerView = findViewById(R.id.recycler_view);
        List<FruitItem> items = new ArrayList<>();
        items.add(new FruitItem(R.drawable.apple, "APPLE", 2));
        items.add(new FruitItem(R.drawable.bananas, "BANANAS", 1.5));
        items.add(new FruitItem(R.drawable.strawberry, "STRAWBERRY", 3));
        items.add(new FruitItem(R.drawable.fruit, "ORANGE", 3));
        FruitAdapter adapter = new FruitAdapter(items, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
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
                startActivity(new Intent(SummerFruotsActivity.this, AccountActivity.class));
            }
        });
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(SummerFruotsActivity.this, BasketActivity.class));
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(SummerFruotsActivity.this, OrdersActivity.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SummerFruotsActivity.this, LoginActivity.class));
                finish();
            }
        });
        dialog.show();
    }
}