package com.cbu.mobileapplicationproject;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolderC> {
    private ArrayList<Comment> comments;

    public CommentRecyclerAdapter(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public MyViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment,parent,false);
        return new MyViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderC holder, int position) {
        holder.imgIcon.setImageResource(comments.get(position).getIcon());
        holder.tvUser.setText(comments.get(position).getUser());
        holder.tvText.setText(comments.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class MyViewHolderC extends RecyclerView.ViewHolder{
        TextView tvUser,tvText;
        ImageView imgIcon;
        public MyViewHolderC(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.comment_icon);
            tvUser = itemView.findViewById(R.id.comment_user);
            tvText = itemView.findViewById(R.id.commenter_text);
        }
    }
}
