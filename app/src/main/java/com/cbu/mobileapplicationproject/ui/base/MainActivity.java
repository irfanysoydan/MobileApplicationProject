package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.domain.interfaces.data.IGenericDataService;
import com.cbu.mobileapplicationproject.databinding.ActivityLoginBinding;
import com.cbu.mobileapplicationproject.databinding.ActivityMainBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.adapter.UserAdapter;
import com.cbu.mobileapplicationproject.ui.list.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private UserAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());


        /** Create handle for the RetrofitInstance interface*/
        IGenericDataService service = RetrofitInstance.getRetrofitInstance().create(IGenericDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<UserList> call = service.getAllData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                generateUserList(response.body().getUserArrayList());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    /** Method to generate List of notice using RecyclerView with custom adapter*/
    private void generateUserList(ArrayList<User> noticeArrayList) {
        recyclerView = findViewById(R.id.recycler_view_notice_list);
        adapter = new UserAdapter(noticeArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}