package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.databinding.ActivityRegisterBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.google.android.material.snackbar.Snackbar;

import javax.security.auth.login.LoginException;

import model.RegisterViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel viewModel;
    private ActivityRegisterBinding viewBinding;
    private IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewModel=new ViewModelProvider(this).get(RegisterViewModel.class);
        TextView Name = viewBinding.registerTxtName;
        TextView SName=viewBinding.registerTxtSurname;
        TextView Email = viewBinding.registerTxtEmail;
        TextView Pass = viewBinding.registerTxtPassword;
        TextView RePass = viewBinding.registerTxtPassword2;


        viewBinding.registerBtnRegister.setOnClickListener(view -> {

            if(Pass.getText().toString().trim().length()>0 && Pass.getText().toString().equals(RePass.getText().toString()))
            {
                viewModel.CreateUser(Name.getText().toString(),SName.getText().toString(),Email.getText().toString(),Pass.getText().toString(),this.getApplicationContext());
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            else
            {
                Snackbar.make(view,"Hatalı giriş",Snackbar.LENGTH_SHORT).show();
            }


        });
        viewBinding.registerBtnBack.setOnClickListener(view -> {

        });
    }




}