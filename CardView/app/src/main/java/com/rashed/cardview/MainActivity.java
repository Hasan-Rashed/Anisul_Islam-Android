package com.rashed.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private CardView schoolCardView, hospitalCardView, restaurantCardView, airportCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schoolCardView = findViewById(R.id.school);
        hospitalCardView = findViewById(R.id.hospital);
        restaurantCardView = findViewById(R.id.restaurant);
        airportCardView = findViewById(R.id.airport);

        schoolCardView.setOnClickListener(this);
        hospitalCardView.setOnClickListener(this);
        restaurantCardView.setOnClickListener(this);
        airportCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.school)
        {
            Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.hospital)
        {
            Intent intent = new Intent(MainActivity.this, HospitalActivity.class);
            startActivity(intent);
        }
    }
}