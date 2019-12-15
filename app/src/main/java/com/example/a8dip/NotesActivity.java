package com.example.a8dip;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;



public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        NoteRepository noteRepository = App.getNoteRepository();


        ListView listViewNotes = findViewById(R.id.listViewNotes);

        List<Note> notes = noteRepository.getNotes();
//        List<Note> notes = new List<>();
//
//        notes.add(new Note("HeadLine", "Body" ));
//        notes.add(new Note("HeadLine", "Body" ));
//        notes.add(new Note("HeadLine", "Body" ));
//        notes.add(new Note("HeadLine", "Body" ));
//        notes.add(new Note("HeadLine", "Body" ));

        final NotesAdapter adapter = new NotesAdapter(this, notes);

        listViewNotes.setAdapter(adapter);



    }



}
