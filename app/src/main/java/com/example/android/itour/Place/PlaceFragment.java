package com.example.android.itour.Place;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.itour.Adapter.HorizontalRecyclerViewAdapter;
import com.example.android.itour.Adapter.RecyclerviewAdapter;
import com.example.android.itour.R;
import com.example.android.itour.Tour;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {

    //Calling ID's with @BindView for ButterKnife
    @BindView(R.id.recyclerview_id)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerview_id2)
    RecyclerView recyclerView2;

    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place, container, false);

        ButterKnife.bind(this, view);

        //ArrayAdapter for the Vertical GridView RecyclerView
        List<Tour> travel = new ArrayList<>();
        travel.add(new Tour(getString(R.string.beauty_place), R.drawable.travel));
        travel.add(new Tour(getString(R.string.place_lovely), R.drawable.travel));
        travel.add(new Tour(getString(R.string.pretty_place), R.drawable.travel));
        travel.add(new Tour(getString(R.string.amazing_place), R.drawable.travel));
        travel.add(new Tour(getString(R.string.gorgeous_place), R.drawable.travel));
        travel.add(new Tour(getString(R.string.awesome_place), R.drawable.travel));
        travel.add(new Tour(getString(R.string.garden_view), R.drawable.travel));
        travel.add(new Tour(getString(R.string.true_beauty), R.drawable.travel));
        travel.add(new Tour(getString(R.string.blossom_view), R.drawable.travel));
        travel.add(new Tour(getString(R.string.love_garden), R.drawable.travel));

        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(getActivity(), travel);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(recyclerviewAdapter);

        //ArrayAdapter for the Horizontal RecyclerView
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(getActivity(), travel);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(horizontalRecyclerViewAdapter);

        return view;
    }

}
