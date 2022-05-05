package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Question;
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

public interface IQuestionDataService {
    @GET("question")
    Call<Question> getAllData();

    @GET("question/{id}")
    Call<Question> getOneData(@Path("id") int id);

    @POST("question")
    Call<Question> create(@Body Question data);

    @PUT("question")
    Call<Question> update(
            @Part("title") RequestBody title,
            @Part("content") RequestBody content,
            @Part("tags") RequestBody tags,
            @Part("view_count") RequestBody view_count,
            @Part("rate") RequestBody rate,
            @Part("answers") RequestBody answers);

    @DELETE("question/{id}")
    Call<Question> delete(@Path("id") int id);
}
