package com.example.demoapp.model.response;

import com.example.demoapp.model.others.BaseData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errors")
    @Expose
    private List<String> errors;
    @SerializedName("data")
    @Expose
    private List<BaseData> data;
    @SerializedName("code")
    @Expose
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<BaseData> getData() {
        return data;
    }

    public void setData(List<BaseData> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
