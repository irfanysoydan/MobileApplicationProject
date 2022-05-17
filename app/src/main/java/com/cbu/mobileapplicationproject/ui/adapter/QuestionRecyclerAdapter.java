package com.cbu.mobileapplicationproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.entities.concrete.Question;

import java.text.SimpleDateFormat;
import java.util.List;

public class QuestionRecyclerAdapter extends RecyclerView.Adapter<QuestionRecyclerAdapter.BaseViewHolder>   {

    private List<Question> questions;
    private ItemClickListener onClickListener;

    public QuestionRecyclerAdapter(List<Question> questions, ItemClickListener onClickListener){
        this.questions = questions;
        this.onClickListener = onClickListener;
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
        //holder.imgLogo.setImageResource(questions.get(position).getLogo());
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_single_item,parent, false);
        return new QuestionRecyclerAdapter.MyViewHolder(view,onClickListener);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class MyViewHolder extends BaseViewHolder implements View.OnClickListener  {

        TextView tvName,tvDate,tvTitle;
        ImageView imgLogo;
        private ItemClickListener clickListener;

        public MyViewHolder(@NonNull View itemView, ItemClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
            imgLogo = itemView.findViewById(R.id.profile_icon);
            tvName = itemView.findViewById(R.id.question_tv_name);
            tvDate = itemView.findViewById(R.id.question_tv_date);
            tvTitle = itemView.findViewById(R.id.question_tv_title);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
        protected void clear(){
            tvName.setText("");
            tvDate.setText("");
            tvTitle.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            final Question question = questions.get(position);
            if (question.getTitle() != null) {
                tvTitle.setText(question.getTitle());
            }
            if (question.getCreationDate() != null) {
                String pattern = "MMM d";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(question.getCreationDate());
                tvDate.setText(date);
            }
            if (question.getUser().getName() != null) {
                tvName.setText(question.getUser().getName());
            }
            imgLogo.setImageResource(R.drawable.profile_icon);
        }
    }
    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        private int mCurrentPosition;
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
        protected abstract void clear();
        public void onBind(int position) {
            mCurrentPosition = position;
            clear();
        }
        public int getCurrentPosition() {
            return mCurrentPosition;
        }
    }
}
