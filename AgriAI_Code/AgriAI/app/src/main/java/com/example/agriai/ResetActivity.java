package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView username;
    EditText pass,re_pass;
    Button form_btn;
    DatabaseHandler db;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        username=findViewById(R.id.username_reset_text);
        pass=findViewById(R.id.password_reset);
        re_pass=findViewById(R.id.repassword_reset);
        form_btn=findViewById(R.id.form_btn);
        db=new DatabaseHandler(this);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent=getIntent();
        username.setText(intent.getStringExtra("username"));
        form_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String password = pass.getText().toString();
                String repass = re_pass.getText().toString();

                if (password.equals(repass)) {

                    Boolean check_pass_update = db.updatepassword(user, password);
                    if (check_pass_update == true) {
                        Intent intent1 = new Intent(getApplicationContext(), FarmerLoginActivity.class);
                        startActivity(intent1);
                        Toast.makeText(ResetActivity.this, "Password Updated Successfully...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "Password not updated", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ResetActivity.this, "Password not matched...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}