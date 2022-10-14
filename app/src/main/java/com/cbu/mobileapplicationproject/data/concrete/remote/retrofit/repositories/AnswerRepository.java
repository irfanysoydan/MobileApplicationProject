package com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IAnswerDataService;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerRepository {
    private ArrayList<Answer> answers = new ArrayList<>();
    private MutableLiveData<List<Answer>> mutableAnswersLiveData = new MutableLiveData<>();
    private MutableLiveData<Answer> mutableAnswerLiveData = new MutableLiveData<>();
    private Application application;
    public AnswerRepository(Application application) {
        this.application = application;
    }
    IAnswerDataService answerDataService;


    public MutableLiveData<List<Answer>> getAllAnswerMutableLiveData(int id) {
        answerDataService = RetrofitInstance.getRetrofitInstance().create(IAnswerDataService.class);
        Call<List<Answer>> call = answerDataService.getAllByQuestionId(id);
        call.enqueue(new Callback<List<Answer>>() {
            @Override
            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                List<Answer> answers = response.body();
                if (answers != null) {
                    mutableAnswersLiveData.setValue(answers);
                }
            }
            @Override
            public void onFailure(Call<List<Answer>> call, Throwable t) {
                Log.e("Answer Hata"," - > Error    "+ t.getMessage());
            }
        });
        return mutableAnswersLiveData;
    }

    public MutableLiveData<Answer> createAnswerMutableLiveData(Answer answer) {
        answerDataService = RetrofitInstance.getRetrofitInstance().create(IAnswerDataService.class);
        Call<Answer> call = answerDataService.create(answer);
        call.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                Answer answer = response.body();
                if (answer != null) {
                    mutableAnswerLiveData.setValue(answer);
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                Log.e("Answer Hata"," - > Error    "+ t.getMessage());
            }
        });
        return mutableAnswerLiveData;
    }


}
