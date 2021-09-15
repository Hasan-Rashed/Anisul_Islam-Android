package com.rashed.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class SecondActivity extends AppCompatActivity
{
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);

         button.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View view)
             {
                 String value = editText.getText().toString();

                 Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                 intent.putExtra("key", value);

                 setResult(1, intent);
                 finish();
             }
         });
    }
}