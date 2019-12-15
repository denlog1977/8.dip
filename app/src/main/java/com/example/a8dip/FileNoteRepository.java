package com.example.a8dip;

import java.util.ArrayList;
import java.util.List;

public class FileNoteRepository implements NoteRepository {

    App app;
    Note note;
    List<Note> notes;

    public FileNoteRepository(App app) {
        this.app = app;
    }


    @Override
    public Note getNoteById(String id) {
        ///
        return note;
    }

    @Override
    public List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("HeadLine", "Body" ));
        notes.add(new Note("HeadLine", "Body" ));
        notes.add(new Note("HeadLine", "Body" ));
        notes.add(new Note("HeadLine", "Body" ));
        notes.add(new Note("HeadLine", "Body" ));
        return notes;
    }

    @Override
    public void saveNote(Note note){
        ///
    }

    @Override
    public void deleteById(String id){
        ///
    }


}
