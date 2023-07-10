package com.example.final_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.Models.PictureItem;

import java.util.ArrayList;
import java.util.List;

public class SingleActivity extends AppCompatActivity {

    private List<PictureItem> pictureList;
    private RecyclerView recyclerView;
    private PictureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pictureList = new ArrayList<>();
        // Add your pictures and text to the pictureList
        pictureList.add(new PictureItem("Picture 1", "https://cdn.loewshotels.com/loewshotels.com-2466770763/cms/cache/v2/5f5a6dfa24c23.jpg/1920x1080/fit/80/6bdfd71c421c7cafd9695770e40230e9.webp"));
        pictureList.add(new PictureItem("Picture 2", "https://example.com/image2.jpg"));
        // Add more items as needed

        adapter = new PictureAdapter(this, pictureList);
        recyclerView.setAdapter(adapter);
    }
}