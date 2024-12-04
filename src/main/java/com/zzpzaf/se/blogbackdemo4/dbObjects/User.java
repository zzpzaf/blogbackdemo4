package com.zzpzaf.se.blogbackdemo4.dbObjects;

import java.sql.Timestamp;

public class User {
    
    private int userId;
    private String userSlugName;
    private String userName;
    private String userSurname;
    private String userPassword;
    private String userEmail;
    private boolean userIsAuthor;
    private boolean userIsEnabled;
    private int userStatusId;
    private String userUUID;
    private Timestamp userCreationTimestamp;
    private String userClientUUID;

    // Constructors
    public User() {}

    public User(int userId, String userSlugName, String userName, String userSurname, String userPassword,
                String userEmail, boolean userIsAuthor, boolean userIsEnabled, int userStatusId, String userUUID,
                Timestamp userCreationTimestamp, String userClientUUID) {
        this.userId = userId;
        this.userSlugName = userSlugName;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userIsAuthor = userIsAuthor;
        this.userIsEnabled = userIsEnabled;
        this.userStatusId = userStatusId;
        this.userUUID = userUUID;
        this.userCreationTimestamp = userCreationTimestamp;
        this.userClientUUID = userClientUUID;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserSlugName() {
        return userSlugName;
    }

    public void setUserSlugName(String userSlugName) {
        this.userSlugName = userSlugName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isUserIsAuthor() {
        return userIsAuthor;
    }

    public void setUserIsAuthor(boolean userIsAuthor) {
        this.userIsAuthor = userIsAuthor;
    }

    public boolean isUserIsEnabled() {
        return userIsEnabled;
    }

    public void setUserIsEnabled(boolean userIsEnabled) {
        this.userIsEnabled = userIsEnabled;
    }

    public int getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(int userStatusId) {
        this.userStatusId = userStatusId;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public Timestamp getUserCreationTimestamp() {
        return userCreationTimestamp;
    }

    public void setUserCreationTimestamp(Timestamp userCreationTimestamp) {
        this.userCreationTimestamp = userCreationTimestamp;
    }

    public String getUserClientUUID() {
        return userClientUUID;
    }

    public void setUserClientUUID(String userClientUUID) {
        this.userClientUUID = userClientUUID;
    }

    // Optional: Override toString for easy debugging
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userSlugName='" + userSlugName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userIsAuthor=" + userIsAuthor +
                ", userIsEnabled=" + userIsEnabled +
                ", userStatusId=" + userStatusId +
                ", userUUID='" + userUUID + '\'' +
                ", userCreationTimestamp=" + userCreationTimestamp +
                ", userClientUUID='" + userClientUUID + '\'' +
                '}';
    }
}
