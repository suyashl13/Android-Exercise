package com.example.recyclerpractice;

public class Student {
    private int imageViewId;
    private String studentName;
    private String studentStandard;

    Student(int imageViewId, String studentName, String studentStandard){
        this.imageViewId = imageViewId;
        this.studentName = studentName;
        this.studentStandard = studentStandard;
    }

    public int getImageViewId() {
        return imageViewId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentStandard() {
        return studentStandard;
    }
}
