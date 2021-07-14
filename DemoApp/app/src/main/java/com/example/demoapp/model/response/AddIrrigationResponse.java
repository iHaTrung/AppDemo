package com.example.demoapp.model.response;

import com.example.demoapp.model.others.Irrigation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddIrrigationResponse extends MessageResponse {
    @SerializedName("data")
    @Expose
    Irrigation irrigation;

    public Irrigation getIrrigation() {
        return irrigation;
    }

    public void setIrrigation(Irrigation irrigation) {
        this.irrigation = irrigation;
    }
}