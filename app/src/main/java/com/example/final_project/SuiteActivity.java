package com.example.final_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.Models.PictureItem;

import java.util.ArrayList;
import java.util.List;

public class SuiteActivity extends AppCompatActivity {


        private List<PictureItem> pictureList;
        private RecyclerView recyclerView;
        private PictureAdapter adapter;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pictureList = new ArrayList<>();
        // Add your pictures and text to the pictureList
            pictureList.add(new PictureItem("City view\n 50*50 m\n 240$", "https://cdn.loewshotels.com/loewshotels.com-2466770763/cms/cache/v2/5f5a6dfa24c23.jpg/1920x1080/fit/80/6bdfd71c421c7cafd9695770e40230e9.webp"));
            pictureList.add(new PictureItem("City view\n 50*50 m\n 260$", "https://cdn.loewshotels.com/loewshotels.com-2466770763/cms/cache/v2/5f5a6dfa24c23.jpg/1920x1080/fit/80/6bdfd71c421c7cafd9695770e40230e9.webp"));
            pictureList.add(new PictureItem("City view\n 50*50 m\n 280$", "https://cdn.loewshotels.com/loewshotels.com-2466770763/cms/cache/v2/5f5a6dfa24c23.jpg/1920x1080/fit/80/6bdfd71c421c7cafd9695770e40230e9.webp"));
            pictureList.add(new PictureItem("City view\n 50*50 m\n 200$", "https://cdn.loewshotels.com/loewshotels.com-2466770763/cms/cache/v2/5f5a6dfa24c23.jpg/1920x1080/fit/80/6bdfd71c421c7cafd9695770e40230e9.webp"));
            // Add more items as needed


            adapter = new PictureAdapter(this, pictureList);
        recyclerView.setAdapter(adapter);

        // Set the title in the action bar
        getSupportActionBar().setTitle("Suite Rooms");
    }
        @Override
        public boolean onSupportNavigateUp () {
        onBackPressed(); // Go back to the previous screen
        return true;
    }

    }
