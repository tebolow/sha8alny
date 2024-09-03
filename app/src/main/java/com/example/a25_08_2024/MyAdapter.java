package com.example.a25_08_2024;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context cntxt;
    List<Item> items;

    public MyAdapter(Context cntxt, List<Item> items) {
        this.cntxt = cntxt;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(cntxt).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = items.get(position);
        holder.image.setImageResource(items.get(position).getImage());
        holder.rate.setRating(items.get(position).getRate());
        holder.name.setText(items.get(position).getName());
        holder.title.setText(items.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float stars = holder.rate.getRating();
                String iName = holder.name.getText().toString();
                String iTitle = holder.title.getText().toString();
                int imageResId = item.getImage(); // Get the image resource ID

                Context context = view.getContext();
                Intent intent = new Intent(context, Card.class);
                intent.putExtra("RATING", stars);
                intent.putExtra("NAME", iName);
                intent.putExtra("TITLE", iTitle);
                intent.putExtra("IMAGE", imageResId); // Pass the image resource ID

                // Add FLAG_ACTIVITY_NEW_TASK if the context is not an Activity
                if (!(context instanceof android.app.Activity)) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
