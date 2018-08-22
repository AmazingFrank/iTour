package com.example.android.itour.Museum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.itour.R;

public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        //Using FragmentManager to Replace the Layout to Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MuseumFragment())
                .commit();
    }
}
