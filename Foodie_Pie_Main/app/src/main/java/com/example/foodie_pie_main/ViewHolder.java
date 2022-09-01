package com.example.foodie_pie_main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView foodImage;
    TextView title;
    TextView type;
    TextView address;
    private Context context;
    ViewHolder(View itemView){
        super(itemView);

        foodImage = itemView.findViewById(R.id.foodImage);
        title = itemView.findViewById(R.id.title);
        type = itemView.findViewById(R.id.type);
        address = itemView.findViewById(R.id.address);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                context = view.getContext();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                Fragment fragment = fragmentManager.getFragments().get(0);
                final int pos = getAbsoluteAdapterPosition(); //클릭시 해당 데이터 position 반환
                final MainFragmentDirections.ActionMainFragmentToPostFragment action =
                        MainFragmentDirections.actionMainFragmentToPostFragment(pos);
                NavHostFragment.findNavController(fragment)
                        .navigate(action);

            }
        });

    }



}
