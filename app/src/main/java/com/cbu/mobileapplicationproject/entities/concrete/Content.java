package com.cbu.mobileapplicationproject.entities.concrete;

import java.util.ArrayList;

public class Content extends EntityBase{

    private String Text;
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
