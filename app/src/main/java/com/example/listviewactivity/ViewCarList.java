package com.example.listviewactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ViewCarList extends AppCompatActivity {

    ListView listView;
    Button backBtn;
    static ArrayAdapter<String> arrayAdapter;
    static ArrayList<String> carList = new ArrayList<String>();
    static Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car_list);

        listView = findViewById(R.id.listViewLayout);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, carList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                registerForContextMenu(listView);
            }
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.action_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.edit:
                String edit = carList.get(info.position).toString();
                Intent i = new Intent(ViewCarList.this, EditCarName.class);
                i.putExtra("editCar", edit);
                Toast.makeText(this, "You Selected " + carList.get(info.position), Toast.LENGTH_SHORT).show();
                startActivity(i);
                return true;
            case R.id.delete:
                carList.remove(info.position);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(this, "You deleted the car from your list ", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}