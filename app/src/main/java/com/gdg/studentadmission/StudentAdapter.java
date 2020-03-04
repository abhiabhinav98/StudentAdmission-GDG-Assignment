package com.gdg.studentadmission;

import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.FeedBackViewHolder>{

    ArrayList<Student> studList;
    Context context;

    public StudentAdapter(ArrayList<Student> studentList){

        studList = studentList;
        Student s = new Student("Abhinav", "abhi@gmail.com", "1998-12-03", "Male", "Computer Science", "9009872242", 90, 90);
        studList.add(s);
    }

    class FeedBackViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, dob, gender, branch, number, per12, per10;
        public FeedBackViewHolder(View item){
            super(item);
            name = (TextView)item.findViewById(R.id.nameTV);
            email = (TextView)item.findViewById(R.id.emailTV);
            dob = (TextView)item.findViewById(R.id.dobTV);
            gender = (TextView)item.findViewById(R.id.genderTV);
            branch = (TextView)item.findViewById(R.id.branchTV);
            number = (TextView)item.findViewById(R.id.numberTV);
            per12 = (TextView)item.findViewById(R.id.perc12TV);
            per10 = (TextView)item.findViewById(R.id.perc10TV);
        }

    }

    @Override
    public StudentAdapter.FeedBackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
        return new FeedBackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.FeedBackViewHolder holder, int position) {
        Student s = studList.get(position);
        holder.name.setText("Name: "+s.name);
        holder.email.setText("Email: "+s.email);
        holder.dob.setText("DOB: "+s.dob);
        holder.gender.setText("Gender: "+s.gender);
        holder.branch.setText("Branch: "+s.branch);
        holder.number.setText("Contact: "+s.number);
        holder.per12.setText(String.valueOf("12th: "+s.perc12));
        holder.per10.setText(String.valueOf("10th: "+s.perc10));
    }

    @Override
    public int getItemCount() {
        return studList.size();
    }
}
