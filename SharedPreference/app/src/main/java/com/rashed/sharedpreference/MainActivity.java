package com.rashed.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText userName, password;
    private TextView details;
    private Button save, load;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userNameEditText);
        password = findViewById(R.id.passwordEditText);
        details = findViewById(R.id.details);
        save = findViewById(R.id.saveButton);
        load = findViewById(R.id.loadButton);

        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.saveButton)
        {
            String name = userName.getText().toString();
            String pass = password.getText().toString();

            if (userName.equals("") && password.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter some data", Toast.LENGTH_SHORT).show();
            }

            else
            {
                // write data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userNameKey", name);
                editor.putString("passwordKey", pass);

                editor.commit();

                userName.setText("");
                password.setText("");

                Toast.makeText(getApplicationContext(), "Data is stored successfully", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.loadButton)
        {
            // to read data
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

            if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey"))
            {
                String userName = sharedPreferences.getString("userNameKey", "Data Not Found");
                String password = sharedPreferences.getString("passwordKey", "Data Not Found");

                details.setText(userName + "\n" + password);
            }
        }
    }
}