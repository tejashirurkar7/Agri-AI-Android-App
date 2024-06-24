package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity {

    EditText user_name;
    Button reset_btn;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        user_name=findViewById(R.id.user_name_frg);
        reset_btn=findViewById(R.id.reset_btn);
        db=new DatabaseHandler(this);

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=user_name.getText().toString();
                Boolean checkuser=db.checkusername(user);
                if(checkuser=true)
                {
                    Intent intent= new Intent(getApplicationContext(),ResetActivity.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgetActivity.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}