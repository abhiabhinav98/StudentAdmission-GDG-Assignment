package com.gdg.studentadmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class viewStudent extends AppCompatActivity {

    ArrayList<Student> slist;
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;
    SharedPreferences preferences;
    DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        slist = new ArrayList<Student>();
        slist = dbHelper.getAllStudents();

        studentAdapter = new StudentAdapter(slist);
        recyclerView = (RecyclerView)findViewById(R.id.feedbackRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();

    }

    public  void setGlist(ArrayList<Student> gFList){
        slist=gFList;
    }

}
