package com.example.foodie_pie_main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class FoodImage_Dialog extends DialogFragment implements View.OnClickListener {

    private Fragment fragment;

    public FoodImage_Dialog(){}



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_image_dialog, container);
        fragment = getActivity().getSupportFragmentManager().findFragmentByTag("FOOD");

        return view;
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
