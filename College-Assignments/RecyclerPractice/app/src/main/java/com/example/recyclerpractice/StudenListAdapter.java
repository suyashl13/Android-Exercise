package com.example.recyclerpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudenListAdapter extends RecyclerView.Adapter<StudenListAdapter.StudentListHolder> {

    ArrayList<Student> students;

    StudenListAdapter(ArrayList<Student> students){
        System.out.println(students.size());
        this.students = students;
    }


    public static class StudentListHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView studentName;
        TextView studentStandard;
        public StudentListHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.studentProfile);
            studentName = itemView.findViewById(R.id.studentName);
            studentStandard = itemView.findViewById(R.id.studentStandard);
        }
    }

    @NonNull
    @Override
    public StudentListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new StudentListHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudenListAdapter.StudentListHolder holder, int position) {
        holder.imageView.setImageResource(students.get(position).getImageViewId());
        holder.studentName.setText(students.get(position).getStudentName());
        holder.studentStandard.setText(students.get(position).getStudentStandard());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
