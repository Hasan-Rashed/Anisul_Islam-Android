package com.rashed.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText nameEditText, signUpEmailEditText, userNameEditText, passwordEditText;
    private Button signUpButton;

    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = findViewById(R.id.nameEditText);
        signUpEmailEditText = findViewById(R.id.signUpEmailEditText);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        databaseHelper = new DatabaseHelper(this);

        userDetails = new UserDetails();
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String name = nameEditText.getText().toString();
        String email = signUpEmailEditText.getText().toString();
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);

        if (rowId > 0)
        {
            Toast.makeText(getApplicationContext(), "Row " + rowId + " is successfully inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
}