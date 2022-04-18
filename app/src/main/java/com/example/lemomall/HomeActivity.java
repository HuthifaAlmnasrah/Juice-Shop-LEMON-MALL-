package com.example.lemomall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private ImageView back, menu;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
        title.setText("HOME");
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
                startActivity(new Intent(HomeActivity.this, AccountActivity.class));
            }
        });
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(HomeActivity.this, BasketActivity.class));
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                startActivity(new Intent(HomeActivity.this, OrdersActivity.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });
        dialog.show();
    }
}