package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private long mDate;
    private TextView textViewDeadLine;
    private ImageView imageViewDeadLine;
    private CheckBox checkBoxHasDeadLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle(R.string.note);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkBoxHasDeadLine = findViewById(R.id.checkBoxHasDeadLine);
        textViewDeadLine = findViewById(R.id.textViewDeadLine);
        imageViewDeadLine = findViewById(R.id.imageViewDeadLine);

        checkBoxHasDeadLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewDeadLine.setVisibility(View.VISIBLE);
                    imageViewDeadLine.setVisibility(View.VISIBLE);
                    textViewDeadLine.setText(R.string.SetDeadLineDay);
                } else {
                    textViewDeadLine.setVisibility(View.GONE);
                    imageViewDeadLine.setVisibility(View.GONE);
                }


            }
        });

        imageViewDeadLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "datePicker");


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.i("denLogs", "item.getItemId() = " + item.getItemId());
        Log.i("denLogs", "item = " + item);

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Toast.makeText(this, R.string.action_back, Toast.LENGTH_SHORT).show();
            this.finish();
        } else if (id ==  R.id.action_save_note) {
            Toast.makeText(this, R.string.action_save_note, Toast.LENGTH_SHORT).show();
            Log.i("denLogs", "R.id.action_save_note");
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        textViewDeadLine.setText("Дата: " + day + "." + (month + 1) + "." + year);
    }
}
