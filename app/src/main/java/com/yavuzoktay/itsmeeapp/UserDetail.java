package com.yavuzoktay.itsmeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.yavuzoktay.itsmeeapp.adapters.UserDetailAdapter;
import com.yavuzoktay.itsmeeapp.models.User;
import com.yavuzoktay.itsmeeapp.networks.Factory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserDetailAdapter userDetailAdapter ;
    private ArrayList<UserDetail> albums;
    private LinearLayoutManager linearLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);

        linearLayoutManager =new LinearLayoutManager(getBaseContext());
        linearLayoutManager.scrollToPosition(0);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        albums=new ArrayList<UserDetail>();


        Intent intent =getIntent();
       // Toast.makeText(this, String.valueOf(intent.getIntExtra("mesaj", 0)), Toast.LENGTH_SHORT).show();
        Factory.getInstance().userDetail(intent.getIntExtra("mesaj",0)).enqueue(new Callback<List<User>>() {
            @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userDetailAdapter=new UserDetailAdapter(response.body(),UserDetail.this);
                recyclerView.setAdapter(userDetailAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }
}