package com.example.singletonapi;

public class RandomUser {

    private String fullName;
    private String email;
    private String profilePicture;

    public RandomUser(String fullName, String email, String profilePicture) {
        this.fullName = fullName;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
