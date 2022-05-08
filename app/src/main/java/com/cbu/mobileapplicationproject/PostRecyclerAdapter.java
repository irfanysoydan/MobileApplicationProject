package com.cbu.mobileapplicationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.MyViewHolder> {

    private ArrayList<Post> posts;

    public PostRecyclerAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_single_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvName.setText(posts.get(position).getName());
        holder.tvDate.setText(posts.get(position).getDate());
        holder.tvTitle.setText(posts.get(position).getTitle());
        holder.imgLogo.setImageResource(posts.get(position).getLogo());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void filterList(ArrayList<Post> filteredList){
        posts = filteredList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvDate,tvTitle;
        ImageView imgLogo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.profile_icon);
            tvName = itemView.findViewById(R.id.username);
            tvDate = itemView.findViewById(R.id.date_info);
            tvTitle = itemView.findViewById(R.id.post_title);

        }
    }
}
