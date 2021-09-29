package com.rashed.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button callButton, visitButton, emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton = findViewById(R.id.callButton);
        visitButton = findViewById(R.id.visitButton);
        emailButton = findViewById(R.id.emailButton);

        callButton.setOnClickListener(this);
        visitButton.setOnClickListener(this);
        emailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.callButton)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Phone: +8801884135530"));
            startActivity(intent);
        }
        else if (view.getId() == R.id.visitButton)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("github.com/Hasan-Rashed"));
            startActivity(intent);
        }
        else if (view.getId() == R.id.emailButton)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("email: hasanrashed537@gmail.com"));
            startActivity(intent);
        }
    }
}