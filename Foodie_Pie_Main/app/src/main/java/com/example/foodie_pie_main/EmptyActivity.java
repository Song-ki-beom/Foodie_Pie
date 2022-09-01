package com.example.foodie_pie_main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class EmptyActivity extends AppCompatActivity {
    ImageButton userinfoSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        userinfoSetting = (ImageButton)findViewById(R.id.userInfoSetting);

        userinfoSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               userinfo_selfFragment userinfo_selfFragment1 = new userinfo_selfFragment();
               transaction.replace(R.id.emptyframeLayout, userinfo_selfFragment1);
               transaction.addToBackStack(null);
               transaction.commit();
            }
        });

        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.d("tag", "key="+key);
            }
        });
    }
}