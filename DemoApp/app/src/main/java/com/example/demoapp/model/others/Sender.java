package com.example.demoapp.model.others;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sender {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname_kana")
    @Expose
    private String firstnameKana;
    @SerializedName("lastname_kana")
    @Expose
    private String lastnameKana;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("local")
    @Expose
    private Local local;
    @SerializedName("prefecture")
    @Expose
    private Prefecture prefecture;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstnameKana() {
        return firstnameKana;
    }

    public void setFirstnameKana(String firstnameKana) {
        this.firstnameKana = firstnameKana;
    }

    public String getLastnameKana() {
        return lastnameKana;
    }

    public void setLastnameKana(String lastnameKana) {
        this.lastnameKana = lastnameKana;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Prefecture getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(Prefecture prefecture) {
        this.prefecture = prefecture;
    }

    public static class Local {
        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Prefecture {

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Team {

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}