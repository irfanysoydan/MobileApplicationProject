package model;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.LoginRepository;
import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.repositories.QuestionRepository;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.ui.base.LoginActivity;
import com.cbu.mobileapplicationproject.ui.base.MainActivity;
import com.cbu.mobileapplicationproject.ui.base.RegisterActivity;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends AndroidViewModel {
    private LoginRepository loginRepository;
    private SharedPreferences sp;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.loginRepository = new LoginRepository();
    }

    public void LoginUser(String email, String password, Context context)
    {
        User yUser=new User(email,password);
        sp=context.getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        loginRepository.loginMutableLiveData(yUser).observe((LifecycleOwner) context, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user!=null)
                {
                    Log.e("Login TEST", "onChanged: "+user.getMail() );
                    editor.putInt("id",user.getId());
                    editor.putString("creation_date",user.getCreationDate().toString());
                    editor.putInt("created_user_id",user.getCreatedUserId());
                    editor.putString("update_date",user.getUpdateDate().toString());
                    editor.putInt("updated_user_id",user.getUpdatedUserId());
                    editor.putBoolean("is_deleted",user.getIsDeleted());
                    editor.putString("name",user.getName());
                    editor.putString("surname",user.getSurname());
                    editor.putString("email",user.getMail());
                    editor.putString("password",user.getPassword());
                    editor.apply();
                    Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
                else
                {
                    Toast toast = Toast.makeText(context, "Email veya parola yanlış.", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }
}
