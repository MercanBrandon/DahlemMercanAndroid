package com.example.merca.dahlemmercan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListFollower {

    @SerializedName("followers")
    @Expose
    private List<Follower> followers = null;

    public List<Follower> getItems() {
        return followers;
    }

    public void setItems(List<Follower> followers) {
        this.followers = followers;
    }
}
