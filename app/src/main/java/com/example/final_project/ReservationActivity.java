package com.example.final_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final_project.Models.CustomCalendarView;
import com.example.final_project.Models.ReservationData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReservationActivity extends AppCompatActivity {
    private CustomCalendarView calendarView;

    private Spinner durationSpinner;
    private Button servicesButton;
    private List<ReservationData> reservationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        durationSpinner = findViewById(R.id.durationSpinner);
        servicesButton = findViewById(R.id.servicesButton);
        reservationList = new ArrayList<>();
//        DatePicker datePicker = findViewById(R.id.datePicker);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateClickListener(new CustomCalendarView.OnDateClickListener() {
            @Override
            public void onDateClick(Date date) {
                // Handle calendar date click event
            }
        });


        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click to go to services page
                // Replace with your own logic
                Toast.makeText(ReservationActivity.this, "Go to services page", Toast.LENGTH_SHORT).show();
            }
        });
        Button reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the selected data from the page
                String duration = durationSpinner.getSelectedItem().toString();
                Date selectedDate = (Date) calendarView.getSelectedItem();


                // Create a ReservationData object with the selected data
                ReservationData reservationData = new ReservationData(duration, selectedDate);

                // Add the reservation data to the reservation list
                reservationList.add(reservationData);

                // Optional: Display a toast message to indicate successful reservation
                Toast.makeText(ReservationActivity.this, "Reservation successful", Toast.LENGTH_SHORT).show();
            }
        });

        // Set the title in the action bar
        getSupportActionBar().setTitle("Reservation");

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Go back to the previous screen
        return true;
    }
}