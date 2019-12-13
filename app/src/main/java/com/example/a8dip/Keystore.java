package com.example.a8dip;


interface Keystore {

    boolean has_Pin();
    boolean check_Pin(String pin);
    void save_New(String pin);

}