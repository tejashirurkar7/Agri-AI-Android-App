package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ChartActivity extends AppCompatActivity {

    private Button nashik,sangli,satara,buldhana;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        nashik=(Button) findViewById(R.id.nashik);
        sangli=(Button) findViewById(R.id.sangli);
        satara=(Button) findViewById(R.id.satara);
        buldhana=(Button) findViewById(R.id.buldhana);

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nashik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, PieChartActivity.class);
                startActivity(intent);
            }
        });

        sangli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, SangliPieChartActivity.class);
                startActivity(intent);
            }
        });

        satara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, sataraPieChartActivity.class);
                startActivity(intent);
            }
        });

        buldhana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartActivity.this, buldhanaPieChartActivity.class);
                startActivity(intent);
            }
        });

    }
}