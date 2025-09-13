package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class login extends AppCompatActivity {
    EditText email1, password1;
    Button buttonLogin;
    TextView textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email1 = findViewById(R.id.email1);
        password1 = findViewById(R.id.password1);
        buttonLogin = findViewById(R.id.buttonLogin);
        textview2 = findViewById(R.id.textview2); // "Already have an account? Sign in"

        // klik tombol sign up
        buttonLogin.setOnClickListener(v -> {
            String email = email1.getText().toString().trim();
            String password = password1.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty() ) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show();
            } else {
                // nanti ini bisa dihubungkan ke database/server
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(login.this, MainActivity.class)); finish();

            }
        });

        textview2.setOnClickListener(v -> {
            startActivity(new Intent(login.this, register.class));
            Toast.makeText(this, "Pindah ke halaman register", Toast.LENGTH_SHORT).show();
        });
    }
}
