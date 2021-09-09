package com.rashed.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.imageView1)
        {
            Toast.makeText(MainActivity.this, "Rashed\nDapartment Of CSE, Britannia University", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.imageView2)
        {
            Toast.makeText(MainActivity.this, "Other\nUnsplash", Toast.LENGTH_SHORT).show();
        }
    }
}