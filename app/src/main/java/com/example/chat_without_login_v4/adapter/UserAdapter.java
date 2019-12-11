package com.example.chat_without_login_v4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_without_login_v4.R;

import java.util.List;

import model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.textUsername.setText(user.getUsername());
//        holder.happy.setText(user.getFeeling());
//        holder.sad.setText(user.getFeeling());
        if (user.getFeeling().equals("happy")) {
            holder.happy.setText(user.getFeeling());
            holder.sad.setText("");
        }
        else if (user.getFeeling().equals("sad")) {
            holder.sad.setText(user.getFeeling());
            holder.happy.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textUsername, happy, sad;
        ViewHolder(View itemView) {
            super(itemView);
            textUsername = (TextView) itemView.findViewById(R.id.textUsername);
            happy = (TextView) itemView.findViewById(R.id.textFeelingHappy);
            sad = (TextView) itemView.findViewById(R.id.textFeelingSad);
        }
    }
}