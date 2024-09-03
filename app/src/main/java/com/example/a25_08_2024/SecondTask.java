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

public class SecondTask extends AppCompatActivity {
    Button login;
    Button register;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(SecondTask.this, "Please fill required fields", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(SecondTask.this, Home.class);
                    startActivity(intent);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondTask.this, Register.class);
                startActivity(intent);
            }
        });
    }
}