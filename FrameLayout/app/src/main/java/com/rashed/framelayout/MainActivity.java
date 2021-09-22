package com.rashed.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageView gitImageView, backgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gitImageView = findViewById(R.id.gitImageView);
        backgroundImageView = findViewById(R.id.backgroundImageView);

        gitImageView.setOnClickListener(this);
        backgroundImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.gitImageView)
        {
            gitImageView.setVisibility(View.GONE);
            backgroundImageView.setVisibility(View.VISIBLE);
        }

        else if (view.getId() == R.id.backgroundImageView)
        {
            backgroundImageView.setVisibility(View.GONE);
            gitImageView.setVisibility(View.VISIBLE);
        }
    }
}