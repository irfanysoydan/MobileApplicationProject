package com.cbu.mobileapplicationproject.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import com.cbu.mobileapplicationproject.R;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.UserRepository;
import com.cbu.mobileapplicationproject.databinding.ActivityAccountBinding;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.utilities.SPHelper;
import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {
    private TextView tvNames,tvEmail, tvLogout;
    private UserRepository userRepository;
    private SPHelper spHelper;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAccountBinding viewBinding=ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        sp=getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        User user=new Gson().fromJson(sp.getString("userJson",""), User.class);

        tvNames=(TextView) findViewById(R.id.textView);
        tvEmail=(TextView) findViewById(R.id.textView3);
        tvLogout=(TextView) findViewById(R.id.textView7);
        tvNames.setText(user.getName()+" "+user.getSurname());
        tvEmail.setText(user.getMail());

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AccountActivity.this, "Çıkış yapılıyor", Toast.LENGTH_LONG).show();

            }
        });


    }
}