package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    TextView profilename, profilemobileno, profiletaluka, profileemail, profiledistrict;
    String user;
    ImageView imageview;
    private UserProfileDAO userProfileDAO;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
        String loggedInUsername = preferences.getString("user", null);
        /*String loggedInUsername = "Anu";*/

        if (loggedInUsername != null) {
            userProfileDAO = new UserProfileDAO(this);
            userProfileDAO.open();

            profilename = findViewById(R.id.profilename);
            profilemobileno = findViewById(R.id.profilemobileno);
            profiletaluka = findViewById(R.id.profiletaluka);
            profileemail = findViewById(R.id.profileemail);
            profiledistrict = findViewById(R.id.profiledistrict);

            // Fetch profile data for the logged-in user
            FarmerDetails userProfile = userProfileDAO.getUserProfileByUsername(loggedInUsername);

            // Display profile data in TextViews
            if (userProfile != null) {
                profilename.setText("Name: " + userProfile.getUsername());
                profilemobileno.setText("Mobileno: " + userProfile.getMobileno());
                profiletaluka.setText("Taluka: " + userProfile.getTaluka());
                profileemail.setText("Email: " + userProfile.getEmail());
                profiledistrict.setText("District: " + userProfile.getDistrict());
                // Populate more TextViews with other profile attributes
            } else {
                // Handle case where user profile is not found
            }

            // Close database connection
            userProfileDAO.close();
        }
    }
}

        /*profilename = findViewById(R.id.profilename);
        profilemobileno = findViewById(R.id.profilemobileno);
        profiletaluka = findViewById(R.id.profiletaluka);
        profileemail = findViewById(R.id.profileemail);
        profiledistrict = findViewById(R.id.profiledistrict);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        user=getIntent().getStringExtra("key_username");
        getUserDetails();
    }

    public void getUserDetails(){
        DatabaseHandler databaseHandler=new DatabaseHandler(this);
        ArrayList<FarmerDetails> al=databaseHandler.getLoggedinUserDetails(user);
        FarmerDetails farmerDetails=al.get(0);

        profilename.setText(farmerDetails.getUsername());
        profiledistrict.setText(farmerDetails.getDistrict());
        profiletaluka.setText(farmerDetails.getTaluka());
        profilemobileno.setText(farmerDetails.getMobileno());
        profileemail.setText(farmerDetails.getEmail());

    }*/

   /* public void logoutUser(View view){
        startActivity(new Intent(ProfileActivity.this,FarmerLoginActivity.class));
    }
*/


