package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Declare reference vars
    ListView cityList;
    Button addCityButton;
    Button removeCityButton;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    /**
     * Main entry point
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find IDs
        cityList = findViewById(R.id.city_list);
        addCityButton = findViewById(R.id.add_city);
        removeCityButton = findViewById(R.id.remove_city);

        // Set up list data
        String[] cities = {"Edmonton", "Regina", "Toronto", "Red Deer", "Airdrie", "Cold Lake"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        // Link Adapter to list
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList); // link dataList to content.xml
        cityList.setAdapter(cityAdapter);

        // Make the buttons do stuff with onClickListeners

        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to add city

                // Test
                CharSequence text = "This Works!";
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        removeCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to remove city

                // Test
                CharSequence text = "This Works!";
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

    }
}