package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detail_produk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        Intent intent = getIntent();
        String productName = intent.getStringExtra("PRODUCT_NAME");
        int productPrice = intent.getIntExtra("PRODUCT_PRICE", 0);
        int productImage = intent.getIntExtra("PRODUCT_IMAGE", 0);
        String productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION");
        String productCategory = "Bakery";

        ImageView iv = findViewById(R.id.ivProductImage);
        TextView tvName = findViewById(R.id.tvProductName);
        TextView tvCat = findViewById(R.id.tvProductCategory);
        TextView tvDesc = findViewById(R.id.tvProductDescription);
        TextView tvPrice = findViewById(R.id.tvProductPrice);

        iv.setImageResource(productImage);
        tvName.setText(productName);
        tvCat.setText(productCategory);
        tvDesc.setText(productDescription);
        tvPrice.setText("Rp " + productPrice);
    }
}