package com.example.demoapp.model.response;

import com.example.demoapp.model.others.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private User data;

    @Expose
    @SerializedName("code")
    private int code;

    public LoginResponse(String message, User data, int code) {
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
