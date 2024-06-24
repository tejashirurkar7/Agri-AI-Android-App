package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewFeedback extends AppCompatActivity {

    private ArrayList<FeedbackDetails> feedbackModalArrayList;
    private DatabaseHandler dbHandler;
    private FeedbackRVAdapter feedbackRVAdapter;
    private RecyclerView feedbackRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedback);

        feedbackModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(ViewFeedback.this);

        // getting our course array
        // list from db handler class.
        feedbackModalArrayList = dbHandler.readFeedback();

        // on below line passing our array lost to our adapter class.
        feedbackRVAdapter = new FeedbackRVAdapter(feedbackModalArrayList, ViewFeedback.this);
        feedbackRV = findViewById(R.id.idRVCoursess);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewFeedback.this, RecyclerView.VERTICAL, false);
        feedbackRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        feedbackRV.setAdapter(feedbackRVAdapter);

    }
}
