package com.rashed.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    DatabaseHelper databaseHelper;

    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton, displayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderEditText = findViewById(R.id.genderEditText);
        addButton = findViewById(R.id.addButton);
        displayButton = findViewById(R.id.displayButton);

        addButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if (view.getId() == R.id.addButton)
        {
            long rowId = databaseHelper.insertData(name, age, gender);

            if (rowId == -1)
            {
                Toast.makeText(getApplicationContext(), "unsuccessful", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Row " + rowId + " is successfully inserted", Toast.LENGTH_SHORT).show();
            }
        }

        else if (view.getId() == R.id.displayButton)
        {
            Cursor resultSet = databaseHelper.displayData();

            if (resultSet.getCount() == 0)
            {
                // there is no data
                showData("Error ", "No data Found");

                return;
            }
            StringBuffer stringBuffer = new StringBuffer();

            while (resultSet.moveToNext())
            {
                stringBuffer.append("ID: " + resultSet.getString(0) + "\n");
                stringBuffer.append("Name: " + resultSet.getString(1) + "\n");
                stringBuffer.append("Age: " + resultSet.getString(2) + "\n");
                stringBuffer.append("Gender: " + resultSet.getString(3) + "\n\n\n");
            }

            showData("ResultSet", stringBuffer.toString());
        }
    }

    public void showData(String title, String data)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);

        builder.setCancelable(true);
        builder.show();
    }
}