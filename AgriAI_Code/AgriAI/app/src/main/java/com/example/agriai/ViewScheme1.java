package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewScheme1 extends AppCompatActivity {

    private ArrayList<SchemeDetails> schemeModalArrayList;
    private DatabaseHandler dbHandler;
    private SchemeRVAdapter schemeRVAdapter;
    private RecyclerView schemeRV;
    private Button link,link1,link2,link3;
    private Button applyscheme1,applyscheme2,applyscheme3,applyscheme4,applyscheme5,applyscheme6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scheme1);

        link =(Button) findViewById(R.id.link);
        link1=(Button) findViewById(R.id.link1);
        link2=(Button) findViewById(R.id.link2);
        link3=(Button) findViewById(R.id.link3);
        applyscheme1=findViewById(R.id.applyscheme);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pmksy.gov.in/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://pmfby.gov.in/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://vikaspedia.in/schemesall/schemes-for-farmers/crop-insurance-schemes"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://vikaspedia.in/schemesall/schemes-for-farmers/pm-kisan-maan-dhan-yojana"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

       /* applyscheme1 = (Button) findViewById(R.id.applyscheme);
        applyscheme2 = (Button) findViewById(R.id.applyscheme1);
        applyscheme3 = (Button) findViewById(R.id.applyscheme2);
        applyscheme4 = (Button) findViewById(R.id.applyscheme3);
        applyscheme5 = (Button) findViewById(R.id.applyscheme4);
        applyscheme6 = (Button) findViewById(R.id.applyscheme5);*/
        schemeModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(ViewScheme1.this);

        // getting our course array
        // list from db handler class.
        schemeModalArrayList = dbHandler.readScheme();

        // on below line passing our array lost to our adapter class.
        schemeRVAdapter = new SchemeRVAdapter(schemeModalArrayList, ViewScheme1.this);
        schemeRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewScheme1.this, RecyclerView.VERTICAL, false);
        schemeRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        schemeRV.setAdapter(schemeRVAdapter);

        applyscheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme1.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme1.this, FarmerHomeActivity.class);
                startActivity(intent);

            }
        });

      /*  applyscheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme1.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme1.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });

        applyscheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme1.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme1.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });

        applyscheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme1.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme1.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });
        applyscheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme1.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme1.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });*/
    }
}