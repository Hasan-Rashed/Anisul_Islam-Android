package com.rashed.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private View loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        LayoutInflater inflater = getLayoutInflater();

        View customView = inflater.inflate(R.layout.custom_toast, findViewById(R.id.customToast));

        Toast toast = new Toast(MainActivity.this);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(customView);
        toast.show();;
    }
}