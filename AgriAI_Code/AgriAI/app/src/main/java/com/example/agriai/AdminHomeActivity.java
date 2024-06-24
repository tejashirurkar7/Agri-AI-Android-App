package com.example.agriai;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class AdminHomeActivity extends AppCompatActivity {


    CardView btnScheme,btnViewFarmer,btnViewFeedback;
    GridLayout grid4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        grid4=findViewById(R.id.grid4);
        btnScheme=findViewById(R.id.btnScheme);
        btnViewFarmer=findViewById(R.id.btnViewFarmer);
        btnViewFeedback=findViewById(R.id.btnViewFeedback);

        grid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnScheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this,AddScheme.class);
                startActivity(intent);
            }
        });

        btnViewFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this,ViewFarmar.class);
                startActivity(intent);
            }
        });

        btnViewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this,ViewFeedback.class);
                startActivity(intent);
            }
        });

    }
}