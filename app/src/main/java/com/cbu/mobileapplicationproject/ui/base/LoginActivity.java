package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cbu.mobileapplicationproject.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}