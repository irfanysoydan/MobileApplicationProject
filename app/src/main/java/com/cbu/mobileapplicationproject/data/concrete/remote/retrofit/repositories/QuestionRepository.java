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
    private MutableLiveData<List<Question>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public QuestionRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Question>> getAllQuesitonMutableLiveData() {
        IQuestionDataService userDataService = RetrofitInstance.getRetrofitInstance().create(IQuestionDataService.class);
        Call<List<Question>> call = userDataService.getAllData();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                List<Question> questions = response.body();

                if (questions != null) {
                    mutableLiveData.setValue(questions);
                }
            }
            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.e("Question Hata"," - > Error    "+ t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
