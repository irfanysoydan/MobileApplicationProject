package model;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.QuestionRepository;
import com.cbu.mobileapplicationproject.entities.concrete.Question;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private QuestionRepository questionRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.questionRepository = new QuestionRepository(application);
    }
    public LiveData<List<Question>> getAllQuestion() {
        return questionRepository.getAllQuesitonMutableLiveData();
    }
}
