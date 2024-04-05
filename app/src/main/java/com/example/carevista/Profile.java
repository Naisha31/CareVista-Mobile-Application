package com.example.carevista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView username = findViewById(R.id.username);
        username.setText("Username: " + getIntent().getStringExtra("username"));
        TextView gender = findViewById(R.id.gender);
        gender.setText("Gender: " + getIntent().getStringExtra("gender"));
        TextView dob = findViewById(R.id.dob);
        dob.setText("Date of Birth: " + getIntent().getStringExtra("date"));
        TextView weight = findViewById(R.id.weight);
        weight.setText("Weight: " + getIntent().getStringExtra("weight"));
        TextView height = findViewById(R.id.height);
        height.setText("Height: " + getIntent().getStringExtra("height"));

        Button edit=findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, profile_management.class));
            }
        });
    }
}