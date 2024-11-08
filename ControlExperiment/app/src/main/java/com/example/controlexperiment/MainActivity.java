package com.example.controlexperiment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize UI elements
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner spinner = findViewById(R.id.spinner);
        // Set up spinner data
        String[] options = {"Option A", "Option B", "Option C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, options);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // Button click listener
        button.setOnClickListener(v -> {
            String input = editText.getText().toString();

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show();
                return;
            }

            checkBox.setVisibility(checkBox.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);

            boolean isChecked = checkBox.isChecked();
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton =
                    findViewById(selectedId);
            String selectedRadioText = selectedRadioButton != null ?
                    selectedRadioButton.getText().toString() : "None";
            String selectedSpinner =
                    spinner.getSelectedItem().toString();


            // Show a Toast message with the collected input
            Toast.makeText(this, "Input: " + input + "\nChecked: " +
                            isChecked +
                            "\nSelected Radio: " + selectedRadioText +
                            "\nSelected Spinner: " + selectedSpinner,
                    Toast.LENGTH_LONG).show();
        });

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "SeekBar Progress: " + progress, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Switch listener
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(MainActivity.this, "Switch is " + (isChecked ? "ON" : "OFF"), Toast.LENGTH_SHORT).show()
        );

        // ImageButton listener
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "ImageButton clicked", Toast.LENGTH_SHORT).show()
        );
    }
}