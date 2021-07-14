package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse extends BaseResponse {
    @SerializedName("data")
    private User user;

    public User getData() {
        return user;
    }
}
