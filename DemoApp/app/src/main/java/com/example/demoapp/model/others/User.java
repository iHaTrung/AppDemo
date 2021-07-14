package com.example.demoapp.model.others;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("token_login")
    private String tokenLogin;

    @Expose
    @SerializedName("user_id")
    private String userId;

    @Expose
    @SerializedName("firstname")
    private String firstName;

    @Expose
    @SerializedName("lastname")
    private String lastName;

    @Expose
    @SerializedName("firstname_kana")
    private String firstNameKana;

    @Expose
    @SerializedName("lastname_kana")
    private String lastNameKana;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("prefecture_id")
    private String prefectureId;

    @Expose
    @SerializedName("local_id")
    private String localId;

    @Expose
    @SerializedName("team_id")
    private String teamId;

    @Expose
    @SerializedName("position_id")
    private String positionId;

    @Expose
    @SerializedName("role_id")
    private String roleId;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("prefecture_name")
    private String prefectureName;

    @Expose
    @SerializedName("local_name")
    private String localName;

    @Expose
    @SerializedName("team_name")
    private String teamName;


    public User(String tokenLogin, String userId, String firstName, String lastName, String firstNameKana, String lastNameKana, String email, String prefectureId, String localId, String teamId, String positionId, String roleId, String status, String prefectureName, String localName, String teamName) {
        this.tokenLogin = tokenLogin;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstNameKana = firstNameKana;
        this.lastNameKana = lastNameKana;
        this.email = email;
        this.prefectureId = prefectureId;
        this.localId = localId;
        this.teamId = teamId;
        this.positionId = positionId;
        this.roleId = roleId;
        this.status = status;
        this.prefectureName = prefectureName;
        this.localName = localName;
        this.teamName = teamName;
    }

    public String getTokenLogin() {
        return tokenLogin;
    }

    public void setTokenLogin(String tokenLogin) {
        this.tokenLogin = tokenLogin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefectureId() {
        return prefectureId;
    }

    public void setPrefectureId(String prefectureId) {
        this.prefectureId = prefectureId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrefectureName() {
        return prefectureName;
    }

    public void setPrefectureName(String prefectureName) {
        this.prefectureName = prefectureName;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
