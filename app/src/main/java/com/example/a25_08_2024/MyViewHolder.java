package com.example.a25_08_2024;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    RatingBar rate;
    TextView name, title;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.idImg);  // Use itemView.findViewById
        rate = itemView.findViewById(R.id.ratingBar);
        name = itemView.findViewById(R.id.name);
        title = itemView.findViewById(R.id.title);
    }
}
