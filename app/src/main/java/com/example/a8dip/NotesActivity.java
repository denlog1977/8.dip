package com.example.a8dip;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;



public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        NoteRepository noteRepository = App.getNoteRepository();


        ListView listViewNotes = findViewById(R.id.listViewNotes);

        List<Note> notes = noteRepository.getNotes();

        final NotesAdapter adapter = new NotesAdapter(this, notes);

        listViewNotes.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


}
