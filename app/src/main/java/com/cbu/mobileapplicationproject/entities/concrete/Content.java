package com.cbu.mobileapplicationproject.entities.concrete;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Content extends EntityBase implements Serializable {

    @SerializedName("text")
    private String Text;
    @SerializedName("media_paths")
    private List<String> MediaPaths;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public List<String> getMediaPaths() {
        return MediaPaths;
    }

    public void setMediaPaths(List<String> mediaPaths) {
        MediaPaths = mediaPaths;
    }
}
