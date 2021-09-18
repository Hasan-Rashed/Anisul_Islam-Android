package com.rashed.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Spinner spinner;
    private String [] countryNames;
    private String [] population;
    int[] flags = {R.drawable.afghanistan, R.drawable.armenia, R.drawable.azerbaijan, R.drawable.bahrain, R.drawable.bangladesh, R.drawable.bhutan, R.drawable.china, R.drawable.india, R.drawable.japan, R.drawable.pakistan, R.drawable.srilanka};
    private boolean aBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        countryNames = getResources().getStringArray(R.array.countryName);
        population = getResources().getStringArray(R.array.population);

        CustomAdapter customAdapter = new CustomAdapter(this, flags, countryNames, population);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(), countryNames[i] + " is selected ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
}