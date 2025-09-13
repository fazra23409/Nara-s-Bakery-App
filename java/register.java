package com.example.bakeryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    EditText username1, email1, password1, vpassword1;
    Button buttonRegis;
    TextView textview1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username1 = findViewById(R.id.username1);
        email1 = findViewById(R.id.email1);
        password1 = findViewById(R.id.password1);
        vpassword1 = findViewById(R.id.vpassword1);
        buttonRegis = findViewById(R.id.buttonRegis);
        textview1 = findViewById(R.id.textview1);

        // Klik tombol Register
        buttonRegis.setOnClickListener(v -> {
            String username = username1.getText().toString().trim();
            String email = email1.getText().toString().trim();
            String password = password1.getText().toString().trim();
            String vPassword = vpassword1.getText().toString().trim();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || vPassword.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(vPassword)) {
                Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(register.this, MainActivity.class));
                finish();
            }
        });
        // Klik "Sudah punya akun? Login"
        textview1.setOnClickListener(v -> {
            startActivity(new Intent(register.this, login.class));
            Toast.makeText(this, "Pindah ke halaman login", Toast.LENGTH_SHORT).show();
        });
    }
}