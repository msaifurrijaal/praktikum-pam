package com.saifurrijaal.praktikummodul3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etEmail;
    EditText etPassword;
    TextView tvRegister;
    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        tvRegister = findViewById(R.id.tv_register);

        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");

        if (email != null && password != null) {
            etEmail.setText(email);
            etPassword.setText(password);
        }

        tvRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

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
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        etEmail.setText("");
        etPassword.setText("");
    }
}