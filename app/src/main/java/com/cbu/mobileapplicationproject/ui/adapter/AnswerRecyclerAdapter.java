package com.cbu.mobileapplicationproject.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;
import com.cbu.mobileapplicationproject.entities.concrete.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerRecyclerAdapter extends RecyclerView.Adapter<AnswerRecyclerAdapter.BaseViewHolder>  {
    private List<Answer> answers;
    private ItemClickListener onClickListener;
    private Context context;
    private SharedPreferences sp;

    public AnswerRecyclerAdapter(List<Answer> answers, ItemClickListener onClickListener,Context context){
        this.answers = answers;
        this.onClickListener = onClickListener;
        this.context = context;
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.comment,parent, false);
        return new MyViewHolder(view,onClickListener,context);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        return answers.size();
    }

    public class MyViewHolder extends BaseViewHolder implements View.OnClickListener  {
        Context context;
        TextView tvName,tvText;
        ImageView imgLogo;
        private ItemClickListener clickListener;

        public MyViewHolder(@NonNull View itemView, ItemClickListener clickListener,Context context) {
            super(itemView);
            this.clickListener = clickListener;
            imgLogo = itemView.findViewById(R.id.comment_icon);
            tvName = itemView.findViewById(R.id.comment_user);
            tvText = itemView.findViewById(R.id.commenter_text);
            this.context =context;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
        protected void clear(){
            tvName.setText("");
            tvText.setText("");
        }

        @SuppressLint("ResourceType")
        public void onBind(int position) {
            super.onBind(position);
            final Answer answer = answers.get(position);
            if (answer.getContent().getText() != null) {
                tvText.setText(answer.getContent().getText());
            }
            sp = context.getApplicationContext().getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
            IUserDataService userDataService = RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
            userDataService.getOneData(answer.getUserId()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    tvName.setText(response.body().getName());
                    imgLogo.setImageResource(R.drawable.profile_icon);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });

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
