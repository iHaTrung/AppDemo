package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    private String user_id;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("firstname_kana")
    private String firstname_kana;
    @SerializedName("lastname_kana")
    private String lastname_kana;
    @SerializedName("email")
    private String email;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("path_avatar")
    private String path_avatar;
    @SerializedName("prefecture_id")
    private String prefecture_id;
    @SerializedName("local_id")
    private String local_id;
    @SerializedName("team_id")
    private String team_id;
    @SerializedName("position_id")
    private String position_id;
    @SerializedName("role_id")
    private String role_id;
    @SerializedName("status")
    private String status;
    @SerializedName("prefecture_name")
    private String prefecture_name;
    @SerializedName("local_name")
    private String local_name;
    @SerializedName("team_name")
    private String team_name;
    @SerializedName("position_name")
    private String position_name;

    @SerializedName("token_login")
    private String token_login;


    public User() {
    }

    public User(String user_id, String firstname, String lastname, String firstname_kana, String lastname_kana, String email, String avatar, String path_avatar, String prefecture_id, String local_id, String team_id, String position_id, String role_id, String status, String prefecture_name, String local_name, String team_name, String position_name) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstname_kana = firstname_kana;
        this.lastname_kana = lastname_kana;
        this.email = email;
        this.avatar = avatar;
        this.path_avatar = path_avatar;
        this.prefecture_id = prefecture_id;
        this.local_id = local_id;
        this.team_id = team_id;
        this.position_id = position_id;
        this.role_id = role_id;
        this.status = status;
        this.prefecture_name = prefecture_name;
        this.local_name = local_name;
        this.team_name = team_name;
        this.position_name = position_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getFirstname_kana() {
        return firstname_kana;
    }

    public void setFirstname_kana(String firstname_kana) {
        this.firstname_kana = firstname_kana;
    }

    public String getLastname_kana() {
        return lastname_kana;
    }

    public void setLastname_kana(String lastname_kana) {
        this.lastname_kana = lastname_kana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPath_avatar() {
        return path_avatar;
    }

    public void setPath_avatar(String path_avatar) {
        this.path_avatar = path_avatar;
    }

    public String getPrefecture_id() {
        return prefecture_id;
    }

    public void setPrefecture_id(String prefecture_id) {
        this.prefecture_id = prefecture_id;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrefecture_name() {
        return prefecture_name;
    }

    public void setPrefecture_name(String prefecture_name) {
        this.prefecture_name = prefecture_name;
    }

    public String getLocal_name() {
        return local_name;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getToken_login() {
        return token_login;
    }

    public void setToken_login(String token_login) {
        this.token_login = token_login;
    }
}
