package com.adel.stcpay.repository;
import com.adel.stcpay.domain.PersonalDetails;
import com.adel.stcpay.domain.Senate;
import com.adel.stcpay.domain.Senates;
import com.adel.stcpay.utils.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class JSONRepository implements SenateRepository {

    private List<Senate> senates = new ArrayList<Senate>();
    private String text = "";
    public JSONRepository(){
        FileReader fr = new FileReader();
        text = fr.readJSONFromAsset();
        try {
            t(text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void t(String t) throws JSONException {

        Gson gson = new GsonBuilder().create();
        Senates senates = gson.fromJson(t, Senates.class);
        this.senates = senates.getList();
    }

    @Override
    public List<Senate> getAllSenates() {
        sort(senates, new Comparator<Senate>() {
            @Override
            public int compare(Senate s1, Senate s2){
                int res = s1.getPersonalDetails().getLastname().compareToIgnoreCase(s2.getPersonalDetails().getLastname());
                if(res != 0){
                    return res;
                }
                return s1.getPersonalDetails().getFirstname().compareToIgnoreCase(s2.getPersonalDetails().getFirstname());

            }
        });
        return senates;
    }


}
