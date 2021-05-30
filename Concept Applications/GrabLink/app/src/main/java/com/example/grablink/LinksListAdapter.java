package com.example.grablink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinksListAdapter extends RecyclerView.Adapter<LinksListAdapter.LinkListHolder> {

    ArrayList<AppLink> links;

    LinksListAdapter(ArrayList<AppLink> links){
        this.links = links;
    }


    public static class LinkListHolder extends RecyclerView.ViewHolder {

        TextView linkName, linkURL;


        public LinkListHolder(@NonNull View itemView) {
            super(itemView);

            linkName = itemView.findViewById(R.id.linkName);
            linkURL = itemView.findViewById(R.id.link);

        }
    }

    @NonNull
    @Override
    public LinkListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.links_list_items, parent, false);
        return new LinkListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LinksListAdapter.LinkListHolder holder, int position) {
        holder.linkURL.setText(links.get(position).getLinkURL());
        holder.linkName.setText(links.get(position).getLinkName());
    }

    @Override
    public int getItemCount() {
        return links.size();
    }
}
