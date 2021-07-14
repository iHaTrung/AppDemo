package com.example.demoapp.utils;

public class Globals {
    private static Globals INSTANCE;

    private boolean isLoggedIn =false;
    private String userToken;

    private Globals() {
    }

    public static Globals getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Globals();
        }

        return INSTANCE;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
