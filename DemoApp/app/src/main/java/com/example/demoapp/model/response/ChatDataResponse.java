package com.example.demoapp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ChatDataResponse extends MessageResponse {
    @SerializedName("data")
    @Expose
    ArrayList<ChatData> data;

    public ArrayList<ChatData> getData() {
        return data;
    }

    public void setData(ArrayList<ChatData> data) {
        this.data = data;
    }

    public static class ChatData {
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("group_id")
        @Expose
        private int groupId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("deleted")
        @Expose
        private boolean deleted;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("modified")
        @Expose
        private String modified;

        @SerializedName("sender")
        @Expose
        private SenderChat sender;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public SenderChat getSender() {
            return sender;
        }

        public void setSender(SenderChat sender) {
            this.sender = sender;
        }


        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }
    }

    public static class SenderChat {
        @SerializedName("user_id")
        @Expose
        String userId;
        @SerializedName("username")
        @Expose
        String userName;
        @SerializedName("firstname")
        @Expose
        String firstName;
        @SerializedName("lastname")
        @Expose
        String lastName;
        @SerializedName("firstname_kana")
        @Expose
        String firstNameKana;
        @SerializedName("lastname_kana")
        @Expose
        String lastNameKana;
        @SerializedName("prefecture_name")
        @Expose
        String prefectureName;
        @SerializedName("local_name")
        @Expose
        String localName;
        @SerializedName("team_name")
        @Expose
        String teamName;

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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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


}
