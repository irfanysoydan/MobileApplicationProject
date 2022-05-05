package com.cbu.mobileapplicationproject.domain.interfaces.data;

import com.cbu.mobileapplicationproject.entities.interfaces.IEntityBase;
import com.cbu.mobileapplicationproject.ui.list.UserList;

import java.util.List;

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

public interface IGenericDataService {
    @Headers({
            "app-id: 627302e21afb663b1f7ca379"
    })
    @GET("user?page=1&limit=10")
    Call<UserList> getAllData();

    @GET("user/{id}")
    Call<UserList> getOneData(@Path("id") int id);

    @POST("user")
    Call<UserList> create(@Body UserList data);

    @PUT("user")
    Call<UserList> update(
            @Part("name") RequestBody name,
            @Part("surname") RequestBody surname,
            @Part("is_verified") RequestBody is_verified,
            @Part("auth_level") RequestBody authLevel);

    @DELETE("user/{id}")
    Call<UserList> delete(@Path("id") int id);
}
