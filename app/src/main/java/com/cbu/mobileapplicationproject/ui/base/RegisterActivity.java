package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.cbu.mobileapplicationproject.databinding.ActivityRegisterBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.google.android.material.snackbar.Snackbar;

import model.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel viewModel;
    private ActivityRegisterBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewModel=new ViewModelProvider(this).get(RegisterViewModel.class);
        TextView TVName = viewBinding.registerTxtName;
        TextView TVEmail = viewBinding.registerTxtEmail;
        TextView TVPass = viewBinding.registerTxtPassword;
        TextView TVRePass = viewBinding.registerTxtPassword2;

        viewBinding.registerBtnRegister.setOnClickListener(view -> {
            Snackbar.make(view,viewModel.test(),Snackbar.LENGTH_SHORT).show();
            User yUser=viewModel.CreateUser("asd","asdasd","asdasd","asdasds","asdsad");

        });

        viewBinding.registerBtnBack.setOnClickListener(view -> {

        });
    }




}