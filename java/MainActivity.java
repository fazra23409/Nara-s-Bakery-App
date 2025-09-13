package com.example.bakeryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inisialisasi komponen
        initializeComponents();

        setupBottomNavigation();
        setupProductClickListeners();
    }
    private void initializeComponents() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    showToast("Beranda");
                    return true;
                } else if (itemId == R.id.nav_menu) {
                    showToast("Menu");
                    return true;
                } else if (itemId == R.id.nav_cart) {
                    showToast("Keranjang");
                    return true;
                } else if (itemId == R.id.nav_orders) {
                    showToast("Pesanan");
                    return true;
                } else if (itemId == R.id.nav_profile) {
                    showToast("Profil");
                    return true;
                }
                return false;
            }
        });
        }

    private void setupProductClickListeners() {
        // Click listeners untuk popular items
        setupProductClicks(new int[]{
                R.id.popular_item_1, R.id.popular_item_2,
                R.id.popular_item_3, R.id.popular_item_4
        });

        // Click listeners untuk new arrivals
        setupProductClicks(new int[]{
                R.id.new_arrival_1, R.id.new_arrival_2, R.id.new_arrival_3
        });

        // Click listener untuk banner promo
        LinearLayout promoBanner = findViewById(R.id.promo_banner_card);
        if (promoBanner != null) {
            promoBanner.setOnClickListener(v -> {
                animateView(v);
                showToast("Lihat promo spesial!");
            });
        }
// Click listener untuk keranjang di header
        ImageView cartIcon = findViewById(R.id.cart_icon);
        if (cartIcon != null) {
            cartIcon.setOnClickListener(v -> {
                animateView(v);
                showToast("Lihat keranjang belanja");
                bottomNavigationView.setSelectedItemId(R.id.nav_cart);
            });
        }
    }

    private void setupProductClicks(int[] viewIds) {
        for (int id : viewIds) {
            View view = findViewById(id);
            if (view != null) {
                view.setOnClickListener(v -> {
                    animateView(v);
                    showProductDetail(v);
                });
            }
        }
    }
    private void animateView(View view) {
        ViewPropertyAnimatorCompat animator = ViewCompat.animate(view)
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction(() -> ViewCompat.animate(view)
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .start());
        animator.start();
    }
    private void showProductDetail(View view) {
        String productName = "";
        int productPrice = 0;
        int productImage = 0;
        String productDesc = "";

//      cari data produk berdasarkan view
        int id = view.getId();
        if (id == R.id.popular_item_1) {
            productName = "Cheesy Toast";
            productPrice = 15000;
            productImage = R.drawable.bacon;
            productDesc = "Roti panggang keju lumer, cocok untuk sarapan.";
        } else if (id == R.id.popular_item_2) {
            productName = "Sandwich";
            productPrice = 20000;
            productImage = R.drawable.sandwich;
            productDesc = "Sandwich isi daging dan sayur segar.";
        } else if (id == R.id.popular_item_3) {
            productName = "Strawberry Cake";
            productPrice = 30000;
            productImage = R.drawable.cake;
            productDesc = "Kue lembut dengan topping strawberry manis.";
        } else if (id == R.id.popular_item_4) {
            productName = "Roti Sedap";
            productPrice = 10000;
            productImage = R.drawable.loaf;
            productDesc = "Roti hangat dengan rasa gurih.";
        } else if (id == R.id.new_arrival_1) {
            productName = "Daifuku Mochi";
            productPrice = 12000;
            productImage = R.drawable.mochi;
            productDesc = "Mochi Rasa matcha dengan fiiling strawberry.";
        } else if (id == R.id.new_arrival_2) {
            productName = "Red Velvet Cake";
            productPrice = 18000;
            productImage = R.drawable.redvelvet;
            productDesc = "Slice kue Red velvet yang manis.";
        } else if (id == R.id.new_arrival_3) {
            productName = "Mile Crepes";
            productPrice = 25000;
            productImage = R.drawable.mile_crepes;
            productDesc = "mile crepes coklat.";
        }

        // Kirim data produk ke detail_produk
        Intent intent = new Intent(MainActivity.this, detail_produk.class);
        intent.putExtra("PRODUCT_NAME", productName);
        intent.putExtra("PRODUCT_PRICE", productPrice);
        intent.putExtra("PRODUCT_IMAGE", productImage);
        intent.putExtra("PRODUCT_DESCRIPTION", productDesc);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(this, "Tekan kembali lagi untuk keluar", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    }