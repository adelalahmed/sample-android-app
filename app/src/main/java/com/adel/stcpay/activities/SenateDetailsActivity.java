package com.adel.stcpay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.adel.stcpay.MyApplication;
import com.adel.stcpay.R;
import com.adel.stcpay.domain.Senate;
import com.adel.stcpay.presenters.DetailsPresenter;
import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;

public class SenateDetailsActivity extends AppCompatActivity {

    private DetailsPresenter presenter;
    // UI Elements
    public CircularImageView partyIcon;
    public ImageButton backButton;
    // Card Elements
    public TextView senatorName, senatorLink, bioLink, partyName;
    // Infromation Elements
    public TextView addressTv, officeTv, nameTv, birthdayTv, endDateTv, genderTv, sortNameTv, websiteTv, phoneTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        // extract senate information from the intent
        Intent incomingIntent = getIntent();
        String text = incomingIntent.getStringExtra("senateInformation");
        Senate s = extract(text);

        // link UI elements with the code
       setContentView(R.layout.activity_details);
       initUI();

        // Link with the presenter layer
        presenter = new DetailsPresenter(this);
        presenter.showSenateDetails(s);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private Senate extract(String t){
        Senate s =  new Senate();
        Gson gson = new Gson();
        s = gson.fromJson(t, Senate.class);
        return  s;
    }

    private void initUI(){
        backButton = (ImageButton) findViewById(R.id.imageButton17);
        partyIcon   = (CircularImageView)findViewById(R.id.dv_party_icon);
        senatorName = (TextView) findViewById(R.id.dv_senator_name_tv);
        senatorLink = (TextView) findViewById(R.id.dv_senator_link);
        bioLink     = (TextView) findViewById(R.id.dv_bioLink);
        partyName   = (TextView) findViewById(R.id.dv_partyName_tv);
        addressTv   = (TextView) findViewById(R.id.dt_tv_address);
        officeTv    = (TextView) findViewById(R.id.dt_tv_office);
        nameTv      = (TextView) findViewById(R.id.dt_tv_name);
        birthdayTv  = (TextView) findViewById(R.id.dt_tv_birthday);
        endDateTv   = (TextView) findViewById(R.id.dt_tv_endDate);
        genderTv    = (TextView) findViewById(R.id.dt_tv_gender);
        sortNameTv  = (TextView) findViewById(R.id.dt_tv_sortName);
        websiteTv   = (TextView) findViewById(R.id.dt_tv_website);
        phoneTv     = (TextView) findViewById(R.id.dt_tv_phone);
    }


}
