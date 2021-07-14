package com.example.demoapp.model.others;

public class Globals {
    private static Globals mInstance = null;

    private User mUser;

    private String deviceID;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public static synchronized Globals getInstance() {
        if (null == mInstance) {
            mInstance = new Globals();
        }
        return mInstance;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    public User getUser() {
        return mUser;
    }


}
