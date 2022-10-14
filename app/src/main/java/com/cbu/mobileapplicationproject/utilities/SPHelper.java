package com.cbu.mobileapplicationproject.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.google.gson.Gson;

public class SPHelper {
    private Context context;
    private SharedPreferences sp;

    public void SavePref(Context context, String spKey){
        this.context = context;
        sp=context.getSharedPreferences(spKey,Context.MODE_PRIVATE);
    }
    public void SavePref(Context context){
        SavePref(context,"MyUserPrefs");
    }

    public User getUser()
    {
        return new Gson().fromJson(sp.getString("userJson",""),User.class);
    }
}
