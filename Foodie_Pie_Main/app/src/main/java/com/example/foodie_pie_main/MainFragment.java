package com.example.foodie_pie_main;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.foodie_pie_main.databinding.FragmentFirstBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    private FragmentFirstBinding binding;

    ArrayList<SalesInfo> SalesList;
    AssetManager assetManager;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SalesList = new ArrayList<SalesInfo>();
        assetManager = getResources().getAssets();
        String json =getJsonString();
        jsonParSing(json);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public String getJsonString() {
        String json = "";
        try {
            InputStream is = assetManager.open("Sales.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
          //  JSONObject jsonObject = new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private void jsonParSing(String json){
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray SalesArray = jsonObject.getJSONArray("Sales");
            for (int i=0;i<SalesArray.length();i++){

                JSONObject salesObject = SalesArray.getJSONObject(i);
                SalesInfo salesInfo = new SalesInfo();
                salesInfo.setTitle(salesObject.getString("Title"));
                salesInfo.setType(salesObject.getString("Type"));
                salesInfo.setAddress(salesObject.getString("Address"));

                SalesList.add(salesInfo);
            }
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }



}

