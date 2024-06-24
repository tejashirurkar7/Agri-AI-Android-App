package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddFeedback extends AppCompatActivity {

    EditText username, email, feedback;
    private Button btnfeedback;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        feedback = (EditText) findViewById(R.id.feedback);
        btnfeedback = (Button) findViewById(R.id.btnfeedback);
        DatabaseHandler DB = new DatabaseHandler(this);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String email1 = email.getText().toString();
                String feedbk = feedback.getText().toString();

                if (user.equals("") ||email1.equals("") || feedbk.equals(""))
                    Toast.makeText(AddFeedback.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertFeedbackData(user,email1, feedbk);
                    if(insert==true){
                        Toast.makeText(AddFeedback.this, "Feedback submitted successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddFeedback.this,FarmerHomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(AddFeedback.this, "Feedback not submitted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    }
