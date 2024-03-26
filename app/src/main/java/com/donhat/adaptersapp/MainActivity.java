package com.donhat.adaptersapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1 - AdapterView: ListView
        ListView listView = findViewById(R.id.list_view);

        // 2 - Data Source: String Array
        String[] countries = {"USA", "Germany", "Saudi Arabia", "French"};

        // 3 - Adapter: acts as a bridge between the 'Data Source' and the 'AdapterView'
        CountryAdapter countryAdapter = new CountryAdapter(this, countries);

        // 4 - Link AdapterView with the Adapter
        listView.setAdapter(countryAdapter);
    }
}