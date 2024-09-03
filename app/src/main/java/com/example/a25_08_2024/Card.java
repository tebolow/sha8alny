package com.example.a25_08_2024;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class Card extends AppCompatActivity {
    CircleImageView imageView;
    RatingBar ratingBar;
    TextView nameTextView, titleTextView, phone;
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
        ratingBar = findViewById(R.id.rating);
        imageView = findViewById(R.id.circularImageView);
        nameTextView = findViewById(R.id.cardName);
        titleTextView = findViewById(R.id.position);
        phone = findViewById(R.id.phone);
        Intent intent = getIntent();
        float rating = intent.getFloatExtra("RATING", 0f);
        String name = intent.getStringExtra("NAME");
        String title = intent.getStringExtra("TITLE");
        int imageResId = intent.getIntExtra("IMAGE", -1);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
        ratingBar.setRating(rating);
        nameTextView.setText(name);
        String[] positionAndPone = title.split("\n");
        titleTextView.setText("Position: " + positionAndPone[0]);
        phone.setText("Phoen: " + positionAndPone[1]);
    }
}