package com.rashed.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        String[] countryNames = getResources().getStringArray(R.array.countryNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<String >(MainActivity.this, R.layout.sample_view, R.id.textView, countryNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String value = countryNames[i];
                Toast.makeText(MainActivity.this, value + " at position " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}