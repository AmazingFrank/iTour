package com.example.android.itour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.itour.Adapter.TopPlacesRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopPlacesActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_id)
    Toolbar toolbar;
    @BindView(R.id.top_places_recyclerView)
    RecyclerView top_places_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_places);
        ButterKnife.bind(this);

        //Setting Up Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Tour> top_places = new ArrayList<>();
        top_places.add(new Tour("IStanbul", "Turkey", R.drawable.travel));
        top_places.add(new Tour("Rome", "Italy", R.drawable.travel));
        top_places.add(new Tour("New York", "USA", R.drawable.travel));
        top_places.add(new Tour("Abuja", "Nigeria", R.drawable.travel));
        top_places.add(new Tour("IStanbul", "Turkey", R.drawable.travel));
        top_places.add(new Tour("Rome", "Italy", R.drawable.travel));
        top_places.add(new Tour("New York", "USA", R.drawable.travel));
        top_places.add(new Tour("Abuja", "Nigeria", R.drawable.travel));
        top_places.add(new Tour("IStanbul", "Turkey", R.drawable.travel));
        top_places.add(new Tour("Rome", "Italy", R.drawable.travel));
        top_places.add(new Tour("New York", "USA", R.drawable.travel));
        top_places.add(new Tour("Abuja", "Nigeria", R.drawable.travel));
        top_places.add(new Tour("IStanbul", "Turkey", R.drawable.travel));
        top_places.add(new Tour("Rome", "Italy", R.drawable.travel));
        top_places.add(new Tour("New York", "USA", R.drawable.travel));
        top_places.add(new Tour("Abuja", "Nigeria", R.drawable.travel));

        TopPlacesRecyclerViewAdapter topPlacesRecyclerViewAdapter = new TopPlacesRecyclerViewAdapter(this, top_places);
        top_places_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        top_places_recyclerview.setAdapter(topPlacesRecyclerViewAdapter);

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
