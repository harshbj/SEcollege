package com.example.harsh.secollege;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.support.v4.app.NotificationCompatBase;
import android.view.LayoutInflater;

/**
 * Created by HARSH on 3/27/2018.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "studentDB.db";

    public static final String TABLE_NAME = "Student";

    public static final String COLUMN_ID = "StudentID";

    public static final String COLUMN_NAME = "StudentName";

    //initialize the database
    public MyDBHandler(Context context , String name , SQLiteDatabase.CursorFactory Factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID + "INTEGER PRIMARYKEY," + COLUMN_NAME + "TEXT )";
        db.execSQL(CREATE_TABLE);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }






    public void addHandler(Student student) {
    }

    public Student findHandler(String studentname) {

        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAME + " = " + "'" + studentname + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();

            student.setID(Integer.parseInt(cursor.getString(0)));

            student.setStudentName(cursor.getString(1));

            cursor.close();

        } else {

            student = null;

        }

        db.close();

        return student;
    }

    public boolean deleteHandler(int ID) {

        boolean result = false;

        String query = "Select*FROM" + TABLE_NAME + "WHERE" + COLUMN_ID + "= '" + String.valueOf(ID) + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if (cursor.moveToFirst()) {

            student.setID(Integer.parseInt(cursor.getString(0)));

            db.delete(TABLE_NAME, COLUMN_ID + "=?",

                    new String[] {

                            String.valueOf(student.getID())

                    });

            cursor.close();

            result = true;

        }

        db.close();

        return result;

    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues args = new ContentValues();

        args.put(COLUMN_ID, ID);

        args.put(COLUMN_NAME, name);

        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;

    }


    public String loadHanler() {


        {


            String result = "";

            String query = "Select*FROM" + TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()) {

                int result_0 = cursor.getInt(0);

                String result_1 = cursor.getString(1);

                result += String.valueOf(result_0) + " " + result_1 +

                        System.getProperty("line.separator");

            }

            cursor.close();

            db.close();

            return result;

        }
    }



}
