package com.example.studentprofiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListHolder> {

    ArrayList<Student> students;

    StudentListAdapter(ArrayList<Student> students) { this.students = students; }

    public static class StudentListHolder extends RecyclerView.ViewHolder {

        ImageView studentProfile;
        TextView studentName;
        TextView studentClass;
        View holderView;

        public StudentListHolder(@NonNull View itemView) {
            super(itemView);
            studentProfile = itemView.findViewById(R.id.studentProfile);
            studentName = itemView.findViewById(R.id.studentNameLst);
            studentClass = itemView.findViewById(R.id.studentClassLst);
            holderView = itemView;
        }
    }

    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new StudentListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.StudentListHolder holder, int position) {
        holder.studentClass.setText(students.get(position).getClassName());
        holder.studentName.setText(students.get(position).getStudentName());
        holder.studentProfile.setImageResource(students.get(position).getStudentProfileId());

        holder.holderView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(holder.holderView.getContext(), StudentProfileActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("studentName", students.get(position).getStudentName());
                        bundle.putString("studentClass", students.get(position).getClassName());
                        bundle.putInt("studentProfile", students.get(position).getStudentProfileId());
                        bundle.putString("studentAddress", students.get(position).getAddress());
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);
                    }
                }
        );
    }

    @Override
    public int getItemCount() { return students.size(); }
}
