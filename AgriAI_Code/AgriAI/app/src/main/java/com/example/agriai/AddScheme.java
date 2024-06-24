package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddScheme extends AppCompatActivity {

    private Button createscheme,viewscheme;
    DatabaseHandler DB = new DatabaseHandler(this);

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_scheme);

        createscheme=findViewById(R.id.createscheme);
        viewscheme= findViewById(R.id.viewscheme);
        /* deletescheme=findViewById(R.id.deletescheme);
         */

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        createscheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddScheme.this,CreateSchemeAct.class);
                startActivity(intent);
            }
        });

        viewscheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddScheme.this,ViewScheme.class);
                startActivity(intent);
            }
        });

        /*deletescheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String schemename =deletescheme.getText().toString();
                Boolean i=DB.delete_data(schemename);
                if(i==true)
                {
                    Toast.makeText(AdminHomeActivity.this, "Scheme deleted successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AdminHomeActivity.this, "Scheme not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
//        viewdata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(AdminHomeActivity.this,ViewSchemeAct.class);
//                startActivity(intent);
//            }
//        });
    }
}