package com.example.android.itour.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.itour.ContainerOpenActivity;
import com.example.android.itour.R;
import com.example.android.itour.TopPlacesOpenActivity;
import com.example.android.itour.Tour;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Tour> mData;

    public CommentRecyclerViewAdapter(Context mContext, List<Tour> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.comment_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.commenter_name.setText(mData.get(position).getTitle());
        holder.comments.setText(mData.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.commenter_name_id)
        TextView commenter_name;
        @BindView(R.id.comments_id)
        TextView comments;
        @BindView(R.id.comment_cardview_id)
        CardView comment_cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
