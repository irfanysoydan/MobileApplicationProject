package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityLandingBinding;
import com.cbu.mobileapplicationproject.databinding.ActivityLoginBinding;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLandingBinding viewBinding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
    }
}