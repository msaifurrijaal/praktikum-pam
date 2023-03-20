package com.saifurrijaal.praktikummodul3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnLogin;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (!email.equals("msaifurrijaal@gmail.com") || !password.equals("215150701111006")) {
                    Toast.makeText(MainActivity.this, "Email atau password yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                } else if (email.equals("msaifurrijaal@gmail.com") && password.equals("215150701111006")) {
                    Toast.makeText(MainActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), HeadActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }
}