package model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.base.LoginActivity;
import com.cbu.mobileapplicationproject.ui.base.MainActivity;
import com.cbu.mobileapplicationproject.ui.base.RegisterActivity;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends ViewModel {

    private SharedPreferences sp;
    IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
    public void LoginUser(String email, String password, Context context)
    {
        User yUser=new User(email,password);
        sp=context.getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        userDataService.login(yUser).enqueue(new Callback<User>() {
           @Override
           public void onResponse(Call<User> call, Response<User> response) {


               if(response.body()!=null)
               {
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
                   Log.e("Status", "onResponse: elhamdülillah girdik");
                   Log.e("Status", response.body().getId()+"");
                   Intent intent = new Intent(context, MainActivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);
               }
               else
               {
                   Log.e("Status", "onResponse: Email veya parola yanlış");
                   Toast toast = Toast.makeText(context, "Email veya parola yanlış.", Toast.LENGTH_LONG);
                   toast.show();
               }


           }

           @Override
           public void onFailure(Call<User> call, Throwable t) {
               Log.e("Status", "onResponse: sıkıntılandık");
           }
       });
    }
}
