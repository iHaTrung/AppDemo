package com.example.demoapp.model.response;

import com.example.demoapp.model.others.BaseData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddNotificationResponse extends MessageResponse {
    @SerializedName("data")
    @Expose
    BaseData baseData;
    public BaseData getBaseData() {
        return baseData;
    }
    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }
}
