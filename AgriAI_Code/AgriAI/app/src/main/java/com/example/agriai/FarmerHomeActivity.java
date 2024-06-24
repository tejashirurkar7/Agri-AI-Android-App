package com.example.agriai;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class FarmerHomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView imgWeather1;
    TextView txtweather1,textView8,textView13,textView10;
    CardView cardweather;

    RelativeLayout relareawisecrop;
    ImageView imageview4,imageview6,imageView;
    GridLayout grid4,grid3,grid2,grid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_home);

       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


        imageview4=findViewById(R.id.imageview4);
        imageview6=findViewById(R.id.imageview6);
        txtweather1=findViewById(R.id.textView12);
        textView8=findViewById(R.id.textView8);
        textView13=findViewById(R.id.textView13);
        relareawisecrop=findViewById(R.id.relareawisecrop);
        textView10=findViewById(R.id.textView10);

        grid4=findViewById(R.id.grid4);
        grid3=findViewById(R.id.grid3);
        grid2=findViewById(R.id.grid2);
        /*grid1=findViewById(R.id.grid1);*/

        /*grid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, FarmerHomeActivity.class);
                startActivity(intent);

            }
        });*/
        grid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, FarmerHomeActivity.class);
                startActivity(intent);

            }
        });
        grid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
        grid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        /*imageView=(ImageView) findViewById(R.id.imageView);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });*/

       /* textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });*/
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, FAQActivity.class);
                startActivity(intent);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, PredictionActivity.class);
                startActivity(intent);
            }
        });
        imageview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, ViewScheme1.class);
                startActivity(intent);
            }
        });

        txtweather1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, WeatherForcast.class);
                startActivity(intent);
            }
        });
        imageview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FarmerHomeActivity.this, AddFeedback.class);
                startActivity(intent);
            }
        });
      /*  drawerLayout = findViewById(R.id.drawerlayout);*/
       /* navigationView = findViewById(R.id.navigationview);*/
       /* toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/




    }



}
