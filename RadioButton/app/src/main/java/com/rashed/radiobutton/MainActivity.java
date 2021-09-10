package com.rashed.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button showButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        showButton = findViewById(R.id.showButton);
        resultTextView = findViewById(R.id.resultTextView);

        showButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderButton = findViewById(selectedId);

                String value = genderButton.getText().toString();

                resultTextView.setText("You have selected : " + value);
            }
        });
    }
}