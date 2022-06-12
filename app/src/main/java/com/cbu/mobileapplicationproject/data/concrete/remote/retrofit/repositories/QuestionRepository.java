package com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IQuestionDataService;
import com.cbu.mobileapplicationproject.entities.concrete.Question;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {
    private ArrayList<Question> questions = new ArrayList<>();
    private MutableLiveData<List<Question>> mutableQuestionsLiveData = new MutableLiveData<>();
    private MutableLiveData<Question> mutableQuestionLiveData = new MutableLiveData<>();
    private MutableLiveData<Object> mutableQuestionCountLiveData = new MutableLiveData<>();
    private Application application;

    public QuestionRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Question>> getAllQuesitonMutableLiveData() {
        IQuestionDataService questionDataService = RetrofitInstance.getRetrofitInstance().create(IQuestionDataService.class);
        Call<List<Question>> call = questionDataService.getAllData();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                List<Question> questions = response.body();
                if (questions != null) {
                    mutableQuestionsLiveData.setValue(questions);
                }
            }
            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.e("Question Hata"," - > Error    "+ t.getMessage());
            }
        });
        return mutableQuestionsLiveData;
    }

    public MutableLiveData<Object> getQuestionCount(){
        IQuestionDataService questionDataService = RetrofitInstance.getRetrofitInstance().create(IQuestionDataService.class);
        Call<Object> call = questionDataService.getQuestionCount();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                mutableQuestionCountLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
        return mutableQuestionCountLiveData;
    }

    public MutableLiveData<Question> createQuestionMutableLiveData(Question question){
        IQuestionDataService questionDataService = RetrofitInstance.getRetrofitInstance().create(IQuestionDataService.class);
        Call<Question> call = questionDataService.create(question);
        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Question question = response.body();
                Log.e("Response", response.body().toString());
                if (question != null) {
                    mutableQuestionLiveData.setValue(question);
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e("Question Create Hata"," - > Error    "+ t.getMessage());
            }
        });
        return mutableQuestionLiveData;
    }
}
