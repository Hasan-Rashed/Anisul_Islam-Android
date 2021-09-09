package com.rashed.button_imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button loginButton, logoutButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        logoutButton = findViewById(R.id.logoutButton);
        textView = findViewById(R.id.textView);

        loginButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.loginButton)
        {
            Toast.makeText(MainActivity.this, "Login button is clicked", Toast.LENGTH_SHORT).show();

            //Log.d("tag", "Login button is clicked");
        }
        else if (view.getId() == R.id.logoutButton)
        {
            Toast.makeText(MainActivity.this, "Logout button is clicked", Toast.LENGTH_SHORT).show();

            //Log.d("tag", "Logout button is clicked");
        }
    }
}