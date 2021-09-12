package com.rashed.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button exitButton;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = findViewById(R.id.exitButton);

        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        // setting title
        alertDialogBuilder.setTitle(R.string.titleText);

        // setting message
        alertDialogBuilder.setMessage(R.string.messageText);

        // setting icon
        alertDialogBuilder.setIcon(R.drawable.question);

        // setting cancel able to false
        alertDialogBuilder.setCancelable(false);

        // setting positive Button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //exit
                finish();
            }
        });

        // setting negative Button
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.cancel();
            }
        });

        // setting Neutral Button
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "You have clicked cancel button", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}