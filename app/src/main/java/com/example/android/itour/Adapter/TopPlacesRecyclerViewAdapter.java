package com.example.android.itour.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.itour.R;
import com.example.android.itour.TopPlacesActivity;
import com.example.android.itour.TopPlacesOpenActivity;
import com.example.android.itour.Tour;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopPlacesRecyclerViewAdapter extends RecyclerView.Adapter<TopPlacesRecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Tour> mData;

    public TopPlacesRecyclerViewAdapter(Context mContext, List<Tour> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.top_places_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.place_text.setText(mData.get(position).getTitle());
        holder.country_text.setText(mData.get(position).getCountry());
        holder.top_place_image.setImageResource(mData.get(position).getImageview());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TopPlacesOpenActivity.class);
                intent.putExtra(mContext.getString(R.string.places), mData.get(position).getTitle());
                intent.putExtra(mContext.getString(R.string.country), mData.get(position).getCountry());
                intent.putExtra(mContext.getString(R.string.imageview), mData.get(position).getImageview());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.place_text)
        TextView place_text;
        @BindView(R.id.country_text)
        TextView country_text;
        @BindView(R.id.top_place_image)
        ImageView top_place_image;
        @BindView(R.id.top_places_id)
        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
