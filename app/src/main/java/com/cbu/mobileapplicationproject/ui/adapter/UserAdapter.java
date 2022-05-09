package com.cbu.mobileapplicationproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.entities.concrete.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private ArrayList<User> dataList;

    public UserAdapter(ArrayList<User> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.txtUserName.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
       return dataList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtUserName;

        UserViewHolder(View itemView) {
            super(itemView);
            txtUserName =  itemView.findViewById(R.id.txt_user_name);
        }
    }
}
