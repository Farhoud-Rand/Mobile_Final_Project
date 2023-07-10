package com.example.final_project;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.test);
        // FirebaseFirestore instance
        firebaseFirestore = FirebaseFirestore.getInstance();
        User user1 = new User("Rand","r@gmail.com","113","110");
        addToFirestore("Users", "user1", user1); // add Users
    }

    // ======================== Functions =======================================
    private void addToFirestore(String collectionName, String documentId, Object documentObject) {
        firebaseFirestore.collection(collectionName)
                .document()
                .set(documentObject)
                .addOnSuccessListener(unused -> {
                    String successMessage = getSuccessMessage(collectionName);
                    Log.d(TAG, successMessage);
                    Toast.makeText(MainActivity.this, successMessage, Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Log.d(TAG, "Failed to add document: " + e);
                    Toast.makeText(MainActivity.this, "Failed to add document", Toast.LENGTH_SHORT).show();
                });
    }

    private String getSuccessMessage(String collectionName) {
        switch (collectionName) {
            case "Rooms":
                return "Room added successfully";
            case "Users":
                return "User added successfully";
            case "Offers":
                return "Offers added successfully";
            case "MassageReservation":
                return "Massage reservation added successfully";
            case "HotelHall":
                return "Hotel hall added successfully";
            default:
                return "Document added successfully";
        }
    }
}