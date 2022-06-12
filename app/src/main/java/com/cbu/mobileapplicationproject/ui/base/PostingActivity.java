package com.cbu.mobileapplicationproject.ui.base;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cbu.mobileapplicationproject.databinding.ActivityPostingBinding;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;
import com.cbu.mobileapplicationproject.entities.concrete.Content;
import com.cbu.mobileapplicationproject.entities.concrete.Question;
import com.cbu.mobileapplicationproject.entities.concrete.Tag;

import java.util.List;

import model.MainViewModel;
import model.QuestionViewModel;

public class PostingActivity extends AppCompatActivity {

    private QuestionViewModel questionViewModel;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPostingBinding viewBinding = ActivityPostingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        viewBinding.postBtnQuestionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Content content = new Content();
                content.setText(viewBinding.postTvQuestionContent.getText().toString());
                sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
                Question question = new Question(viewBinding.questionTvTitle.getText().toString(),
                        content, null, 0, 0, null, sp.getInt("id",0), null);

                questionViewModel.createQuestion(question).observe(PostingActivity.this, new Observer<Question>() {
                    @Override
                    public void onChanged(@Nullable Question question) {
                        finish();
                    }
                });
            }
        });
    }
}