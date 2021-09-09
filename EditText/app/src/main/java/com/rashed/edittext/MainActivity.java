package com.rashed.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText editText1, editText2;
    private Button addButton, subButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        addButton = findViewById(R.id.addButton);
        subButton = findViewById(R.id.subButton);
        textView = findViewById(R.id.textView);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        try
        {
            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

            // Converting into double
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if (view.getId() == R.id.addButton)
            {
                double sum = num1 + num2;
                textView.setText("Result is: " + sum);
            }

            else if (view.getId() == R.id.subButton)
            {
                double sub = num1 - num2;
                textView.setText("Result is: " + sub);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, "Please Enter Numbers", Toast.LENGTH_SHORT).show();
        }
    }
}