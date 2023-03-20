package com.saifurrijaal.praktikummodul3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HeadActivity extends AppCompatActivity {

    ImageView ivKumis, ivAlis, ivRambut, ivJanggut;
    CheckBox checkKumis, checkAlis, checkJanggut, checkRambut;
    TextView tvWelcome, tvPassword;
    AppCompatButton btnContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        ivAlis = findViewById(R.id.iv_eyebrow);
        ivKumis = findViewById(R.id.iv_mustache);
        ivRambut = findViewById(R.id.iv_hair);
        ivJanggut = findViewById(R.id.iv_beard);
        checkKumis = findViewById(R.id.check_kumis);
        checkAlis = findViewById(R.id.check_alis);
        checkRambut = findViewById(R.id.check_rambut);
        checkJanggut = findViewById(R.id.check_janggut);
        tvWelcome = findViewById(R.id.tv_welcome);
        tvPassword = findViewById(R.id.tv_password);
        btnContactUs = findViewById(R.id.btn_contact_us);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        tvWelcome.setText("Welcome " + email);
        tvPassword.setText(password);

        checkAlis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivAlis.setVisibility(View.VISIBLE);
                } else {
                    ivAlis.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkRambut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivRambut.setVisibility(View.VISIBLE);
                } else {
                    ivRambut.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkKumis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivKumis.setVisibility(View.VISIBLE);
                } else {
                    ivKumis.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkJanggut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivJanggut.setVisibility(View.VISIBLE);
                } else {
                    ivJanggut.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

    }
}