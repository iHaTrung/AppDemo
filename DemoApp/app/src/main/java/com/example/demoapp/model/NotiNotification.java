package com.example.demoapp.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotiNotification {
    private String title;
    private String content;
    private String time;
    private String place;
    private String address;

    public NotiNotification() {
    }

    public NotiNotification(String title, String content, String time, String place, String address) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.place = place;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getAddress() {
        return address;
    }


}
