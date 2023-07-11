package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OffersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        // Set the title in the action bar
        getSupportActionBar().setTitle("Offers");

        Button offer1Button = findViewById(R.id.offer1Button);
        Button offer2Button = findViewById(R.id.offer2Button);
        Button offer3Button = findViewById(R.id.offer3Button);

        offer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button 1 click
                navigateToReservationActivity();
            }
        });

        offer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button 2 click
                navigateToReservationActivity();
            }
        });

        offer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button 3 click
                navigateToReservationActivity();
            }
        });
    }

    private void navigateToReservationActivity() {
        Intent intent = new Intent(OffersActivity.this, ReservationActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back to the previous screen
        return true;
    }
}