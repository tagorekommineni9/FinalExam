package com.example.finalexam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class userdetails {

    @SerializedName("items")
    @Expose
    private List<userdetails_> userdetails = null;

    public List<userdetails_> getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(List<userdetails_> userdetails) {
        this.userdetails = userdetails;
    }
}
