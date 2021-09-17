package com.rashed.listviewfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.setTitle("CountryName"); // to change the name of the Activity

        listView = findViewById(R.id.listView);
        String[] countryNames = getResources().getStringArray(R.array.countryNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sample_view, R.id.textView, countryNames);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                adapter.getFilter().filter(s);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}