package com.example.android.itour.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.itour.ContainerOpenActivity;
import com.example.android.itour.R;
import com.example.android.itour.Tour;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Tour> mData;

    public HorizontalRecyclerViewAdapter(Context mContext, List<Tour> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public HorizontalRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.horizontal_cardview_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.horizontal_text_title.setText(mData.get(position).getTitle());
        holder.horizontal_image_thumbnail.setImageResource(mData.get(position).getImageview());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ContainerOpenActivity.class);
                intent.putExtra(mContext.getString(R.string.title), mData.get(position).getTitle());
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

        @BindView(R.id.horizontal_title_id) TextView horizontal_text_title;
        @BindView(R.id.horizontal_imageview_id) ImageView horizontal_image_thumbnail;
        @BindView(R.id.horizontal_cardview_id)
        CardView cardView;

        private MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
