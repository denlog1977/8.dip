package com.example.a8dip;

import android.content.Context;

import java.util.List;

public class SqliteNoteRepository implements NoteRepository{


    App app;
    Note note;
    List<Note> listNotes;

    public SqliteNoteRepository(App app) {
        this.app = app;
    }


    @Override
    public Note getNoteById(String id) {
        ///
        return note;
    }

    @Override
    public List<Note> getNotes(Context ctx){
        ///
        return listNotes;
    }

    @Override
    public void saveNotes(Context ctx, List<Note> notes){
        ///
    }

    @Override
    public void deleteById(String id){
        ///
    }

}
