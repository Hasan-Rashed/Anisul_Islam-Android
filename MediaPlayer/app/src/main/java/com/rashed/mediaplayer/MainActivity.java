package com.rashed.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.pauseButton);
        pauseButton = findViewById(R.id.pauseButton);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mishary_rashid_alafasy_muslimcentral);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        double duration = mediaPlayer.getDuration();
        Toast.makeText(MainActivity.this, "duration " + duration / 1000, Toast.LENGTH_SHORT).show();

        if (view.getId() == R.id.playButton)
        {
            if (mediaPlayer != null)
            {
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "song played", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.pauseButton)
        {
            if (mediaPlayer != null)
            {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "song paused", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy()
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}