package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.cbu.mobileapplicationproject.databinding.ActivityLoginBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.google.gson.Gson;

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
        User user= new Gson().fromJson(sp.getString("userJson",""), User.class);
        String isRemembered=sp.getString("isRemembered","unchecked");
        Log.e("is remembered", isRemembered );
        if(user.getId()!=0 && isRemembered.equals("checked"))
        {
            viewBinding.loginTxtEmail.setText(user.getMail());
            viewBinding.loginTxtPassword.setText(user.getPassword());
            viewBinding.checboxRemember.setChecked(true);
        }

        viewBinding.checboxRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    sp=getApplicationContext().getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("isRemembered","checked");
                    editor.apply();
                }
                else if(!compoundButton.isChecked())
                {
                    sp=getApplicationContext().getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("isRemembered","unchecked");
                    editor.apply();
                }
            }
        });

        viewBinding.loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.LoginUser(viewBinding.loginTxtEmail.getText().toString(),viewBinding.loginTxtPassword.getText().toString(),LoginActivity.this);
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