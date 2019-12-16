package com.example.a8dip;



import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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


        Calendar c;

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("HeadLine", "Body" , c.getTime()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("HeadLine", "Body" , c.getTime()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("HeadLine", "Body" , c.getTime()));


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
