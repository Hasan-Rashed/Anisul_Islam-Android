package com.rashed.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView textView;
    private DatePicker datePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.button);

        textView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                textView.setText(currentDate());
            }
        });
    }

    String currentDate()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Current date: ");
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append((datePicker.getMonth() + 1) + "/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}