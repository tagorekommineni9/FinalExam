package com.example.finalexam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class coderepos {

    @SerializedName("items")
    @Expose
    private List<coderepos_> coderepos = null;

    public List<coderepos_> getCoderepos() {
        return coderepos;
    }

    public void setCoderepos(List<coderepos_> coderepos) {
        this.coderepos = coderepos;
    }
}
