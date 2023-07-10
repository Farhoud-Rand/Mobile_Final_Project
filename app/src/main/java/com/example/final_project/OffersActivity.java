package com.example.final_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OffersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        // Set the title in the action bar
        getSupportActionBar().setTitle("Offers");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back to the previous screen
        return true;
    }
}