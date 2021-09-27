package com.rashed.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    DatabaseHelper databaseHelper;

    private Button signInButton, signUpButton;
    private EditText signInEditText, signInPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        signInEditText = findViewById(R.id.signInEditText);
        signInPasswordEditText = findViewById(R.id.signInPasswordEditText);

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String username = signInEditText.getText().toString();
        String password = signInPasswordEditText.getText().toString();

        if (view.getId() == R.id.signInButton)
        {
            Boolean result = databaseHelper.findPassword(username, password);

            if (result == true)
            {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "username and password didn't match", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.signUpButton)
        {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}