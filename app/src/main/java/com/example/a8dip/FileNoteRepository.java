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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



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

        return notes;
        BufferedReader fileReader;
        String buf[] = new String[0];

        {
            try {
                String str = null;
                fileReader = new BufferedReader(new FileReader("C:\\...\\src\\model\\file.txt"));
                while ((str = fileReader.readLine()) != null) {
                    //получаем новые слова
                    String[] newWords = str.split(" ");
                    //создаем расширенный массив
                    String[] result = new String[buf.length + newWords.length];
                    //копируем элементы в массив
                    System.arraycopy(buf, 0, result, 0, buf.length);
                    System.arraycopy(newWords, 0, result, buf.length, newWords.length);
                    //присваиваем результирующий массив текущему
                    buf = result;
                }
                fileReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            new InputStreamReader(ctx.openFileInput("loginpassword.txt"));
            InputStreamReader inputStreamReader;
            BufferedReader reader = new BufferedReader(inputStreamReader);
            headLine = reader.readLine();
            body = reader.readLine();
            hasDeadLine = reader.readLine();
            bodeadLineDaydy = reader.readLine();

            Log.i("BufferedReader", "Прочитано из внутреннего файла: login =  " + login + " password = " + password);
            Toast.makeText(MainActivity.this, "Прочитано из внутреннего файла: login =  " + login + " password = " + password, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveNotes(List<Note> notes){
        try {
            FileOutputStream outputStream = openFileOutput("loginpassword.txt", Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Toast.makeText(MainActivity.this, "Вы зарегистрированы с логин паролем: " + login +" " + password, Toast.LENGTH_SHORT).show();
            Log.i("BufferedReader", "ЗАПИСАНЫ ВО внутренний ФАЙЛ логин пароль: " + login +" " + password);
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
