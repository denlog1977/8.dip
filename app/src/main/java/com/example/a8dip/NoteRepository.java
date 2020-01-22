package com.example.a8dip;


import java.util.List;

interface NoteRepository {
    Note getNoteById(String id);
    List<Note> getNotes();
    void saveNotes(List<Note> notes);
    void deleteById(String id);
}