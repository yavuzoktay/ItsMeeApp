package com.yavuzoktay.itsmeeapp.networks;

/**
 * Created by Yavuz on 14.10.2017.
 */

import com.yavuzoktay.itsmeeapp.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Factory {
    public static ServiceGenerator serviceGenerator;

    public static ServiceGenerator getInstance(){
        if (serviceGenerator  == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            serviceGenerator = retrofit.create(ServiceGenerator.class);
            return serviceGenerator;
        }else{
            return serviceGenerator;
        }
    }
}