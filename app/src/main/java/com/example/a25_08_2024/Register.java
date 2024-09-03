package com.example.a25_08_2024;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    Button register;
    EditText email, username, password, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phoneNumber = findViewById(R.id.phoneNumber);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean user = username.getText().toString().isEmpty();
                boolean mail = email.getText().toString().isEmpty();
                boolean pass = password.getText().toString().isEmpty();
                boolean phone = phoneNumber.getText().toString().isEmpty();
                if (user || mail || pass || phone) {
                    Toast.makeText(Register.this, "Please fill required fields", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Register.this, Home.class);
                    startActivity(intent);
                }

            }
        });
    }
}