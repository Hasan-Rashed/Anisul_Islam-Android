package com.rashed.intentwithdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity
{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            String value = bundle.getString("tag");
            textView.setText(value);
        }
    }
}