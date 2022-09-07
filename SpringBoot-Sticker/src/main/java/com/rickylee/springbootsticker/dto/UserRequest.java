package com.rickylee.springbootsticker.dto;

import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull
    private String userName;
    @NotNull
    private String userImageUrl;
    private String userDescription;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
