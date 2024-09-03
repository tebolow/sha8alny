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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
                    if (validateUser(username.getText().toString(), password.getText().toString())) {
                        Intent intent = new Intent(SecondTask.this, Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SecondTask.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

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

    private boolean validateUser(String username, String password) {
        String fileName = "accounts.txt";
        try (FileInputStream fis = openFileInput(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Log.d("username", parts[0]);
                Log.d("password", parts[1]);
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true; // User is valid
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // User not found or password mismatch
    }
}