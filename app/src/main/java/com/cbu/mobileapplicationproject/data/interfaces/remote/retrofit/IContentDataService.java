package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Content;
import com.cbu.mobileapplicationproject.entities.concrete.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IContentDataService {
    @GET("content")
    Call<Content> getAllData();

    @GET("content/{id}")
    Call<Content> getOneData(@Path("id") int id);

    @POST("content")
    Call<Content> create(@Body User data);

    @PUT("content")
    Call<Content> update(
            @Part("text") RequestBody text,
            @Part("media_paths") RequestBody media_paths);

    @DELETE("content/{id}")
    Call<Content> delete(@Path("id") int id);
}
