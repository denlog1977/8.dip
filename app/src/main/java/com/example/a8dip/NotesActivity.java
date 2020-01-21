package com.example.a8dip;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;



public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setTitle(R.string.notes);

        NoteRepository noteRepository = App.getNoteRepository();

        List<Note> notes = noteRepository.getNotes();

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        if(position < 0) {
            Toast.makeText(NotesActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
        } else {
            Note note = notes.get(position);
            note.setHeadLine(bundle.getString("headLine"));
            note.setBody(bundle.getString("body"));
            note.setHasDeadLine(bundle.getBoolean("hasDeadLine"));
//            note.setDeadLineDay(bundle.getString("deadLineDay"));
        }

        final NotesAdapter adapter = new NotesAdapter(this, notes);

        ListView listViewNotes = findViewById(R.id.listViewNotes);
        listViewNotes.setAdapter(adapter);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(NotesActivity.this, "FloatingActionButton", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NotesActivity.this, NoteActivity.class);
                Bundle extras = new Bundle();
                extras.putString("headLine", "");
                extras.putString("body", "");
                extras.putBoolean("hasDeadLine", false);
                extras.putString("deadLineDay", "");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });


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
        Intent intent = new Intent(NotesActivity.this, SettingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


}
