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


        ListView listViewNotes = findViewById(R.id.listViewNotes);

        List<Note> notes = noteRepository.getNotes();

        final NotesAdapter adapter = new NotesAdapter(this, notes);

        listViewNotes.setAdapter(adapter);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotesActivity.this, "FloatingActionButton", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NotesActivity.this, NoteActivity.class);
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
        Bundle extras = intent.getExtras();
        extras.putString("headLine", "headLine");
        extras.putString("body", "body");
        extras.putBoolean("hasDeadLine", true);
        extras.putString("deadLineDay", "2019/12/20");
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }


}
