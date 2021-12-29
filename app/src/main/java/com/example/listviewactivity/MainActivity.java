package com.example.listviewactivity;

import static com.example.listviewactivity.ViewCarList.carList;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn , viewBtn;
    static EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.userInput);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = input.getText().toString();
                Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_SHORT).show();
                carList.add(userInput);
                input.setText(" ");
            }
        });

        viewBtn = findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewCarList.class);
                startActivity(intent);
            }
        });
    }
}