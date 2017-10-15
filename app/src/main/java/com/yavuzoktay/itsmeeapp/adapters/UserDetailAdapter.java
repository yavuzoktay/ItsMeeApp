package com.yavuzoktay.itsmeeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yavuzoktay.itsmeeapp.R;
import com.yavuzoktay.itsmeeapp.models.User;

import java.util.List;

/**
 * Created by Yavuz on 15.10.2017.
 */

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name,lastName,email,telefon ;
        public CardView cardView ;


        public ViewHolder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.textAd) ;
            lastName=itemView.findViewById(R.id.textSoyAd) ;
            email=itemView.findViewById(R.id.textEmail) ;
            telefon=itemView.findViewById(R.id.textPhone) ;
            cardView = itemView.findViewById(R.id.cardUser);

        }
    }

    List<User> userModels ;
    Context context ;

    public UserDetailAdapter(List<User> albumsModels, Context context) {
        this.userModels = albumsModels;
        this.context = context;
    }

    @Override
    public UserDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_detail_custom,parent,false);
        ViewHolder viewHolder = new ViewHolder(v) ;
        return  viewHolder ;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText("Name :" +userModels.get(position).getName());
        holder.lastName.setText("UserName :"+userModels.get(position).getUsername());
        holder.telefon.setText("E-mail :"+userModels.get(position).getPhone());
        holder.email.setText("Phone :"+userModels.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return  userModels.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
