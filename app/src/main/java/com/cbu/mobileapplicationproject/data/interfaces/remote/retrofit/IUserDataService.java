package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.domain.interfaces.data.IGenericDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.list.UserList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IUserDataService{

    @GET("User")
    Call<User> getAllData();

    @GET("User/{id}")
    Call<User> getOneData(@Path("id") int id);

    @POST("User")
    Call<User> create(@Body User data);

    @POST("User/login")
    Call<User> login(@Body User data);


    @PUT("User")
    Call<User> update(
            @Part("name") RequestBody name,
            @Part("surname") RequestBody surname,
            @Part("username") RequestBody username,
            @Part("email") RequestBody email,
            @Part("password") RequestBody password,
            @Part("is_verified") RequestBody is_verified,
            @Part("auth_level") RequestBody authLevel,
            @Part("followings") RequestBody followings);

    @DELETE("User/{id}")
    Call<User> delete(@Path("id") int id);
}
