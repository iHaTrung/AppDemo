package com.example.demoapp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateDeviceResponse {
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("data")
    @Expose
    Device data;
    @SerializedName("code")
    @Expose
    int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Device getData() {
        return data;
    }

    public void setData(Device data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class Device {
        @SerializedName("device_id")
        @Expose
        String deviceId;

        @SerializedName("type")
        @Expose
        int type;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

}
