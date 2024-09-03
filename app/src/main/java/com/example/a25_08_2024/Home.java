package com.example.a25_08_2024;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.a, 3.5f, "Alex Martinez", "Senior Software Engineer \n(555) 123-4567"));
        items.add(new Item(R.drawable.b, 5f, "Jordan Lee", "Product Manager \n(555) 234-5678"));
        items.add(new Item(R.drawable.c, 4f, "Barry Lyon", "Chief Technology Officer \n(555) 345-6789"));
        items.add(new Item(R.drawable.d, 5f, "Morgan Davis", "DevOps Engineer \n(555) 456-7890"));
        items.add(new Item(R.drawable.e, 4.5f, "Casey Wilson", "Data Scientist \n(555) 567-8901"));
        items.add(new Item(R.drawable.f, 2f, "Riley Johnson", "Front-End Developer \n(555) 678-9012"));
        items.add(new Item(R.drawable.g, 3f, "Quinn Patel", "Backend Developer \n(555) 789-0123"));
        items.add(new Item(R.drawable.h, 3f, "Charlie Nguyen", "Systems Architect \n(555) 890-1234"));
        items.add(new Item(R.drawable.i, 4f, "Avery Kim", "QA Engineer \n(555) 901-2345"));
        items.add(new Item(R.drawable.j, 5f, "Jamie Clark", "Technical Support Specialist \n(555) 012-3456"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}
