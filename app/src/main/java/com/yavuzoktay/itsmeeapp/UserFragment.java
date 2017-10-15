package com.yavuzoktay.itsmeeapp;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yavuzoktay.itsmeeapp.adapters.UserAdapter;
import com.yavuzoktay.itsmeeapp.networks.Factory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment  {
    RecyclerView recyclerView ;
    UserAdapter userAdapter ;
    ArrayList<User> arrayList ;
    private LinearLayoutManager layoutManager;
    Button itsMeContact,phoneContact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user,container,false);


        recyclerView =  view.findViewById(R.id.recycler_view);
        itsMeContact= view.findViewById(R.id.its_me_contact);


        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.scrollToPosition(0);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        arrayList=new ArrayList<User>();

        initial();

        return view;
    }

    private void initial() {
        Factory.getInstance().user().enqueue(new Callback<List<com.yavuzoktay.itsmeeapp.models.User>>() {
            @Override
            public void onResponse(Call<List<com.yavuzoktay.itsmeeapp.models.User>> call, Response<List<com.yavuzoktay.itsmeeapp.models.User>> response) {
                // textView.setText(response.body().get(0).name);
                userAdapter= new UserAdapter(response.body(), getActivity());
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<List<com.yavuzoktay.itsmeeapp.models.User>> call, Throwable t) {

            }
        });

    }



}
