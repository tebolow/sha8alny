package com.example.a25_08_2024;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Card extends AppCompatActivity {
    RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.card);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rating = findViewById(R.id.rating);
        float stars = getIntent().getFloatExtra("RATING", 0f);
        rating.setRating(stars);
    }
}