package com.gdg.studentadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class addStudent extends AppCompatActivity {

    Button submit;
    EditText nameEdt, emailEdt, dobEdt, perc12, perc10, number;
    RadioGroup rg;
    RadioButton malerb, femalerb, otherrb;
    Spinner branchspn;
    DBHelper dbHelper = null;
    SharedPreferences mypref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        nameEdt = (EditText)findViewById(R.id.studName);
        emailEdt = (EditText)findViewById(R.id.studEmail);
        dobEdt = (EditText)findViewById(R.id.studDOB);
        perc12 = (EditText)findViewById(R.id.perc12);
        perc10 = (EditText)findViewById(R.id.perc10);
        number = (EditText)findViewById(R.id.mob);
        branchspn = (Spinner)findViewById(R.id.branchSpn);
        malerb = (RadioButton)findViewById(R.id.maleRB);
        femalerb = (RadioButton)findViewById(R.id.femaleRB);
        otherrb = (RadioButton)findViewById(R.id.otherRB);
        submit = (Button)findViewById(R.id.subBtn);

        dbHelper = new DBHelper(this);
        mypref = getSharedPreferences("settings", MODE_PRIVATE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String dob = dobEdt.getText().toString();
                Float per12 = Float.parseFloat(perc12.getText().toString());
                Float per10 = Float.parseFloat(perc10.getText().toString());
                String branch = branchspn.getSelectedItem().toString();
                String mob = number.getText().toString();
                String gender = null;
                if(malerb.isChecked()){
                    gender = "Male";
                }
                else if(femalerb.isChecked()){
                    gender = "Female";
                }
                else{
                    gender = "Other";
                }
                Student s = new Student(name, email, dob, gender, branch, mob, per12, per10);
                if(dbHelper.insertStudent(s)){
                    Toast.makeText(addStudent.this, "inserted successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(addStudent.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
