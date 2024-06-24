package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class SangliPieChartActivity extends AppCompatActivity {

    TextView tvR, tvPython, tvCPP, tvJava,tvVeg1,tvVeg2,tvVeg3;
    PieChart pieChart;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sangli_pie_chart);

        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);

        tvVeg1 = findViewById(R.id.tvVeg1);
        tvVeg2 = findViewById(R.id.tvVeg2);
        tvVeg3 = findViewById(R.id.tvVeg3);


        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();
    }

    private void setData()
    {

        // Set the percentage of language used
        tvR.setText(Integer.toString(99));
        tvPython.setText(Integer.toString(92));
        tvCPP.setText(Integer.toString(80));
        tvJava.setText(Integer.toString(80));

        tvVeg1.setText(Integer.toString(78));
        tvVeg2.setText(Integer.toString(77));
        tvVeg3.setText(Integer.toString(76));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "R",
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "C++",
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#A020F0")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#000080")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#900C3F")));

        // To animate the pie chart
        pieChart.startAnimation();
    }

}