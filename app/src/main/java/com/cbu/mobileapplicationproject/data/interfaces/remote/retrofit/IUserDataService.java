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
    @Headers({
            "app-id: 627302e21afb663b1f7ca379"
    })
    @GET("user?page=1&limit=10")
    Call<User> getAllData();

    @GET("user/{id}")
    Call<User> getOneData(@Path("id") int id);

    @POST("user")
    Call<User> create(@Body User data);

    @PUT("user")
    Call<User> update(
            @Part("name") RequestBody name,
            @Part("surname") RequestBody surname,
            @Part("is_verified") RequestBody is_verified,
            @Part("auth_level") RequestBody authLevel);

    @DELETE("user/{id}")
    Call<User> delete(@Path("id") int id);
}
