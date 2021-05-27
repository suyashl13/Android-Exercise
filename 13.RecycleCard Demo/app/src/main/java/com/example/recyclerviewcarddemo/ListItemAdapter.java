package com.example.recyclerviewcarddemo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder> {

    ArrayList<ListItem> items;

    ListItemAdapter(ArrayList<ListItem> items){
        this.items = items;
    }

    public static class ListItemHolder extends RecyclerView.ViewHolder {

        ImageView listImage;
        TextView textView;

        @SuppressLint("CutPasteId")
        public ListItemHolder(@NonNull View itemView) {
            super(itemView);
            listImage = itemView.findViewById(R.id.place_image);
            textView = itemView.findViewById(R.id.image_text);
        }
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemAdapter.ListItemHolder holder, int position) {
        holder.listImage.setImageResource(items.get(position).getImageView());
        holder.textView.setText(items.get(position).getImageText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
