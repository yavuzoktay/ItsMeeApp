package com.yavuzoktay.itsmeeapp.networks;


import com.yavuzoktay.itsmeeapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Yavuz on 14.09.2017.
 */

public interface ServiceGenerator {
    @GET("/users")
    Call<List<User>> user();

    @GET("/users")
    Call<List<User>> userDetail(@Query("id") int id);


}