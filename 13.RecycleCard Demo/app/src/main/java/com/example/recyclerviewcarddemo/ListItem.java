package com.example.recyclerviewcarddemo;

import android.widget.ImageView;
import android.widget.TextView;

public class ListItem {
    private final int imageView;
    private final String imageText;

    ListItem(int imageView, String imageText) {
        this.imageText = imageText;
        this.imageView = imageView;
    }

    public int getImageView() {
        return imageView;
    }

    public String getImageText() {
        return imageText;
    }
}
