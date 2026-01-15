package com.example.listycity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Declare reference vars
    private ListView cityList;
    private Button addCityButton;
    private Button removeCityButton;
    private Button confirmCityButton;
    private RelativeLayout bottomBar; // the bar where users enter city names
    private ArrayAdapter<String> cityAdapter;
    private ArrayList<String> dataList;

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
        confirmCityButton = findViewById(R.id.confirm_city);
        bottomBar = findViewById(R.id.bottom_bar);

        // Set up list data
        String[] cities = {"Edmonton", "Regina", "Toronto", "Red Deer", "Airdrie", "Cold Lake"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        // Link Adapter to list
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList); // link dataList to content.xml
        cityList.setAdapter(cityAdapter);
        setUpListViewListener(); // So that the list can be clicked on

        // Make the buttons do stuff with onClickListeners

        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to add city
                bottomBar.setVisibility(VISIBLE);


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

        confirmCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to confirm city name after typing
                addCity(v);
                bottomBar.setVisibility(GONE);
            }
        });

    }

    /**
     * Adds city to cityList
     *
     * taken from <a href="https://www.youtube.com/watch?v=i9mkAoZ8FNk">...</a>. I'll cite good later.
     */
    private void addCity(View view) {
        // Collect user input
        EditText input =  findViewById(R.id.editText);
        String cityName = input.getText().toString();

        // Check if text box is empty
        if(!(cityName.isEmpty())){
            cityAdapter.add(cityName);
            input.setText("");
        }
        else {
            CharSequence text = "Please type in a city name...";
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Allows List items from cityList to be clicked on
     */
    private void setUpListViewListener() {
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Code to select city item

                // Test
                CharSequence text = "This Works!";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}