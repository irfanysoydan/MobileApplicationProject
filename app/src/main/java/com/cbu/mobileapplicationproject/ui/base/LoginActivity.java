package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.databinding.ActivityLandingBinding;
import com.cbu.mobileapplicationproject.databinding.ActivityLoginBinding;

import model.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel viewModel;
    private ActivityLoginBinding viewBinding;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewModel=new ViewModelProvider(this).get(LoginViewModel.class);
        sp=getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        if(sp.getInt("id",0)!=0)
        {
            viewBinding.loginTxtEmail.setText(sp.getString("email",""));
            viewBinding.loginTxtPassword.setText(sp.getString("password",""));
        }

        viewBinding.loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.LoginUser(viewBinding.loginTxtEmail.getText().toString(),viewBinding.loginTxtPassword.getText().toString(),LoginActivity.this);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        viewBinding.txtLogin5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        viewBinding.loginBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}