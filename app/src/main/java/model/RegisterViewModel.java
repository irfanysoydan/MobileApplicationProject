package model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.base.MainActivity;
import com.cbu.mobileapplicationproject.ui.list.UserList;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {
    private User yUser;
    private SharedPreferences sp;
    IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
    public String test()
    {
        return "test";
    }

    public void CreateUser(String name, String surname, String mail, String password, Context context)
    {
        sp=context.getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        userDataService.create(new User(name,surname,mail,password)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("id yazdim", ""+response.body().getId() );
                editor.putInt("id",response.body().getId());
                editor.putString("creation_date",response.body().getCreationDate().toString());
                editor.putInt("created_user_id",response.body().getCreatedUserId());
                editor.putString("update_date",response.body().getUpdateDate().toString());
                editor.putInt("updated_user_id",response.body().getUpdatedUserId());
                editor.putBoolean("is_deleted",response.body().getIsDeleted());
                editor.putString("name",response.body().getName());
                editor.putString("surname",response.body().getSurname());
                editor.putString("email",response.body().getMail());
                editor.putString("password",response.body().getPassword());
                editor.apply();

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Hata mesaji", t.toString() );
            }
        });

    }
}
