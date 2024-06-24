package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewScheme extends AppCompatActivity {

    private ArrayList<SchemeDetails> schemeModalArrayList;
    private DatabaseHandler dbHandler;
    private SchemeRVAdapter schemeRVAdapter;
    private RecyclerView schemeRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scheme);

        schemeModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(ViewScheme.this);

        // getting our course array
        // list from db handler class.
        schemeModalArrayList = dbHandler.readScheme();

        // on below line passing our array lost to our adapter class.
        schemeRVAdapter = new SchemeRVAdapter(schemeModalArrayList, ViewScheme.this);
        schemeRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewScheme.this, RecyclerView.VERTICAL, false);
        schemeRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        schemeRV.setAdapter(schemeRVAdapter);

        /*applyscheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });

        applyscheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });

        applyscheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });
*/
        /*applyscheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });
*/
    }
}