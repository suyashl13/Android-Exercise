package com.example.grablink;

public class AppLink {

    private final String linkName;
    private final String linkURL;

    AppLink(String linkName, String linkURL){
        this.linkName = linkName;
        this.linkURL = linkURL;
    }

    public String getLinkName() {
        return linkName;
    }

    public String getLinkURL() {
        return linkURL;
    }
}
