package com.example.final_project.UI.room_service;

public class RoomServiceItem {
    private int imageResId;
    private String title;

    public RoomServiceItem(int imageResId, String title) {
        this.imageResId = imageResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}

