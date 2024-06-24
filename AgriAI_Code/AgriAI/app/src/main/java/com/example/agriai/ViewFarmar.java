package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewFarmar extends AppCompatActivity {

    private ArrayList<FarmerDetails> farmarModalArrayList;
    private DatabaseHandler dbHandler;
    private FarmerRVAdapter farmerRVAdapter;
    private RecyclerView schemeRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_farmar);

        farmarModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(ViewFarmar.this);

        // getting our course array
        // list from db handler class.
        farmarModalArrayList = dbHandler.readFarmer();

        // on below line passing our array lost to our adapter class.
        farmerRVAdapter = new FarmerRVAdapter(farmarModalArrayList, ViewFarmar.this);
        schemeRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewFarmar.this, RecyclerView.VERTICAL, false);
        schemeRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        schemeRV.setAdapter(farmerRVAdapter);

    }
}