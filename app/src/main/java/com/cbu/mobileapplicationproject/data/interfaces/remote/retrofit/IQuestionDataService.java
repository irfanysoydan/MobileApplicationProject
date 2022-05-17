package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Question;
import com.cbu.mobileapplicationproject.entities.concrete.User;

import java.util.List;

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
    @GET("Questions")
    Call<List<Question>> getAllData();

    @GET("Questions/QuestionCount")
    Call<Object> getQuestionCount();

    @GET("Questions/{id}")
    Call<Question> getOneData(@Path("id") int id);

    @POST("Questions")
    Call<Question> create(@Body Question data);

    @PUT("Questions/{id}")
    Call<Question> update(
            @Path("id") int id,
            @Part("title") RequestBody title,
            @Part("content") RequestBody content,
            @Part("tags") RequestBody tags,
            @Part("view_count") RequestBody view_count,
            @Part("rate") RequestBody rate,
            @Part("answers") RequestBody answers);

    @DELETE("Questions/{id}")
    Call<Question> delete(@Path("id") int id);
}
