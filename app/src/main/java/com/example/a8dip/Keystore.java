package com.example.a8dip;


interface Keystore {
    boolean hasPin();
    boolean checkPin(String pin);
    void saveNew(String pin);
}