package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Answer;
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

public interface IAnswerDataService {

    @GET("answer")
    Call<Answer> getAllData();

    @GET("answer/{id}")
    Call<Answer> getOneData(@Path("id") int id);

    @POST("answer")
    Call<Answer> create(@Body Answer data);

    @PUT("answer")
    Call<User> update(
            @Part("content") RequestBody content,
            @Part("question_id") RequestBody question_id,
            @Part("is_verified") RequestBody is_verified);

    @DELETE("answer/{id}")
    Call<Answer> delete(@Path("id") int id);
}
