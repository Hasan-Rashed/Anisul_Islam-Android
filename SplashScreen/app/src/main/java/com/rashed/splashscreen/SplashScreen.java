package com.rashed.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity
{
    private ProgressBar progressBar;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.ptogressBar);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                doWork();

                startAPP();
            }
        });

        thread.start();
    }

    public void doWork()
    {
        for (progress = 10; progress <= 100; progress += 10)
        {
            try
            {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void startAPP()
    {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}