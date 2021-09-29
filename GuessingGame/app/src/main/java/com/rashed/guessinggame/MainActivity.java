package com.rashed.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText editText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkButton = findViewById(R.id.checkButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String guessString = editText.getText().toString();

        if (guessString.isEmpty())
        {
            errorMessage();
        }
        else
        {
            int guess = Integer.parseInt(guessString);

            if (guess > 5 || guess < 1)
            {
                errorMessage();
            }
            //generating random number
            Random random = new Random();
            int value = random.nextInt(5) + 1;

            if (value == guess)
            {
                resultTextView.setText("Congratulation !!! you have won");
            }
            else
            {
                resultTextView.setText("Sorry ! you have lost. Random number was: " + value);
            }
        }
    }

    public void errorMessage()
    {
        editText.setError("Please enter a valid input");
        editText.requestFocus();

        return;
    }
}