package com.example.agriai;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agrofarm.db";

    public static final String TABLE_USER="tbluser";
    public static final String COLUMN_USER_ID="uid";
    public  static final String COLUMN_USER_NAME="username";
    public  static final String COLUMN_USER_DISTRICT="district";
    public  static final String COLUMN_USER_TALUKA="taluka";
    public  static final String COLUMN_USER_MOBILENO="mobileno";
    public static final String COLUMN_USER_EMAIL="email";
    public static final String COLUMN_USER_PASSWORD="password";
    public  static final String COLUMN_USER_CPASSWORD="cpassword";


    public static final String TABLE_SCHEME="tblscheme";
    public static final String COLUMN_SCHEME_ID="sid";
    public  static final String COLUMN_SCHEME_NAME="schemename";
    public static final String COLUMN_SCHEME_TYPE="schemetype";
    public static final String COLUMN_SCHEME_ELIGIBILITY="eligibility";
    public  static final String COLUMN_SCHEME_DURATION="duration";


    public static final String TABLE_FEEDBACK="tblfeedback";
    public static final String COLUMN_FEEDBACK_ID="id";
    public  static final String COLUMN_FEEDBACK_USERNAME="username";
    public static final String COLUMN_FEEDBACK_EMAIL="email";
    public static final String COLUMN_FEEDBACK_FEEDBACK="feedback";
    public static final String CREATE_TABLE_USER="CREATE TABLE "+TABLE_USER+"("
            +COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_USER_NAME+" TEXT, "
            +COLUMN_USER_DISTRICT+" TEXT, "
            +COLUMN_USER_TALUKA+" TEXT, "
            +COLUMN_USER_MOBILENO+" TEXT, "
            +COLUMN_USER_EMAIL+" TEXT, "
            +COLUMN_USER_PASSWORD+" TEXT, "
            +COLUMN_USER_CPASSWORD+" TEXT);";

    public static final String CREATE_TABLE_SCHEME="CREATE TABLE "+TABLE_SCHEME+"("
            +COLUMN_SCHEME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_SCHEME_NAME+" TEXT, "
            +COLUMN_SCHEME_TYPE+" TEXT, "
            +COLUMN_SCHEME_ELIGIBILITY+" TEXT, "
            +COLUMN_SCHEME_DURATION+" TEXT);";

    public static final String CREATE_TABLE_FEEDBACK="CREATE TABLE "+TABLE_FEEDBACK+"("
            +COLUMN_FEEDBACK_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_FEEDBACK_USERNAME+" TEXT, "
            +COLUMN_FEEDBACK_EMAIL+" TEXT, "
            +COLUMN_FEEDBACK_FEEDBACK+" TEXT);";
    public static final int DATABASE_VERSION=1;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_SCHEME);
        db.execSQL(CREATE_TABLE_FEEDBACK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FEEDBACK);
    }


    public Boolean insertData(String username,String district,String taluka,String mobileno, String email, String password,String cpassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("district", district);
        contentValues.put("taluka", taluka);
        contentValues.put("mobileno", mobileno);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("cpassword", cpassword);
        long result = MyDB.insert("tbluser", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean updatepassword(String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("tbluser", contentValues, "username=?", new String[]{username});
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String user) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tbluser where username = ?", new String[]{user});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String user, String pass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tbluser where username = ? and password = ?", new String[] {user,pass});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


   public ArrayList<FarmerDetails> readFarmer() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_USER, null);

        // on below line we are creating a new array list.
        ArrayList<FarmerDetails> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new FarmerDetails(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public ArrayList<SchemeDetails> readScheme() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_SCHEME, null);

        // on below line we are creating a new array list.
        ArrayList<SchemeDetails> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new SchemeDetails(cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public Boolean insertScheme(String schemename, String schemetype, String eligibility, String duration) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("schemename", schemename);
        contentValues.put("schemetype", schemetype);
        contentValues.put("eligibility", eligibility);
        contentValues.put("duration", duration);
        long result = MyDB.insert("tblscheme", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean update_data(String schemename, String schemetype, String eligibility, String duration) {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put("schemetype",schemetype);
        c.put("eligibility",eligibility);
        c.put("duration",duration);

        Cursor cursor=MyDB.rawQuery("select * from tblscheme where schemename=?",new String[]{schemename});
        if(cursor.getCount()>0){
            long r=MyDB.update("tblscheme",c,"schemename=?",new String[]{schemename});
            if(r==-1) return false;
            else
                return true;
        }
        else
            return false;

    }

    public boolean delete_data(String schemename)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * from tblscheme where schemename=?",new String[]{schemename});
        if(cursor.getCount()>0){
            long r=MyDB.delete("tblscheme","schemename=?",new String[]{schemename});
            if(r==-1) return false;
            else
                return true;
        }
        else
            return false;

    }

    public Boolean insertFeedbackData(String username, String email, String feedback){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("feedback", feedback);
        long result = MyDB.insert("tblfeedback", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }


   public ArrayList<FeedbackDetails> readFeedback() {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_FEEDBACK, null);

        // on below line we are creating a new array list.
        ArrayList<FeedbackDetails> feedbackModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                feedbackModalArrayList.add(new FeedbackDetails(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return feedbackModalArrayList;
    }

   /* public List<FarmerDetails> getAllProfiles() {
        List<FarmerDetails> profileList = new ArrayList<>();
        String selectQuery = "SELECT * FROM tbluser";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FarmerDetails profile = new FarmerDetails();
                profile.setUid(cursor.getInt(0));
                profile.setUsername(cursor.getString(1));
                profile.setEmail(cursor.getString(2));
                profile.setDistrict(cursor.getString(3));
                profile.setTaluka(cursor.getString(4));
                profile.setMobileno(cursor.getString(5));
                profileList.add(profile);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return profileList;
    }*/


   /* @SuppressLint("Range")
    public FarmerDetails getProfileById(int uid) {
        FarmerDetails profile = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("tbluser", null, "uid=?", new String[]{String.valueOf(uid)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            profile = new FarmerDetails();
           *//* profile.setUid(cursor.getInt(cursor.getColumnIndex("uid")));*//*
            profile.setUsername(cursor.getString(cursor.getColumnIndex("username")));
            profile.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            profile.setDistrict(cursor.getString(cursor.getColumnIndex("district")));
            profile.setTaluka(cursor.getString(cursor.getColumnIndex("taluka")));
            profile.setMobileno(cursor.getString(cursor.getColumnIndex("mobileno")));
            cursor.close();
        }
        db.close();
        return profile;
    }*/

    public ArrayList<FarmerDetails> getLoggedinUserDetails(String user){

        ArrayList<FarmerDetails> al=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String query="SELECT * FROM tbluser WHERE username='"+user+"'";
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            String username=cursor.getString(1);
            String district=cursor.getString(2);
            String taluka=cursor.getString(3);
            String mobileno=cursor.getString(4);
            String email=cursor.getString(5);

            FarmerDetails farmerDetails=new FarmerDetails();
            farmerDetails.setUsername(username);
            farmerDetails.setDistrict(district);
            farmerDetails.setTaluka(taluka);
            farmerDetails.setMobileno(mobileno);
            farmerDetails.setEmail(email);

            al.add(farmerDetails);

        }
        return al;
    }



}

