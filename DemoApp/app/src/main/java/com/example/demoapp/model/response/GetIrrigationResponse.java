package com.example.demoapp.model.response;

import com.example.demoapp.model.others.Irrigation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class GetIrrigationResponse extends MessageResponse {
    @SerializedName("data")
    @Expose
    private LinkedList<Irrigation> data;


    public LinkedList<Irrigation> getData() {
        return data;
    }

    public void setData(LinkedList<Irrigation> data) {
        this.data = data;
    }
}
