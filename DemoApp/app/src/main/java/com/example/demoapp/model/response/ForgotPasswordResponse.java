package com.example.demoapp.model.response;

import com.example.demoapp.model.others.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponse {
    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("error")
    private String error;

    @Expose
    @SerializedName("data")
    private User data;

    @Expose
    @SerializedName("code")
    private int code;

    public ForgotPasswordResponse(String message, String error, User data, int code) {
        this.message = message;
        this.error = error;
        this.data = data;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
