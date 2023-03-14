package com.saifurrijaal.praktikummodul3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class HeadActivity extends AppCompatActivity {

    ImageView ivKumis;
    ImageView ivAlis;
    ImageView ivRambut;
    ImageView ivJanggut;
    CheckBox checkKumis;
    CheckBox checkAlis;
    CheckBox checkRambut;
    CheckBox checkJanggut;


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

    }
}