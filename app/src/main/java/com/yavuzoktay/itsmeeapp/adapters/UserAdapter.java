package com.yavuzoktay.itsmeeapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yavuzoktay.itsmeeapp.UserDetail;
import com.yavuzoktay.itsmeeapp.R;
import com.yavuzoktay.itsmeeapp.models.User;

import java.util.List;

/**
 * Created by Yavuz on 15.10.2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name ;
        public TextView userName ;
        public CardView cardView ;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textIsım);
            userName=itemView.findViewById(R.id.textSoyIsim);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

    List<User> user;
    Context context ;

    public UserAdapter(List<User> placeHolderModel, Context context) {
        this.user = placeHolderModel;
        this.context=context;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_custom,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return  viewHolder ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText("Name : " + user.get(position).getName());
        holder.userName.setText("UserName : " + user.get(position).getUsername());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UserDetail.class);
                intent.putExtra("mesaj",user.get(position).getId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return user.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}