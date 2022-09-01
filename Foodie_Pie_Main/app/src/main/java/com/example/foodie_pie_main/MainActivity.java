package com.example.foodie_pie_main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.foodie_pie_main.databinding.ContentMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    Toolbar toolbarr;
    TextView logoText;
    Button warpButton;
    Context context;
    TextView Start;
    PopupWindow mypopupWindow;
    EditText searchEdit;
    SalesAdapter salesAdapter;
    ArrayList<SalesInfo> SearchSalesList;
    ArrayList<SalesInfo> OriginalSalesList;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context=this.getBaseContext();
        OriginalSalesList = SalesAdapter.mySalesList;
        SearchSalesList = new ArrayList<SalesInfo>();
        salesAdapter = new SalesAdapter();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        toolbarr = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        logoText = (TextView) findViewById(R.id.foodiePie_Logo);
        logoText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    context = view.getContext();
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    Fragment fragment = fragmentManager.getFragments().get(0);
                    NavHostFragment.findNavController(fragment)
                            .navigate(R.id.MainFragment);
                }
                return false;
            }
        });
        warpButton = (Button) findViewById(R.id.warp_menu);
        /*
       warpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                getMenuInflater().inflate(R.menu.warp_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        context = view.getContext();
                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                        Fragment fragment = fragmentManager.getFragments().get(0);
                        if (menuItem.getItemId() == R.id.list_text){


                        }

                        if (menuItem.getItemId() == R.id.main_window){
                            NavHostFragment.findNavController(fragment)
                                    .navigate(R.id.MainFragment);
                        }else if (menuItem.getItemId() == R.id.category){
                            Toast.makeText(MainActivity.this, "메뉴 2 클릭", Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }
                });
                popupMenu.show();
            }
        });
       */

        mypopupWindow =setPopUpWindow();
        mypopupWindow.setFocusable(true);
        warpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mypopupWindow.showAsDropDown(v, -150, 0);

            }

        });


        mypopupWindow.getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {


                TextView far = (TextView) v1.findViewById(R.id.main_window);
                far.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v2) {
                    context = MainActivity.this;
                        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                        Fragment fragment = fragmentManager.getFragments().get(0);
                        NavHostFragment.findNavController(fragment)
                                .navigate(R.id.MainFragment);
                       mypopupWindow.dismiss();
                    }
                });


            }
        });


        searchEdit = findViewById(R.id.searchEdit);
        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = searchEdit.getText().toString();
                SearchSalesList.clear();

                if (searchText.equals("")) {
                    salesAdapter.setItems(OriginalSalesList);
                } else {
                    for (int a = 0; a < OriginalSalesList.size(); a++) {
                        if (OriginalSalesList.get(a).getTitle().toLowerCase().contains(searchText.toLowerCase())) {
                            SearchSalesList.add(OriginalSalesList.get(a));
                            salesAdapter.setItems(SearchSalesList);
                        }


                    }
                }
            }
        });


    }



    private PopupWindow setPopUpWindow() {
        LayoutInflater inflater = (LayoutInflater)
                getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view = inflater.inflate(R.layout.popup_window, null);


        PopupWindow mypopupWindow;
        mypopupWindow = new PopupWindow(view,RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        return mypopupWindow;

    }






    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        //MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.warp_menu, menu);
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
