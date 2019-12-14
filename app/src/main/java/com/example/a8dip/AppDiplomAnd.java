package com.example.a8dip;


import android.app.Application;

public class AppDiplomAnd extends Application {

    private static NoteRepository noteRepository;
    private static Keystore keystore;

    @Override
    public void onCreate() {
        super.onCreate();


        /* Конкретная реализация выбирается только здесь.
           Изменением одной строчки здесь,
           мы заменяем реализацию во всем приложении!
        */

        noteRepository = new FileNoteRepository(this);
//        keystore = new SimpleKeystore(this);
        keystore = new HashedKeystore(this);
    }
    // Возвращаем интерфейс, а не конкретную реализацию!
    public static NoteRepository getNoteRepository() {
        return noteRepository;
    }
    // Возвращаем интерфейс, а не конкретную реализацию!
    public static Keystore getKeystore() {
        return keystore;
    }

}
