package com.example.a8dip;



import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import java.io.FileReader;




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
    public List<Note> getNotes(Context ctx){

        List<Note> notes = new ArrayList<>();


//        Calendar c;
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Добавить", "Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн;", true, c.getTime().toString()));
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн", "Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн. Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн;", true, c.getTime().toString()));
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Отредактировать", "Отредактировать существующую заметку;", false, new Date().toString()));
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Просмотреть", "Просмотреть список сохраненных заметок;", true, c.getTime().toString()));
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Пин-код", "Ограничить доступ к заметкам с помощью пин-кода;", true, c.getTime().toString()));
//
//        c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
//        notes.add(new Note("Меню настроек", "Изменить пин-код в меню настроек.", true, c.getTime().toString()));


        {
            try {
                String str = "";
                String line;
                FileReader fileReader = new FileReader("notes.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while((line = bufferedReader.readLine()) != null) {
                    str += line + "\n"; // содержимое файла на экран построчно
                }
                String[] notesArray = str.split("\n");
                for(int i=0; i < notesArray.length; i+=3) {
                    Log.i("myLogs", "Выбранная позиция: " + i);
                    Log.i("myLogs", "Значение элемента массива: " + notesArray(i));
                    String headLine = notesArray[i];
                    String body = notesArray[i+1];
                    String deadLineDay = notesArray[i+2];
                    notes.add(new Note(headLine, body, deadLineDay.isEmpty(), deadLineDay));
                }
                bufferedReader.close();
                fileReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return notes;


    }

    @Override
    public void saveNotes(Context ctx, List<Note> notes){

//        List<Note> notes = new ArrayList<>();

        Calendar c;

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Добавить", "Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн;", true, c.getTime().toString()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн", "Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн. Добавить новую текстовую заметку: заголовок, текстовое содержание, дедлайн;", true, c.getTime().toString()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Отредактировать", "Отредактировать существующую заметку;", false, new Date().toString()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Просмотреть", "Просмотреть список сохраненных заметок;", true, c.getTime().toString()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Пин-код", "Ограничить доступ к заметкам с помощью пин-кода;", true, c.getTime().toString()));

        c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, new Random().nextInt(10) * 1000 * 60 * 60 * 24);
        notes.add(new Note("Меню настроек", "Изменить пин-код в меню настроек.", true, c.getTime().toString()));

        String notesString = "";
        for (Note note: notes) {
            notesString += "\n" + note.getHeadLine() + "\n" + note.getBody() + "\n" + note.getDeadLineDay();
        }

        try {
            FileOutputStream outputStream = ctx.openFileOutput("notes.txt", Context.MODE_PRIVATE);
            outputStream.write(notesString.getBytes());
            outputStream.close();
            Toast.makeText(ctx, "записаны notes ВО внутренний ФАЙЛ notes.txt ", Toast.LENGTH_SHORT).show();
            Log.i("myLogs", "записаны notes ВО внутренний ФАЙЛ notes.txt ");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(String id){
        ///
    }


}
