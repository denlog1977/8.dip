package com.example.a8dip;

class SimpleKeystore implements Keystore {
    @Override
    public boolean hasPin() {
        return false;
    }
    @Override
    public boolean checkPin(String pin) {
        return false;
    }
    @Override
    public void saveNew(String pin) {
    }
}
