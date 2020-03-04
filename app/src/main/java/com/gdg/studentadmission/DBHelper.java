package com.gdg.studentadmission;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    static String DB_Name = "student.db";
    static int DB_Version = 1;

    public static String Table_Name = "students";
    public static String ID_COL = "ID";
    public static String NAME_COL = "Name";
    public static String EMAIL_COL = "Email";
    public static String DOB_COL = "DOB";
    public static String GENDER_COL = "Gender";
    public static String MOBILE_COL = "Contact";
    public static String BRANCH_COL = "Branch";
    public static String HS_COL = "HighSchool";
    public static String SS_COL = "SeniorSchool";

    public static String query = "create table "+Table_Name+"("+ID_COL+" integer primary key autoincrement, "+NAME_COL+" text, "+EMAIL_COL+" text, "+DOB_COL+" text, "+GENDER_COL+" text,"+BRANCH_COL+" text, "+MOBILE_COL+" text, "+HS_COL+" real, "+SS_COL+" real )";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_Name, null, DB_Version);
    }

    public DBHelper(@Nullable Context context){
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertStudent(Student s){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(NAME_COL, s.name);
            cv.put(EMAIL_COL, s.email);
            cv.put(DOB_COL, s.dob);
            cv.put(GENDER_COL, s.gender);
            cv.put(BRANCH_COL, s.branch);
            cv.put(MOBILE_COL, s.number);
            cv.put(HS_COL, s.perc12);
            cv.put(SS_COL, s.perc10);
            db.insert(Table_Name, null, cv);
        }catch (Exception ex){
            Log.e("ERROR", ex.toString());
            return false;
        }
        return true;
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> list = new ArrayList<Student>();
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery("Select * from "+ Table_Name, null);
            while(c.moveToNext()){
                String name = c.getString(c.getColumnIndex(NAME_COL));
                String email = c.getString(c.getColumnIndex(EMAIL_COL));
                String dob = c.getString(c.getColumnIndex(DOB_COL));
                String gender = c.getString(c.getColumnIndex(GENDER_COL));
                String branch = c.getString(c.getColumnIndex(BRANCH_COL));
                String mob = c.getString(c.getColumnIndex(MOBILE_COL));
                float hs = c.getFloat(c.getColumnIndex(HS_COL));
                float ss = c.getFloat(c.getColumnIndex(SS_COL));
                Student s = new Student(name,email, dob,gender, branch, mob, hs, ss);
                list.add(s);
            }

        }catch (Exception e){
            Log.e("ERROR", e.toString());
        }
        return list;

    }


}
