package com.example.final_project;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final_project.Models.ReservationData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ReservationActivity extends AppCompatActivity {
    private Button servicesButton;
    private List<ReservationData> reservationList;
    private DatePickerDialog fromDateDialog;
    private DatePickerDialog toDateDialog;
    private EditText fromDateEditText;
    private EditText toDateEditText;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox checkbox4;
    private CheckBox checkbox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        reservationList = new ArrayList<>();

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog.OnDateSetListener fromDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Handle "from" date selection event
                // Use the selected year, monthOfYear, and dayOfMonth values
                int month = monthOfYear + 1;
                calendar.set(year, monthOfYear, dayOfMonth);
                Date fromDate = calendar.getTime();
                fromDateEditText.setText(formatDate(fromDate));
            }
        };

        final DatePickerDialog.OnDateSetListener toDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Handle "to" date selection event
                // Use the selected year, monthOfYear, and dayOfMonth values
                int month = monthOfYear + 1;
                calendar.set(year, monthOfYear, dayOfMonth);
                Date toDate = calendar.getTime();
                toDateEditText.setText(formatDate(toDate));
            }
        };

        // Create the "from" date picker dialog
        fromDateDialog = new DatePickerDialog(
                ReservationActivity.this, fromDateSetListener, year, month, day);

        // Create the "to" date picker dialog
        toDateDialog = new DatePickerDialog(
                ReservationActivity.this, toDateSetListener, year, month, day);

        ImageButton fromDateButton = findViewById(R.id.fromDateButton);
        fromDateEditText = findViewById(R.id.fromDateEditText);
        fromDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the "from" date picker dialog
                fromDateDialog.show();
            }
        });

        ImageButton toDateButton = findViewById(R.id.toDateButton);
        toDateEditText = findViewById(R.id.toDateEditText);
        toDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the "to" date picker dialog
                toDateDialog.show();
            }
        });

        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);

        Button reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the selected "from" date and "to" date from the date picker dialogs
                Date fromDate = calendar.getTime();
                calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day to get the "to" date
                Date toDate = calendar.getTime();

                // Get the selected checkbox choices
                List<String> checkboxChoices = new ArrayList<>();
                if (checkbox1.isChecked()) {
                    checkboxChoices.add(checkbox1.getText().toString());
                }
                if (checkbox2.isChecked()) {
                    checkboxChoices.add(checkbox2.getText().toString());
                }
                if (checkbox3.isChecked()) {
                    checkboxChoices.add(checkbox3.getText().toString());
                }

                // Create a ReservationData object with the selected data
                ReservationData reservationData = new ReservationData(fromDate, toDate, checkboxChoices);

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

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(date);
    }
}