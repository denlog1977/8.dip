package com.example.a8dip;


import android.app.Activity;
import android.widget.Toast;

class SimpleKeystore implements Keystore {

    AppDiplomAnd appDiplomAnd;

    public SimpleKeystore(AppDiplomAnd appDiplomAnd) {
        this.appDiplomAnd = appDiplomAnd;
    }

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
        Toast.makeText(appDiplomAnd, "!!!", Toast.LENGTH_SHORT).show();
    }
}
