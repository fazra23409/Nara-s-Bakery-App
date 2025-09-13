package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class landpage extends AppCompatActivity {
    Button buttonRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landpage);
        buttonRegis = findViewById(R.id.buttonRegis);

        // Kasih event klik
        buttonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pindah ke register activity
                Intent intent = new Intent(landpage.this, login.class);
                startActivity(intent);

                // kalau mau landpage ditutup biar gak bisa balik
                // finish();
            }
        });
    }
}