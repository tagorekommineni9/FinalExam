package com.example.finalexam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataServices {
    @GET("search/users?q=language:java+location:montreal")
    Call<github> getAllUsers();
    @GET("search/users?q=language:java+location:toronto")
    Call<github> getAllUsers2();

    @GET("users/NaramAkhil/repos")
    Call<List<repos_>> getAllRepos();

    @GET("search/issues?q=windows+label:bug+language:HTML+state:open&sort=&order=asc")
    Call<issues> getAllIssues();



    @GET("search/code?q=Pokemon+in:file+language:java+repo:tagorekommineni9/JetPackFragments")
    Call<coderepos> getAllMatchedCodeDetails();
}
