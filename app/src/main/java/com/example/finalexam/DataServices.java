package com.example.finalexam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataServices {
    @GET("search/users?q=language:java+location:montreal")
    Call<github> getAllUsers();
    @GET("search/users?q=language:java+location:toronto")
    Call<github> getAllUsers2();
}
