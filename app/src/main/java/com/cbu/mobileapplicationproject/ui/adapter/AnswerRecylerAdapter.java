package com.cbu.mobileapplicationproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.Comment;
import com.cbu.mobileapplicationproject.CommentRecyclerAdapter;
import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;

import java.util.ArrayList;

public class AnswerRecylerAdapter extends RecyclerView.Adapter<AnswerRecylerAdapter.MyViewHolderC> {
    private ArrayList<Answer> answers;

    public AnswerRecylerAdapter(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @NonNull
    @Override
    public MyViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment,parent,false);
        return new AnswerRecylerAdapter.MyViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderC holder, int position) {
        holder.tvUser.setText(answers.get(position).getUser().getName());
        holder.tvText.setText(answers.get(position).getContent().getText());
       // holder.imgIcon.setImageResource(answers.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return answers.size();
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
