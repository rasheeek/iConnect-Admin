package com.rasheek.iconnect_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
Button support, news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        support = findViewById(R.id.supportRequests);
        news = findViewById(R.id.newsBtn);

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportIntent = new Intent(home.this, tickets.class);
                startActivity(supportIntent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent supportIntent = new Intent(home.this, tickets.class);
                startActivity(supportIntent);
            }
        });
    }
}