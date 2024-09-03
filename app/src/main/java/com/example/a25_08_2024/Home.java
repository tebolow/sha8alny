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

        container = findViewById(R.id.container);
        for (int i = 0; i < container.getChildCount(); i++) {
            View card = container.getChildAt(i);

            if (card instanceof LinearLayout) {
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RatingBar ratingBar = null;

                        // Find the RatingBar inside the clicked card
                        for (int j = 0; j < ((LinearLayout) card).getChildCount(); j++) {
                            View child = ((LinearLayout) card).getChildAt(j);
                            if (child instanceof RatingBar) {
                                ratingBar = (RatingBar) child;
                                break;
                            } else if (child instanceof LinearLayout){
                                for (int k = 0; j < ((LinearLayout) child).getChildCount(); k++) {
                                    View secondChild = ((LinearLayout) child).getChildAt(k);
                                    if (secondChild instanceof RatingBar) {
                                        ratingBar = (RatingBar) secondChild;
                                        break;
                                    }
                                }
                            }
                        }

                        // Get the filled stars and pass it in the Intent
                        if (ratingBar != null) {
                            float stars = ratingBar.getRating(); // Get the filled stars
                            Intent intent = new Intent(Home.this, Card.class);
                            intent.putExtra("RATING", stars);
                            startActivity(intent);
                        } else {
                            // No RatingBar found, just start the activity
                            Intent intent = new Intent(Home.this, Card.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        }
    }
}
