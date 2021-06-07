package com.example.singletonapi;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RandomUsersListAdapter extends RecyclerView.Adapter<RandomUsersListAdapter.RandomUsersListHolder> {

    ArrayList<RandomUser> randomUsers;
    RandomUsersListAdapter(ArrayList<RandomUser> randomUsers){
        this.randomUsers = randomUsers;
    }

    public static class RandomUsersListHolder extends RecyclerView.ViewHolder {
        TextView name, email;
        ImageView imageView;
        public RandomUsersListHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.randomUserName);
            email = itemView.findViewById(R.id.randomUserEmail);
            imageView = itemView.findViewById(R.id.randomUserProfile);
        }
    }

    @NonNull
    @Override
    public RandomUsersListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_user_list_tile, parent, false);
        return new RandomUsersListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUsersListAdapter.RandomUsersListHolder holder, int position) {
        holder.name.setText(randomUsers.get(position).getFullName());
        holder.email.setText(randomUsers.get(position).getEmail());
        holder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public int getItemCount() {return randomUsers.size();}

}
