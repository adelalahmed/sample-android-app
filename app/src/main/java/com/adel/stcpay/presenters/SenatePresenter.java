package com.adel.stcpay.presenters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.adel.stcpay.MyApplication;
import com.adel.stcpay.activities.MainActivity;
import com.adel.stcpay.activities.SenateDetailsActivity;
import com.adel.stcpay.adapters.SenatesListAdapter;
import com.adel.stcpay.domain.Senate;
import com.adel.stcpay.repository.JSONRepository;
import com.adel.stcpay.repository.SenateRepository;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SenatePresenter {

    private MainActivity mainActivity;
    private SenateRepository repository;
    private ArrayList<Senate> senates;

    public SenatePresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.repository = new JSONRepository();
        senates  = new ArrayList<>(repository.getAllSenates());
    }

    public void loadAllSenates(){

        SenatesListAdapter adapter = new SenatesListAdapter(senates, MyApplication.getAppContext());
        this.mainActivity.senatesListView.setAdapter(adapter);
    }

    public void showSenateDetails(int listItemId){
        // get the context
        Context context = MyApplication.getAppContext();
        // get the selected item
        Senate selected = senates.get(listItemId);

        // serialize
        Gson gson = new Gson();
        String jsonString = gson.toJson(selected);

        // push to the new page
        Intent intent = new Intent(MyApplication.getAppContext(), SenateDetailsActivity.class);
        intent.putExtra("senateInformation", jsonString);
        context.startActivity(intent);
    }

}
