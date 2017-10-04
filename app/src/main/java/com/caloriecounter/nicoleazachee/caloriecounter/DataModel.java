package com.caloriecounter.nicoleazachee.caloriecounter;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by c_naazachee on 8/29/2017.
 */

public class DataModel {

    public static final String TAG =  DataModel.class.getSimpleName();
    public String title;
    public String description;
    public String imageUrl;
    public String instructionUrl;
    public String label;

    public static ArrayList<DataModel> getDataFromFile(String filename, Context context){
        final ArrayList<DataModel> dataList = new ArrayList<>();

        try{
            String jsonString = loadJSONFromAsset("recipes.json",context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray dataArray = json.getJSONArray("recipes");

            for(int i = 0; i <dataArray.length(); i++){
                DataModel data = new DataModel();
                data.title = dataArray.getJSONObject(i).getString("title");
                data.description = dataArray.getJSONObject(i).getString("description");
                data.imageUrl = dataArray.getJSONObject(i).getString("imageUrl");
                data.label = dataArray.getJSONObject(i).getString("label");
                data.instructionUrl = dataArray.getJSONObject(i).getString("instructionUrl");

                dataList.add(data);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return dataList;
    }

    private static String loadJSONFromAsset(String filename, Context context){
        String json = null;

        try{
            InputStream inputStream = context.getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        }catch (java.io.IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
