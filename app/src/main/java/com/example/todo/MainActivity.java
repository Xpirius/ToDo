package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String>items;
    private ArrayAdapter<String>itemsadapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(view);
            }
        });

        items = new ArrayList<>();
        itemsadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsadapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {

                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemsadapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem(View v) {
        EditText input = findViewById(R.id.editTextTextPersonName2);
        String itemText = input.getText().toString();


        if(!(itemText.equals(""))){
            itemsadapter.add(itemText);
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter text...",Toast.LENGTH_LONG).show();
        }
    }
}