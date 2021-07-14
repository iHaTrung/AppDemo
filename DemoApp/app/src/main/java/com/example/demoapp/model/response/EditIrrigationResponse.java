package com.example.demoapp.model.response;

import com.example.demoapp.model.others.IrrigationFire;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditIrrigationResponse extends MessageResponse {
    @SerializedName("data")
    @Expose
    IrrigationFire irrigationFire;

    public IrrigationFire getIrrigationFire() {
        return irrigationFire;
    }

    public void setIrrigationFire(IrrigationFire irrigationFire) {
        this.irrigationFire = irrigationFire;
    }
}
