package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateSchemeAct extends AppCompatActivity {

    EditText schemename1,schemetype1,eligibility1,duration1;
    private Button apply,update,delete;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_scheme);

        SchemeDetails schemeDetails=new SchemeDetails(this);
        schemename1 = (EditText) findViewById(R.id.schemename);
        schemetype1 = (EditText) findViewById(R.id.schemetype);
        eligibility1 = (EditText) findViewById(R.id.eligibility);
        duration1 = (EditText) findViewById(R.id.duration);
        apply = (Button) findViewById(R.id.apply);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        DatabaseHandler DB = new DatabaseHandler(this);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String schemename = schemename1.getText().toString();
                String schemetype = schemetype1.getText().toString();
                String eligibility = eligibility1.getText().toString();
                String duration = duration1.getText().toString();



                if (schemename.equals("") ||schemetype.equals("") || eligibility.equals("") || duration.equals(""))
                    Toast.makeText(CreateSchemeAct.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertScheme(schemename,schemetype,eligibility,duration);
                    if(insert==true){
                        Toast.makeText(CreateSchemeAct.this, "Scheme added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateSchemeAct.this,AdminHomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(CreateSchemeAct.this, "Scheme not added", Toast.LENGTH_SHORT).show();
                    }}
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String schemename=schemename1.getText().toString();
                String schemetype=schemetype1.getText().toString();
                String eligibility=eligibility1.getText().toString();
                String duration=duration1.getText().toString();

                Boolean i=DB.update_data(schemename,schemetype,eligibility,duration);
                if(i==true)
                    Toast.makeText(CreateSchemeAct.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CreateSchemeAct.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String schemename =schemename1.getText().toString();
                Boolean i=DB.delete_data(schemename);
                if(i==true)
                {
                    Toast.makeText(CreateSchemeAct.this, "Scheme deleted successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(CreateSchemeAct.this, "Scheme not deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}