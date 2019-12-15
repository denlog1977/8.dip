package com.example.a8dip;


interface Keystore {
    boolean hasPin();
    void saveNew(String pin);
    boolean matchPin(String pin);

}