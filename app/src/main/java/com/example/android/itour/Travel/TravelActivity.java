package com.example.android.itour.Travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.itour.R;

import butterknife.ButterKnife;

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        //Added Support For ButterKnife
        ButterKnife.bind(this);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new TravelFragment())
                .commit();
    }
}
