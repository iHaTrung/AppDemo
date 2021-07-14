package com.example.demoapp.model.others;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class IrrigationFire implements Serializable {
    @SerializedName("map_id")
    @Expose
    private int mapId;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("title_address")
    @Expose
    private String titleAddress;
    @SerializedName("detail_address")
    @Expose
    private String detailAddress;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("user_local_id")
    @Expose
    private int userLocalId;
    @SerializedName("distance")
    @Expose
    private double distance;

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitleAddress() {
        return titleAddress;
    }

    public void setTitleAddress(String titleAddress) {
        this.titleAddress = titleAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserLocalId() {
        return userLocalId;
    }

    public void setUserLocalId(int userLocalId) {
        this.userLocalId = userLocalId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

