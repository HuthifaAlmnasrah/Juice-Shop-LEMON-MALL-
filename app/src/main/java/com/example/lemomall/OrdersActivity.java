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

import com.example.lemomall.Adapter.OrderAdapter;
import com.example.lemomall.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {

    private ImageView back, menu;
    private TextView title;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

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
        title.setText("ORDERS");
        menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORDER 10:1082", 20));
        orders.add(new Order("ORDER 10:1082", 15));
        orders.add(new Order("ORDER 10:1082", 8));
        orders.add(new Order("ORDER 10:1082", 35));
        OrderAdapter adapter = new OrderAdapter(orders, this);
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
                startActivity(new Intent(OrdersActivity.this, AccountActivity.class));
            }
        });
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(OrdersActivity.this, BasketActivity.class));
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(OrdersActivity.this, OrdersActivity.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrdersActivity.this, LoginActivity.class));
                finish();
            }
        });
        dialog.show();
    }
}