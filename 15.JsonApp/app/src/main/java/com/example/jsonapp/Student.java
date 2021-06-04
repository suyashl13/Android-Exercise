package com.example.jsonapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {

    private String name, email;
    private int courseCount;
    private Course course;

    @SerializedName("video")
    private List<Video> videos;

    public Student(String name, String email, int courseCount, Course course,List<Video> videos) {
        this.name = name;
        this.email = email;
        this.courseCount = courseCount;
        this.course = course;
        this.videos = videos;
    }
}
