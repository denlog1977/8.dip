package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
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

import java.util.List;

public class NoteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView editTextHeadLine;
    private TextView editTextBody;
    private TextView textViewDeadLine;
    private ImageView imageViewDeadLine;
    private CheckBox checkBoxHasDeadLine;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle(R.string.note);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextHeadLine = findViewById(R.id.editTextHeadLine);
        editTextBody = findViewById(R.id.editTextBody);
        checkBoxHasDeadLine = findViewById(R.id.checkBoxHasDeadLine);
        textViewDeadLine = findViewById(R.id.textViewDeadLine);
        imageViewDeadLine = findViewById(R.id.imageViewDeadLine);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("position")!= null) { position = bundle.getInt("position"); }
        if(bundle.getString("headLine")!= null) { editTextHeadLine.setText(bundle.getString("headLine")); }
        if(bundle.getString("body")!= null) { editTextBody.setText(bundle.getString("body")); }
        if(bundle.getString("deadLineDay")!= null) { textViewDeadLine.setText(bundle.getString("deadLineDay")); }
        checkBoxHasDeadLine.setChecked(bundle.getBoolean("hasDeadLine", true));
        if (checkBoxHasDeadLine.isChecked()) {
            textViewDeadLine.setVisibility(View.VISIBLE);
            imageViewDeadLine.setVisibility(View.VISIBLE);
        } else {
            textViewDeadLine.setVisibility(View.GONE);
            imageViewDeadLine.setVisibility(View.GONE);
        }

        checkBoxHasDeadLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewDeadLine.setVisibility(View.VISIBLE);
                    imageViewDeadLine.setVisibility(View.VISIBLE);
//                    textViewDeadLine.setText(R.string.SetDeadLineDay);
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

            NoteRepository noteRepository = App.getNoteRepository();

            List<Note> notes = noteRepository.getNotes();

            if(position < 0) {
//                Toast.makeText(NotesActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
                Note note = new Note(editTextHeadLine.getText().toString(), editTextBody.getText().toString(), checkBoxHasDeadLine.isChecked());
                notes.add(note);
                noteRepository.saveNotes(notes);
                this.finish();
            } else {
                Note note = notes.get(position);
                note.setHeadLine(editTextHeadLine.getText().toString());
                note.setBody(editTextBody.getText().toString());
                note.setHasDeadLine(checkBoxHasDeadLine.isChecked());
//                note.setDeadLineDay(textViewDeadLine.getText().toString()));
                noteRepository.saveNotes(notes);
                this.finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        textViewDeadLine.setText("Дата: " + day + "." + (month + 1) + "." + year);
    }
}
