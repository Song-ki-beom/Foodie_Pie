package com.example.foodie_pie_main;

import android.app.Dialog;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<SalesInfo> SalesList;
    AssetManager assetManager;

    TextView title_text;
    TextView name_text;
    TextView detail_text;
    TextView buyDate_text;
    TextView dueDate_text;
    ImageButton food_image;

   public static final String TAG_EVENT_DIALOG ="dialog_event";



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PostFragment newInstance(String param1, String param2) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_post, container, false);

        view.findViewById(R.id.FoodImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        return view;
    }


            @Override
            public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            int position = PostFragmentArgs.fromBundle(getArguments()).getPositionNum();
            title_text = view.findViewById(R.id.TitlleText);
            name_text = view.findViewById(R.id.Name);
            detail_text = view.findViewById(R.id.DetailInfo);
            buyDate_text = view.findViewById(R.id.BuyDate);
            dueDate_text= view.findViewById(R.id.DueDate);
            food_image = view.findViewById(R.id.FoodImageButton);

            SalesList = new ArrayList<SalesInfo>();
            assetManager = getResources().getAssets();
            String json = getJsonString();
            jsonParSing(json, position);


            view.findViewById(R.id.goToChat).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(PostFragment.this)
                            .navigate(R.id.action_postFragment_to_ChatFragment);
                }
            });

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

        //int position = PostFragmentArgs.fromBundle(getArguments()).getPositionNum();
        private void jsonParSing(String json, int position) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                String sales = jsonObject.getString("Sales");
                JSONArray jsonArray = new JSONArray(sales);

                JSONObject subJsonObject = jsonArray.getJSONObject(position);
                String title = subJsonObject.getString("Title");
                String name = subJsonObject.getString("Name");
                String detail_info = subJsonObject.getString("Detail_Info");
                String buy_date = subJsonObject.getString("Buy_Date");
                String due_date = subJsonObject.getString("Due_Date");

                //string to bitmap
                String data  = subJsonObject.getString("FoodImage");
                String base64Image = data.split(",")[1];
                byte[] imageBytes =  Base64.decode(base64Image,0);
                Bitmap mp = BitmapFactory.decodeByteArray( imageBytes,0, imageBytes.length);

                title_text.setText(title);
                name_text.setText(name);
                detail_text.setText(detail_info);
                buyDate_text.setText(buy_date);
                dueDate_text.setText(due_date);
                food_image.setImageBitmap(mp);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void openDialog() {
            FoodImage_Dialog foodImageDialog = new FoodImage_Dialog();
            foodImageDialog.show(getActivity().getSupportFragmentManager(), "FOOD");

        }

        }

