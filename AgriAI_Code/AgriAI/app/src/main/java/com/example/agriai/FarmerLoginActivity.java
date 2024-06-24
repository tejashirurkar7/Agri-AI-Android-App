package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FarmerLoginActivity extends AppCompatActivity {

    private Button btnsignup1,btnlogin;
    EditText username, password;
    private Button txtsignup1;
    TextView forget_pass;
    ImageView imageview;
    DatabaseHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
       btnlogin = (Button) findViewById(R.id.btnsignin1);
       txtsignup1=(Button) findViewById(R.id.txtsignup);
       forget_pass=findViewById(R.id.forget_btn);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        DatabaseHandler DB = new DatabaseHandler(this);

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FarmerLoginActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });

       txtsignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FarmerLoginActivity.this,FarmerRegisterActivity.class);
                startActivity(intent);
            }
        });
       btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(FarmerLoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass;
                    checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(FarmerLoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), FarmerHomeActivity.class);
                        /*intent.putExtra("key_username",user);*/
                        startActivity(intent);
                        SharedPreferences preferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("user", user);
                        editor.apply();


                    }else{
                        Toast.makeText(FarmerLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}