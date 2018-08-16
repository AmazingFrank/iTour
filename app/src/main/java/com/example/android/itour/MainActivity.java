package com.example.android.itour;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.itour.Museum.MuseumFragment;
import com.example.android.itour.Place.PlaceFragment;
import com.example.android.itour.Travel.TravelFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //Calling ID's with @BindView for ButterKnife
    @BindView(R.id.toolbar_id)
    Toolbar toolbar;
    @BindView(R.id.viewpager_id)
    ViewPager viewPager;
    @BindView(R.id.tabLayout_id)
    TabLayout tabLayout;

    private int[] tabIcons = { R.drawable.ic_directions_car, R.drawable.ic_store, R.drawable.ic_place};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Added Support for ButterKnife
        ButterKnife.bind(this);

        //Setting Up Toolbar
        setSupportActionBar(toolbar);


        //ViewPager Adapter Setup
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new TravelFragment(), "Travel");
        viewPagerAdapter.addFragment(new MuseumFragment(), "Museum");
        viewPagerAdapter.addFragment(new PlaceFragment(), "Place");
        viewPager.setAdapter(viewPagerAdapter);

        //Adding tablayout and linking it with the ViewPager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

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
            case R.id.settings_id:
                Intent intent = new Intent(this, TopPlacesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
