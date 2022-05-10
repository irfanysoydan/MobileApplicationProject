package model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.AnswerRepository;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.QuestionRepository;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;
import com.cbu.mobileapplicationproject.entities.concrete.Question;

import java.util.List;

public class QuestionDetailViewModel extends AndroidViewModel {
    private AnswerRepository answerRepository;

    public QuestionDetailViewModel(@NonNull Application application) {
        super(application);
        this.answerRepository = new AnswerRepository(application);
    }

    public LiveData<List<Answer>> GetAllByQuestionId(int id) {
        return answerRepository.getAllAnswerMutableLiveData(id);
    }

    public LiveData<Answer> CreateAnswer(Answer answer){
        return answerRepository.createAnswerMutableLiveData(answer);
    }
}
