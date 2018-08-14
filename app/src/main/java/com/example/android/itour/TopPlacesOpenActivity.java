package com.example.android.itour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopPlacesOpenActivity extends AppCompatActivity {

    @BindView(R.id.place_text)
    TextView place_text;
    @BindView(R.id.country_text)
    TextView country_text;
    @BindView(R.id.top_place_image)
    ImageView top_place_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_places_open);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String Places = intent.getStringExtra("Places");
        String Country = intent.getStringExtra("Country");
        int ImageView = intent.getIntExtra("ImageView", 0);

        place_text.setText(Places);
        country_text.setText(Country);
        top_place_image.setImageResource(ImageView);
    }
}
