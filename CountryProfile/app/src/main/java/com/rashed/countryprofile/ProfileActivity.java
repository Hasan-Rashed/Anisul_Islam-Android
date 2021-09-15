package com.rashed.countryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity
{
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String countryName = bundle.getString("name");

            showDetails(countryName);
        }
    }

    void showDetails(String countryName)
    {
        if (countryName.equals("Bangladesh"))
        {
            imageView.setImageResource(R.drawable.bangladesh_96px);
            textView.setText(R.string.bangladeshText);
        }

        else if (countryName.equals("India"))
        {
            imageView.setImageResource(R.drawable.india_96px);
            textView.setText(R.string.indiaText);
        }

        else if (countryName.equals("Pakistan"))
        {
            imageView.setImageResource(R.drawable.pakistan_96px);
            textView.setText(R.string.pakistanText);
        }
    }
}