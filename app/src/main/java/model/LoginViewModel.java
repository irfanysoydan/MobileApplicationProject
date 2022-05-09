package model;

import androidx.lifecycle.ViewModel;

import com.cbu.mobileapplicationproject.data.concrete.remote.retrofit.network.RetrofitInstance;
import com.cbu.mobileapplicationproject.data.interfaces.remote.retrofit.IUserDataService;
import com.cbu.mobileapplicationproject.entities.concrete.User;

public class LoginViewModel extends ViewModel {
    IUserDataService userDataService= RetrofitInstance.getRetrofitInstance().create(IUserDataService.class);

    public User LoginUser(String email, String password)
    {
        return null;
    }
}
