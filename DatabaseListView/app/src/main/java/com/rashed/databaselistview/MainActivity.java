package com.rashed.databaselistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private DatabaseHelper databaseHelper;

    private EditText nameEditText, idEditText;
    private Button saveButton, showButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.nameEditText);
        idEditText = findViewById(R.id.idEditText);

        saveButton = findViewById(R.id.saveButton);
        showButton = findViewById(R.id.showButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if (view.getId() == R.id.saveButton)
        {
            if (id.equals("") && name.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please insert all the data", Toast.LENGTH_SHORT).show();
            }
            else
            {
                long rowNumber = databaseHelper.saveData(id, name);

                if (rowNumber > 1)
                {
                    Toast.makeText(getApplicationContext(), "Data is inserted successfully", Toast.LENGTH_SHORT).show();
                    idEditText.setText("");
                    nameEditText.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Data is not inserted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if (view.getId() == R.id.showButton)
        {
            Intent intent = new Intent(MainActivity.this, ListDAtaActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.updateButton)
        {
            Boolean isUpdated = databaseHelper.updateData(id, name);

            if (isUpdated == true)
            {
                Toast.makeText(getApplicationContext(), "data si updated", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "data is not updated", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.deleteButton)
        {
            int value = databaseHelper.deleteData(id);

            if (value < 0)
            {
                Toast.makeText(getApplicationContext(), "data is not deleted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "data is deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}