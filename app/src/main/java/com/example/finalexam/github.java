package com.example.finalexam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class github {

    @SerializedName("items")
    @Expose
    private List<github_> github = null;

    public List<github_> getGithub(){
        return github;
    }

    public void setGithub(List<github_> github) {
        this.github = github;
    }
}

