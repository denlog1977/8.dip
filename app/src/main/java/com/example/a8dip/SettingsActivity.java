package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle(R.string.action_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
//            Toast.makeText(this, R.string.action_back, Toast.LENGTH_SHORT).show();
            this.finish();
        } //        else if (id ==  R.id.action_save_note) {
//            Toast.makeText(this, R.string.action_save_note, Toast.LENGTH_SHORT).show();
//            Log.i("denLogs", "R.id.action_save_note");
//            this.finish();
//        }
        return super.onOptionsItemSelected(item);
    }

}
