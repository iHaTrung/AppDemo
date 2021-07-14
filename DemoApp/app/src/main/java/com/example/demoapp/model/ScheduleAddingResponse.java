package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

public class ScheduleAddingResponse extends BaseResponse{
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("time_start")
    private String time_start;
    @SerializedName("time_end")
    private String time_end;
    @SerializedName("title_address")
    private String title_address;
    @SerializedName("detail_address")
    private String detail_address;
    @SerializedName("type")
    private int type;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTitle_address() {
        return title_address;
    }

    public void setTitle_address(String title_address) {
        this.title_address = title_address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
