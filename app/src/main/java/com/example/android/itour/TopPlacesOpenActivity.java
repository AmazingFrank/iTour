package com.example.android.itour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopPlacesOpenActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_id)
    Toolbar toolbar;
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

        //Setting Up Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String Places = intent.getStringExtra("Places");
        String Country = intent.getStringExtra("Country");
        int ImageView = intent.getIntExtra("ImageView", 0);

        place_text.setText(Places);
        country_text.setText(Country);
        top_place_image.setImageResource(ImageView);
    }

    //Inflating the menu to toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Setting up a Click Listener for the Toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
