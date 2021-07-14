package com.example.demoapp.model.response;

import com.example.demoapp.model.others.IrrigationFire;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class GetIrrigationFireResponse {
    @Expose
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    @Expose
    private LinkedList<IrrigationFire> data;

    @Expose
    @SerializedName("code")
    private int code;


    public LinkedList<IrrigationFire> getData() {
        return data;
    }

    public void setData(LinkedList<IrrigationFire> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

