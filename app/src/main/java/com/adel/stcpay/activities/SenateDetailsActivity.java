package com.adel.stcpay.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adel.stcpay.R;

public class SenateDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent incomingIntent = getIntent();
        incomingIntent.getStringExtra("senateInformation");
        setContentView(R.layout.activity_main);




    }
}
