package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Tag;
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

public interface ITagDataService {
    @GET("tag")
    Call<Tag> getAllData();

    @GET("tag/{id}")
    Call<Tag> getOneData(@Path("id") int id);

    @POST("tag")
    Call<Tag> create(@Body Tag data);

    @PUT("tag")
    Call<Tag> update(@Part("name") RequestBody name);

    @DELETE("Tag/{id}")
    Call<Tag> delete(@Path("id") int id);
}
