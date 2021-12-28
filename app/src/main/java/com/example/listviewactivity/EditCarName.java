package com.example.listviewactivity;

import static com.example.listviewactivity.ViewCarList.arrayAdapter;
import static com.example.listviewactivity.ViewCarList.carList;
import static com.example.listviewactivity.ViewCarList.index;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditCarName extends AppCompatActivity {

    static EditText editCarName;
    Button updateBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car_name);

        editCarName = findViewById(R.id.editCarName);
        updateBtn = findViewById(R.id.updateBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        String editCar = getIntent().getStringExtra("editCar");
        editCarName.setText(editCar);

        //Update Button
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = editCarName.getText().toString();
                carList.set(index, edit);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditCarName.this, ViewCarList.class);
                startActivity(intent);
            }
        });

        //Cancel Button
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}