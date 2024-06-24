package com.example.agriai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserProfileDAO {

        private SQLiteDatabase db;
        private DatabaseHandler dbHelper;

        public UserProfileDAO(Context context) {
            dbHelper = new DatabaseHandler(context);
        }

        public void open() throws SQLException {
            db = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        @SuppressLint("Range")
        public FarmerDetails getUserProfileByUsername(String username) {
            FarmerDetails userProfile = null;
            Cursor cursor = db.query(DatabaseHandler.TABLE_USER,
                    new String[]{DatabaseHandler.COLUMN_USER_ID,DatabaseHandler.COLUMN_USER_NAME, DatabaseHandler.COLUMN_USER_EMAIL,DatabaseHandler.COLUMN_USER_DISTRICT,DatabaseHandler.COLUMN_USER_TALUKA,DatabaseHandler.COLUMN_USER_MOBILENO},
                    DatabaseHandler.COLUMN_USER_NAME + "=?",
                    new String[]{username}, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    userProfile = new FarmerDetails();
                    userProfile.setUid(cursor.getInt(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_ID)));
                    userProfile.setUsername(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_NAME)));
                    userProfile.setDistrict(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_DISTRICT)));
                    userProfile.setTaluka(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_TALUKA)));
                    userProfile.setMobileno(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_MOBILENO)));

                    userProfile.setEmail(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COLUMN_USER_EMAIL)));
                    // Populate more profile attributes as needed
                }
                cursor.close();
            }
            return userProfile;
        }

}
