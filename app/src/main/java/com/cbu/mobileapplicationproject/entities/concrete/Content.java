package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Content extends EntityBase{

    @SerializedName("text")
    private String Text;
    @SerializedName("media_paths")
    private ArrayList<String> MediaPaths;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public ArrayList<String> getMediaPaths() {
        return MediaPaths;
    }

    public void setMediaPaths(ArrayList<String> mediaPaths) {
        MediaPaths = mediaPaths;
    }
}
