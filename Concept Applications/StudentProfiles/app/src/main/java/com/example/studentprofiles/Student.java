package com.example.studentprofiles;

public class Student {

    private final String studentName;
    private final int studentProfileId;
    private final String studentClass;
    private final String address;

    Student(String studentName, int studentProfileId, String studentClass, String address) {
        this.studentName = studentName;
        this.studentProfileId = studentProfileId;
        this.studentClass = studentClass;
        this.address = address;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentProfileId() {
        return studentProfileId;
    }

    public String getAddress() {
        return address;
    }

    public String getClassName() {
        return studentClass;
    }
}
