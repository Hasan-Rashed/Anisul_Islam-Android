package com.rashed.sharedpreferencesettings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        
        if (loadColor() != getResources().getColor(R.color.design_default_color_primary))
        {
            linearLayout.setBackgroundColor(loadColor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.redColor)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
            storeColor(getResources().getColor(R.color.redColor));
        }

        else if (item.getItemId() == R.id.greenColor)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            storeColor(getResources().getColor(R.color.greenColor));
        }

        else if (item.getItemId() == R.id.yellowColor)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
            storeColor(getResources().getColor(R.color.yellowColor));
        }

        else if (item.getItemId() == R.id.pinkColor)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.pinkColor));
            storeColor(getResources().getColor(R.color.pinkColor));
        }

        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("Color", color);

        editor.commit();
    }

    private int loadColor()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("color", getResources().getColor(R.color.design_default_color_primary));

        return  selectedColor;
    }
}