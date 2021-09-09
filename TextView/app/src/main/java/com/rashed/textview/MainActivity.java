package com.rashed.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView nameTextView;
    private TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.nameTextView);
        ageTextView = findViewById(R.id.ageTextView);

        nameTextView.setText("Kamrul Hasan");
        ageTextView.setText("25 years old");
    }
}