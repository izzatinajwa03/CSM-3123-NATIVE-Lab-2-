package com.example.menuexperiment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

 public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar); // Set toolbar as the action bar
        } else {
            textView.setText("Error: Toolbar not found.");
        }
    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.main_menu, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
         int itemId = item.getItemId();
         if (itemId == R.id.action_settings) {
             textView.setText("Settings selected");
             return true;
         } else if (itemId == R.id.action_about) {
             textView.setText("About selected");
             return true;
         } else {
             return super.onOptionsItemSelected(item);
         }
     }

     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
         getMenuInflater().inflate(R.menu.main_menu, menu);
         menu.setHeaderTitle("Choose an option");
     }

     @Override
     public boolean onContextItemSelected(MenuItem item) {
         int itemId = item.getItemId();
         if (itemId == R.id.action_settings) {
             textView.setText("Settings selected from context menu");
             return true;
         } else if (itemId == R.id.action_about) {
             textView.setText("About selected from context menu");
             return true;
         } else {
             return super.onContextItemSelected(item);
         }
     }

 }