package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cbu.mobileapplicationproject.databinding.ActivityRegisterBinding;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRegisterBinding viewBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        TextView TVName = viewBinding.registerTxtName;
        TextView TVEmail = viewBinding.registerTxtEmail;
        TextView TVPass = viewBinding.registerTxtPassword;
        TextView TVRePass = viewBinding.registerTxtPassword2;
        viewBinding.registerBtnRegister.setOnClickListener(view -> {
            Snackbar.make(view,TVName.getText()+" "+TVEmail.getText()+" "+TVPass.getText()+" "+TVRePass.getText(),Snackbar.LENGTH_SHORT).show();
        });

        viewBinding.registerBtnBack.setOnClickListener(view -> {

        });
    }
}