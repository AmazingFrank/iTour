package com.example.android.itour.Stadium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.itour.R;

public class StadiumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new StadiumFragment())
                .commit();
    }
}
