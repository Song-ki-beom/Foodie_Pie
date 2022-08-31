package com.example.foodie_pie_main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.foodie_pie_main.databinding.ContentMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.foodie_pie_main.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    Toolbar toolbarr;
    TextView logoText;
    Context context;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        toolbarr =  (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_menu_myplaces);
        logoText = (TextView) findViewById(R.id.foodiePie_Logo);
        logoText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    context = view.getContext();
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    Fragment fragment = fragmentManager.getFragments().get(0);
                    NavHostFragment.findNavController(fragment)
                            .navigate(R.id.MainFragment);
                }
                return false;
            }
        });




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.warp_menu, menu);
        return true;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        return super.onOptionsItemSelected(item);
    }






}
