package com.adel.stcpay.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import android.util.Log;

import com.adel.stcpay.MyApplication;

public class FileReader {

    public  String readJSONFromAsset() {
        Log.d("FileReader", "Trying to read the file");

        Context context = MyApplication.getAppContext();
        String json = "";
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.d("FileReader", "Error while reading the file");
            ex.printStackTrace();
            return null;
        }
        Log.d("FileReader", "file size is " + json.length());
        return json;
    }
}
