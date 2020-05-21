package com.adel.stcpay.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adel.stcpay.R;
import com.adel.stcpay.presenters.SenatePresenter;

public class MainActivity extends AppCompatActivity {

    private SenatePresenter presenter;

    public ListView senatesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        senatesListView = findViewById(R.id.senatesListView);

        presenter = new SenatePresenter(this);
        presenter.loadAllSenates();


        senatesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.showSenateDetails(i);
            }
        });
    }
}
