package com.example.demoapp.model.response;

import com.example.demoapp.model.others.Sender;
import com.example.demoapp.model.others.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

public class GroupChatResponse extends MessageResponse {

    @SerializedName("data")
    @Expose
    LinkedList<GroupChat> data;

    @SerializedName("user_login")
    @Expose
    private User userLogin;

    public LinkedList<GroupChat> getData() {
        return data;
    }


    public void setData(LinkedList<GroupChat> data) {
        this.data = data;
    }

    public User getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(User userLogin) {
        this.userLogin = userLogin;
    }


    public static class GroupChat {
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("type_group")
        @Expose
        private int typeGroup;
        @SerializedName("deleted")
        @Expose
        private boolean deleted;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("modified")
        @Expose
        private String modified;
        @SerializedName("last_message")
        @Expose
        private LastMessage lastMessage;
        @SerializedName("sender")
        @Expose
        private Sender sender;
        @SerializedName("name_group")
        @Expose
        private String nameGroup;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTypeGroup() {
            return typeGroup;
        }

        public void setTypeGroup(int typeGroup) {
            this.typeGroup = typeGroup;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public LastMessage getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(LastMessage lastMessage) {
            this.lastMessage = lastMessage;
        }

        public Sender getSender() {
            return sender;
        }

        public void setSender(Sender sender) {
            this.sender = sender;
        }

        public String getNameGroup() {
            return nameGroup;
        }

        public void setNameGroup(String nameGroup) {
            this.nameGroup = nameGroup;
        }
    }

    public static class LastMessage {
        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("content")
        @Expose
        private String content;

        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("modified")
        @Expose
        private String modified;
        @SerializedName("user_id")
        @Expose
        private String userId;

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

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }


}
