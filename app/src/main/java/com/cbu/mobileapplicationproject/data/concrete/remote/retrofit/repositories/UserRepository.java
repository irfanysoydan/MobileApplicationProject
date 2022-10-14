package com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private MutableLiveData<User> userLiveData=new MutableLiveData<>();

   /* public MutableLiveData<User> getUser(int Id)
    {
        IUserDataService userDataService = RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
        Call<User> call = userDataService.getOneData(Id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("User reposityory","Cannot get User"+ t.getMessage());
            }
        });

        return userLiveData;
    }*/
}
