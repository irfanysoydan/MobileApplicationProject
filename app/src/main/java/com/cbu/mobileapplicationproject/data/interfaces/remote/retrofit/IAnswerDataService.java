package com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit;

import com.cbu.mobileapplicationproject.entities.concrete.Answer;
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

public interface IAnswerDataService {

    @GET("Answers")
    Call<List<Answer>> getAllData();

    @GET("Answers/GetAllByQuestionId/{id}")
    Call<List<Answer>> getAllByQuestionId(@Path("id") int id);

    @GET("Answers/{id}")
    Call<Answer> getOneData(@Path("id") int id);

    @POST("Answers")
    Call<Answer> create(@Body Answer data);

    @PUT("Answers")
    Call<User> update(
            @Part("content") RequestBody content,
            @Part("question_id") RequestBody question_id,
            @Part("is_verified") RequestBody is_verified);

    @DELETE("Answers/{id}")
    Call<Answer> delete(@Path("id") int id);
}
