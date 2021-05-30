package com.example.studentprofiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentProfileActivity extends AppCompatActivity {

    ImageView studentProfile;
    TextView studentName, studentClass, studentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Intent intent = getIntent();

        studentName = findViewById(R.id.studentNamePrf);
        studentClass = findViewById(R.id.studentClassPrf);
        studentProfile = findViewById(R.id.studentProfilePrf);
        studentAddress = findViewById(R.id.studentAddressPrf);

        studentName.setText(intent.getExtras().get("studentName").toString());
        studentClass.setText(intent.getExtras().get("studentClass").toString());
        studentProfile.setImageResource(Integer.parseInt(intent.getExtras().get("studentProfile").toString()));
        studentAddress.setText(intent.getExtras().get("studentAddress").toString());

    }
}