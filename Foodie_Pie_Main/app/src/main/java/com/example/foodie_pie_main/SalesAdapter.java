package com.example.foodie_pie_main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class SalesAdapter extends RecyclerView.Adapter<ViewHolder>{
    static  ArrayList<SalesInfo> mySalesList = null;

    SalesAdapter(ArrayList<SalesInfo> salesList){
        this.mySalesList = salesList;

    }
    SalesAdapter(){


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sales_info_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        String data =mySalesList.get(position).getFoodImageID();
        String base64Image = data.split(",")[1];
        byte[] imageBytes =  Base64.decode(base64Image,0);
        Bitmap mp = BitmapFactory.decodeByteArray( imageBytes,0, imageBytes.length);

        viewHolder.foodImage.setImageBitmap(mp);
        viewHolder.title.setText(mySalesList.get(position).getTitle());
        viewHolder.type.setText(mySalesList.get(position).getType());
        viewHolder.address.setText(mySalesList.get(position).getAddress());

    }

    private Bitmap getBitmapFromString(String stringPicture) {
        byte[] decodedString = Base64.decode(stringPicture, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    @Override
    public int getItemCount(){
        return mySalesList.size();
    }

    public void setItems(ArrayList<SalesInfo> salesList){
        this.mySalesList = salesList;
        notifyDataSetChanged();
    }


}
