package com.example.a8dip;




class HashedKeystore implements Keystore {

    @Override
    public boolean hasPin() {
        return false;
    }

    @Override
    public boolean matchPin(String pin) {
        return false;
    }

    @Override
    public void saveNew(String pin) {


    }

}

