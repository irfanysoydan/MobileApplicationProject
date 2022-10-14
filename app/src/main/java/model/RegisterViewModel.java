package model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.base.LoginActivity;
import com.cbu.mobileapplicationproject.ui.base.MainActivity;
import com.cbu.mobileapplicationproject.ui.base.RegisterActivity;
import com.cbu.mobileapplicationproject.ui.list.UserList;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

    IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
    public String test()
    {
        return "test";
    }

    public void CreateUser(String name, String surname, String mail, String password, Context context)
    {

        userDataService.create(new User(name,surname,mail,password)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!=null)
                {
                    Log.e("id yazdim", ""+response.body().getId() );
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                Toast.makeText(context, "Email kullanılıyor", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Kayıt gerçekleşmedi", t.toString() );
            }
        });

    }
}
