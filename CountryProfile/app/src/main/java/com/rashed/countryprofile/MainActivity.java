package com.rashed.countryprofile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button bangladeshButton, indiaButton, pakistanButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladeshButton = findViewById(R.id.bangladesh);
        indiaButton = findViewById(R.id.india);
        pakistanButton = findViewById(R.id.pakistan);

        bangladeshButton.setOnClickListener(this);
        indiaButton.setOnClickListener(this);
        pakistanButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.bangladesh)
        {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Bangladesh");
            startActivity(intent);
        }

        else if (view.getId() == R.id.india)
        {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "India");
            startActivity(intent);
        }

        else if (view.getId() == R.id.pakistan)
        {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Pakistan");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle(R.string.titleText);
        alertDialogBuilder.setMessage(R.string.messageText);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finish();
            }
        });

        alertDialogBuilder.setNeutralButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}