package com.rashed.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText userName, password;
    private Button loginButton;
    private TextView textView;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        textView = findViewById(R.id.textView);

        textView.setText("Number of attempts remaining: 3");

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = userName.getText().toString();
                String pass = password.getText().toString();

                if (name.equals("admin") && pass.equals("1234"))
                {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }

                else
                {
                    counter--;
                    textView.setText("Number of attempts remaining: " + counter);
                    if (counter == 0)
                    {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });
    }
}