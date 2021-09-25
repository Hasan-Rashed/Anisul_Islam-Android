package com.rashed.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button increase, decrease;
    private TextView textView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);

        if (loadScore() != 0)
        {
            textView.setText("Score: " + loadScore());
        }

        increase.setOnClickListener(this);
        decrease.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.increase)
        {
            score += 10;
            textView.setText("Score: " + score);

            saveScore(score);
        }
        else if (view.getId() == R.id.decrease)
        {
            score -= 10;
            textView.setText("Score: " + score);

            saveScore(score);
        }
    }

    private void saveScore(int score)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);

        editor.commit();
    }

    private int loadScore()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("lastScore", 0);

        return score;
    }
}