package com.example.finalexam;

import com.google.gson.annotations.Expose;

import java.util.List;

public class repos {

    @Expose
    private List<repos_> repos = null;

    public List<repos_> getRepos() {
        return repos;
    }

    public void setRepos(List<repos_> repos) {
        this.repos = repos;
    }
}
