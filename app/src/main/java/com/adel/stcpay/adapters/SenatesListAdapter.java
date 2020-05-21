package com.adel.stcpay.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.adel.stcpay.R;
import com.adel.stcpay.domain.Senate;

import java.util.ArrayList;
import java.util.HashMap;


public class SenatesListAdapter implements ListAdapter {

    ArrayList<Senate> senates;
    Context context;

    public SenatesListAdapter(ArrayList<Senate> senates, Context context) {
        this.senates = senates;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return senates.size();
    }

    @Override
    public Object getItem(int i) {
        return senates.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Senate s = senates.get(i);

        HashMap<String, Integer> imageForParty = new HashMap<>();

        imageForParty.put("Democrat", R.drawable.democrat_logo);
        imageForParty.put("Republican", R.drawable.republican_logo);


        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.senates_list_row, null);

            TextView senateNameTV = view.findViewById(R.id.senate_name);
            TextView senatePartyTV = view.findViewById(R.id.senate_party);
            TextView senateDescriptionTV = view.findViewById(R.id.senate_description);

            String fullname = String.format("%s, %s", s.getPersonalDetails().getLastname(), s.getPersonalDetails().getFirstname());
            senateNameTV.setText(fullname);

            senatePartyTV.setText(s.getParty());
            senateDescriptionTV.setText(s.getDescription());

            ImageView imageView = view.findViewById(R.id.icon1);
            imageView.setImageResource(imageForParty.get(s.getParty()));
        }
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
