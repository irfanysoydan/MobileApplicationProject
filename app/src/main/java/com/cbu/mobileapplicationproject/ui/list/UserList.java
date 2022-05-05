package com.cbu.mobileapplicationproject.ui.list;

import com.cbu.mobileapplicationproject.entities.concrete.User;
import com.cbu.mobileapplicationproject.entities.interfaces.IEntityBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserList implements IEntityBase {

    @SerializedName("data")
    private ArrayList<User> userList;

    public ArrayList<User> getUserArrayList() {
        return userList;
    }

    public void getUserArrayList(ArrayList<User> userArrayList) {
        this.userList = userList;
    }
}
