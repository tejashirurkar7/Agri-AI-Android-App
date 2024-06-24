package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class FarmerRegisterActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");
    EditText username,mobileno,email, password, cpassword;
    Spinner spinner,spinner1;
    String[] district={"Select District","Nashik","Sangli","Satara","Buldhana"};
    String[] taluka={"Select Taluka","Niphad","Tasgaon","Wai","Khamgaon"};
    private Button btnsignin,signup;

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_register);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        spinner=findViewById(R.id.spiiner);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>((Context) FarmerRegisterActivity.this, android.R.layout.simple_spinner_item, district);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(FarmerRegisterActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1=findViewById(R.id.spiiiner);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>((Context) FarmerRegisterActivity.this, android.R.layout.simple_spinner_item, taluka);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value1=parent.getItemAtPosition(position).toString();
                Toast.makeText(FarmerRegisterActivity.this, value1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        username = (EditText) findViewById(R.id.username);
        /* district = (EditText) findViewById(R.id.district);*/

        mobileno = (EditText) findViewById(R.id.mobileno);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        signup = (Button) findViewById(R.id.btnsignup);
        btnsignin= (Button) findViewById(R.id.btnsignin);
        DatabaseHandler DB = new DatabaseHandler(this);



        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FarmerRegisterActivity.this,FarmerLoginActivity.class);
                startActivity(intent);
            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String dist = spinner.getSelectedItem().toString();
                String tel = spinner1.getSelectedItem().toString();
               /* String dist = spinner.getItemAtPosition(value).toString();
                String tel = taluka.getText().toString();*/
                String mbno = mobileno.getText().toString();
                String email1 = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = cpassword.getText().toString();

                if (user.equals("") ||dist.equals("") ||tel.equals("") ||mbno.equals("") ||email1.equals("") || pass.equals("") || cpass.equals(""))
                    Toast.makeText(FarmerRegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(cpass)){
                        if (isValidEmail(email1)) {
                            if (isValidPassword(pass)) {
                                Boolean checkuser = DB.checkusername(user);
                                if(checkuser==false){
                                    Boolean insert = DB.insertData(user,dist,tel,mbno,email1, pass,cpass);
                                    if(insert==true){
                                        Toast.makeText(FarmerRegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(FarmerRegisterActivity.this,FarmerLoginActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(FarmerRegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else{
                                    Toast.makeText(FarmerRegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(FarmerRegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }



        });

    }

    /*****************Validations Start****************/


   /* private boolean validateUsername() {
        String usernameInput = email.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            email.setError("Username too long");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getEditableText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }*/

    /*****************Validations End****************/


    private boolean isValidPassword(String pass) {
        return password.length() >= 6 && containsLettersAndNumbers(String.valueOf(password));
    }
    private boolean containsLettersAndNumbers(String password) {
        return password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*");
    }

    private boolean isValidEmail(String email1) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches();

    }



}