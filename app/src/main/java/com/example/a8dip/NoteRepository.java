package com.example.a8dip;


import android.content.Context;

import java.util.List;

interface NoteRepository {
    Note getNoteById(String id);
    List<Note> getNotes(Context ctx);
    void saveNotes(Context ctx, List<Note> notes);
    void deleteById(String id);
}