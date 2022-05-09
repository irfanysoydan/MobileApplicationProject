package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cbu.mobileapplicationproject.databinding.ActivityPostingBinding;

public class PostingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPostingBinding viewBinding = ActivityPostingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

    }
}