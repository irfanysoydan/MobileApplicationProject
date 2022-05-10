package com.cbu.mobileapplicationproject.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cbu.mobileapplicationproject.Comment;
import com.cbu.mobileapplicationproject.CommentRecyclerAdapter;
import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityCommentBinding;
import com.cbu.mobileapplicationproject.entities.concrete.Answer;
import com.cbu.mobileapplicationproject.entities.concrete.Content;
import com.cbu.mobileapplicationproject.entities.concrete.Question;
import com.cbu.mobileapplicationproject.ui.adapter.AnswerRecyclerAdapter;
import com.cbu.mobileapplicationproject.ui.adapter.ItemClickListener;
import com.cbu.mobileapplicationproject.ui.adapter.QuestionRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.MainViewModel;
import model.QuestionDetailViewModel;
import model.QuestionViewModel;


public class CommentActivity extends AppCompatActivity implements ItemClickListener {
    private Question question;
    private Answer answer;
    private QuestionDetailViewModel questionDetailViewModel;
    private List<Answer> answers;
    private SharedPreferences sp;

    private ArrayList<Comment> comments;
    private RecyclerView recyclerView;
    private CommentRecyclerAdapter commentRecyclerAdapter;
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

    private void fillTheArrayC(){

        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));
        comments.add(new Comment(R.drawable.profile_icon,"Ömer Özoğlu","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque adipiscing commodo elit at imperdiet. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Lorem ipsum dolor sit amet consectetur adipiscing elit ut aliquam. Arcu felis bibendum ut tristique et. Facilisis magna etiam tempor orci eu lobortis. Facilisis mauris sit amet massa vitae. Cursus sit amet dictum sit. Porttitor rhoncus dolor purus non enim praesent elementum facilisis leo. Mauris sit amet massa vitae tortor condimentum lacinia. Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Sagittis vitae et leo duis."));

    }
    private void viewSettingsC(){
        recyclerView = findViewById(R.id.recyclerview_comment);
        comments = new ArrayList<>();
        commentRecyclerAdapter = new CommentRecyclerAdapter(comments);
        recyclerView.setAdapter(commentRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view, int position) {

    }
}