package com.example.final_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SuiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suite);

        // Set the title in the action bar
        getSupportActionBar().setTitle("Suite Rooms");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back to the previous screen
        return true;
    }

}