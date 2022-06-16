package com.cbu.mobileapplicationproject.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityCommentBinding;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;
import com.cbu.mobileapplicationproject.entities.concrete.Content;
import com.cbu.mobileapplicationproject.entities.concrete.Question;
import com.cbu.mobileapplicationproject.ui.adapter.AnswerRecyclerAdapter;
import com.cbu.mobileapplicationproject.ui.adapter.ItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.QuestionDetailViewModel;


public class CommentActivity extends AppCompatActivity implements ItemClickListener {
    private Question question;
    private Answer answer;
    private QuestionDetailViewModel questionDetailViewModel;
    private List<Answer> answers;
    private SharedPreferences sp;

    private RecyclerView recyclerView;
    private AnswerRecyclerAdapter answerRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCommentBinding viewBinding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        Intent i = getIntent();
        question = (Question) i.getSerializableExtra("question");
        recyclerView = findViewById(R.id.recyclerview_comment);
        //fillTheArrayC();

        questionDetailViewModel = new ViewModelProvider(this).get(QuestionDetailViewModel.class);

        viewBinding.answerFrameQuestion.questionTvName.setText(question.getUser().getName());
        viewBinding.answerFrameQuestion.questionTvTitle.setText(question.getTitle());
        String pattern = "MMM d";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(question.getCreationDate());
        viewBinding.answerFrameQuestion.questionTvDate.setText(date);
        viewBinding.answerFrameQuestion.questionTvContent.setText(question.getContent().getText());


        viewBinding.answerFrameQuestion.questionBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewBinding.answerFrameQuestion.questionEtAnswer.getText().toString().matches("")){
                Content content =  new Content();
                content.setText(viewBinding.answerFrameQuestion.questionEtAnswer.getText().toString());
                answer = new Answer();
                answer.setContent(content);
                answer.setQuestionId(question.getId());
                sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
                answer.setUserId(sp.getInt("id",0));
                questionDetailViewModel.CreateAnswer(answer).observe(CommentActivity.this, new Observer<Answer>() {
                    @Override
                    public void onChanged(@Nullable Answer qs) {
                        answer = qs;
                    }
                });
                questionDetailViewModel.GetAllByQuestionId(question.getId()).observe(CommentActivity.this, new Observer<List<Answer>>() {
                    @Override
                    public void onChanged(@Nullable List<Answer> a) {
                        answers = a;
                        setRecyclerView(answers);
                    }
                });
                viewBinding.answerFrameQuestion.questionEtAnswer.setText("");
            }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        question = (Question) i.getSerializableExtra("question");

        questionDetailViewModel.GetAllByQuestionId(question.getId()).observe(this, new Observer<List<Answer>>() {
            @Override
            public void onChanged(@Nullable List<Answer> a) {
                answers = a;
                setRecyclerView(answers);
            }
        });
    }
    private void setRecyclerView(List<Answer> answers) {
        answerRecyclerAdapter = new AnswerRecyclerAdapter(answers,this,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(CommentActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(answerRecyclerAdapter);
        answerRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View view, int position) {

    }
}