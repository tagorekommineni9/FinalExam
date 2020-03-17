package com.example.finalexam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class issues {

    @SerializedName("items")
    @Expose
    private List<issues_> issues = null;

    public List<issues_> getIssues() {
        return issues;
    }

    public void setIssues(List<issues_> issues) {
        this.issues = issues;
    }
}