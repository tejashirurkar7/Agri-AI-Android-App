package com.example.agriai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FAQActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FAQAdapter faqAdapter;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqactivity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imageview=findViewById(R.id.imageview);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Populate the FAQ list (replace with your own data)
        List<FAQItem> faqList = new ArrayList<>();
        faqList.add(new FAQItem("How does this Farmer Support System benefit me?", "It enhances farming practices by providing tailored insights and recommendations."));
        faqList.add(new FAQItem("What kind of information do I need to provide for this system to work?", "Soil type, crop variety, weather conditions, and historical data are typically required."));
        faqList.add(new FAQItem("Can this system help me anticipate and prepare for adverse weather conditions?", "Yes, it utilizes weather forecasts to aid in proactive preparation."));
        faqList.add(new FAQItem("How reliable are the recommendations provided by this system?", "Recommendations are based on robust algorithms and data analysis."));
        faqList.add(new FAQItem("Is this system user-friendly for farmers with limited technical knowledge?", "Absolutely, it's designed to be intuitive for all farmers."));



        // Add more FAQ items as needed

        // Set up the adapter
        faqAdapter = new FAQAdapter(faqList);
        recyclerView.setAdapter(faqAdapter);
    }
}
