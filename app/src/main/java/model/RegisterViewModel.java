package model;

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
    IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);
    public String test()
    {
        return "test";
    }

    public User CreateUser(String name, String surname, String mail, String password)
    {


       yUser=new User(name,surname,mail,password);
        userDataService.create(yUser).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User x=response.body();
                yUser.setId(x.getId());
                yUser.setCreationDate(x.getCreationDate());
                yUser.setCreatedUserId(x.getCreatedUserId());
                yUser.setUpdateDate(x.getUpdateDate());
                yUser.setUpdatedUserId(x.getUpdatedUserId());
                yUser.setIsDeleted(x.getIsDeleted());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Sonuç", "hatalı kayıt" );
               yUser=null;
            }
        });

        Log.e("user",""+yUser.getId() );
        return yUser;
    }
}
