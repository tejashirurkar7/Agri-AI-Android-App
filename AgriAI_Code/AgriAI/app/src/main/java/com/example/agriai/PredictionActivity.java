package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PredictionActivity extends AppCompatActivity {




    private EditText weatherEditText;
    private EditText soilEditText;
    private EditText monthEditText;
    private Button predictButton;
    private TextView resultTextView;
    private Spinner spinnerDistrict, spinnerTaluka,spinnerWeather;

    String[] districts = {"Select District", "Nashik", "Sangli", "Satara", "Buldhana"};
    String[] talukas = {"Select Taluka", "Niphad", "Tasgaon", "Wai", "Khamgaon"};
    String[] weather = {"Select Weather", "Rainy", "Summer", "Winter"};
    String[] soil = {"Select Soil", "Black Soil", "Alluvial Soil", "Laterite Soil"};
    /*String[] month = {"1", "2", "3", "4","5","6", "7", "8", "9","10","11","12"};*/

    String url=("C:\\Users\\Admin\\AndroidStudioProjects\\AgriAI\\app\\src\\main\\assets\\crop_prediction_model.joblib");

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

       /* spinnerDistrict = findViewById(R.id.districtEditText);
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(districtAdapter);

        spinnerTaluka = findViewById(R.id.talukaEditText);
        ArrayAdapter<String> talukaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, talukas);
        talukaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTaluka.setAdapter(talukaAdapter);
*/

        Spinner citySpinner = findViewById(R.id.citySpinner);
        final Spinner townSpinner = findViewById(R.id.townSpinner);

        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getItemAtPosition(position).toString();
                int townArrayResourceId = getResources().getIdentifier(
                        selectedCity.toLowerCase() + "_towns", "array", getPackageName());

                ArrayAdapter<CharSequence> townAdapter = ArrayAdapter.createFromResource(
                        PredictionActivity.this, townArrayResourceId, android.R.layout.simple_spinner_item);
                townAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                townSpinner.setAdapter(townAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        spinnerWeather = findViewById(R.id.weatherEditText);
        ArrayAdapter<String> weatherAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weather);
        weatherAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeather.setAdapter(weatherAdapter);

        /*weatherEditText = findViewById(R.id.weatherEditText);*/
        soilEditText = findViewById(R.id.soilEditText);
        monthEditText = findViewById(R.id.monthEditText);
        predictButton = findViewById(R.id.predictButton);
        resultTextView = findViewById(R.id.resultTextView);
        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        predictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String district = citySpinner.getSelectedItem().toString();
                String taluka = townSpinner.getSelectedItem().toString();
                String weather = spinnerWeather.getSelectedItem().toString();
               /* String weather = weatherEditText.getText().toString().trim()*/;
                String soil = soilEditText.getText().toString().trim();
                String monthStr = monthEditText.getText().toString().trim();

                if (district.equals("Select District") || taluka.equals("Select Taluka") || weather.equals("Select Wether") || soil.isEmpty() || monthStr.isEmpty()) {
                    Toast.makeText(PredictionActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                int month;
                try {
                    month = Integer.parseInt(monthStr);
                    if (month < 1 || month > 12) {
                        Toast.makeText(PredictionActivity.this, "Month should be between 1 and 12", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(PredictionActivity.this, "Invalid month", Toast.LENGTH_SHORT).show();
                    return;
                }


                // Make a prediction for the new data point
                 String predict = crop_prediction_model(district, taluka, weather, soil, month);

                resultTextView.setText("Predicted Crop: " + predict);
            }
        });
    }



    /*private String predictCrop(String district, String taluka, String weather, String soil, int month) {
        // Check weather conditions
        if (weather.equalsIgnoreCase("Rainy")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 6 && month <= 9) {
                    return "Ridge Gourd";
                } else if (month >= 3 && month <= 5) {
                    return "Cluster Beans";
                } else {
                    return "Cauliflower";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 6 && month <= 9) {
                    return "Brinjal/Eggplant";
                } else {
                    return "Tomato";
                }
            } else {
                if (month >= 6 && month <= 9) {
                    return "Bottle Gourd";
                } else {
                    return "Bitter Gourd";
                }
            }
        } else if (weather.equalsIgnoreCase("Sunny")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 3 && month <= 5) {
                    return "Cluster Beans";
                } else {
                    return "Cucumber";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 3 && month <= 5) {
                    return "Brinjal/Eggplant";
                } else {
                    return "Green Chili";
                }
            } else {
                if (month >= 6 && month <= 9) {
                    return "Bottle Gourd";
                } else {
                    return "Bitter Gourd";
                }
            }
        } else if (weather.equalsIgnoreCase("Winter")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 3 && month <= 5) {
                    return "Coriander";
                } else {
                    return "Spinach";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 6 && month <= 9) {
                    return "Onion";
                } else {
                    return "Fenugreek";
                }
            } else {
                if (month >= 6 && month <= 9) {
                    return "Cabbage";
                } else {
                    return "Peas";
                }
            }
        }

        // Default prediction
        return "Potato";
    }
*/
    private String crop_prediction_model(String district, String taluka, String weather, String soil, int month) {
        // Check weather conditions
        if (weather.equalsIgnoreCase("Rainy")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 6 && month <= 9) {
                    return "Ridge Gourd";
                } else if (month >= 3 && month <= 5) {
                    return "Cluster Beans";
                } else {
                    return "Cauliflower";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 6 && month <= 9) {
                    return "Brinjal/Eggplant";
                } else {
                    return "Tomato";
                }
            } else if (soil.equalsIgnoreCase("Alluvial Soil")) {
                if (month >= 6 && month <= 9) {
                    return "Bottle Gourd";
                } else {
                    return "Bitter Gourd";
                }
            } else if (soil.equalsIgnoreCase("Laterite Soil")) {
                if (month >= 3 && month <= 5) {
                    return "Ladyfinger";
                } else {
                    return "Cucumber";
                }
            }
        } else if (weather.equalsIgnoreCase("Sunny")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 3 && month <= 5) {
                    return "Cluster Beans";
                } else {
                    return "Cucumber";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 3 && month <= 5) {
                    return "Brinjal/Eggplant";
                } else {
                    return "Green Chili";
                }
            } else if (soil.equalsIgnoreCase("Alluvial Soil")) {
                if (month >= 6 && month <= 9) {
                    return "Bottle Gourd";
                } else {
                    return "Bitter Gourd";
                }
            } else if (soil.equalsIgnoreCase("Laterite Soil")) {
                if (month >= 3 && month <= 5) {
                    return "Ladyfinger";
                } else {
                    return "Cucumber";
                }
            }
        } else if (weather.equalsIgnoreCase("Winter")) {
            if (soil.equalsIgnoreCase("Black soil")) {
                if (month >= 3 && month <= 5) {
                    return "Coriander";
                } else {
                    return "Spinach";
                }
            } else if (soil.equalsIgnoreCase("Red soil")) {
                if (month >= 6 && month <= 9) {
                    return "Onion";
                } else {
                    return "Fenugreek";
                }
            } else if (soil.equalsIgnoreCase("Alluvial Soil")) {
                if (month >= 6 && month <= 9) {
                    return "Cabbage";
                } else {
                    return "Peas";
                }
            } else if (soil.equalsIgnoreCase("Laterite Soil")) {
                if (month >= 3 && month <= 5) {
                    return "Carrot";
                } else {
                    return "Radish";
                }
            }
        }

        // Default prediction
        return "Wrong Soil Input";
    }


}
