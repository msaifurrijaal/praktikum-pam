package com.saifurrijaal.praktikummodul3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    AppCompatButton btnCall, btnSMS, btnBrowser;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        btnCall = findViewById(R.id.btn_call);
        btnSMS = findViewById(R.id.btn_sms);
        btnBrowser = findViewById(R.id.btn_browser);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "6285123456789";

                Intent intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intentCall);
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = "6285123456789";
                message = "This is Message";

                Intent intentSMS = new Intent(Intent.ACTION_VIEW,
                        Uri.fromParts("sms", phoneNo, null));
                intentSMS.putExtra("sms_body", message);
                startActivity(intentSMS);
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW);
                intentBrowser.setData(Uri.parse("https://msaifurrijaal.github.io/"));
                startActivity(intentBrowser);
            }
        });
    }
}