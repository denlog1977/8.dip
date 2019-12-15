package com.example.a8dip;


import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

class SimpleKeystore implements Keystore {

    private SharedPreferences preferences;

    public SimpleKeystore(SharedPreferences preferences) {
        this.preferences = preferences;
    }



    @Override
    public boolean hasPin() {
        return preferences.getString("pinCode", "").isEmpty();
    }

    @Override
    public boolean matchPin(String pin) {
        return preferences.getString("pinCode", "").equals(pin);
    }

    @Override
    public void saveNew(String pin) {
        SharedPreferences.Editor myEditor = preferences.edit();
        myEditor.putString("pinCode", pin);
        myEditor.apply();

    }
}
