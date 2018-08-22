package com.example.android.itour.Place;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.itour.R;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new PlaceFragment())
                .commit();
    }
}
