package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String pin = "";
    private String pinCorrect = "1977";
    private SharedPreferences mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        pin = "";



        setNumberClickListener((TextView) findViewById(R.id.textViewButton0));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton1));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton2));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton3));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton4));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton5));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton6));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton7));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton8));
        setNumberClickListener((TextView) findViewById(R.id.textViewButton9));
        setNumberClickListener((TextView) findViewById(R.id.textViewBackSpace));

        TextView textViewBackSpace = findViewById(R.id.textViewBackSpace);
        textViewBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTextViewPin();
            }
        });

    }

    private void setNumberClickListener(final TextView button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Keystore keystore = App.getKeystore();

                if (pin.length() < 4) {
                    pin = pin + button.getText().toString();
                    switch (pin.length()) {
                        case 1 :
                            TextView textView1 = findViewById(R.id.textView1);
                            textView1.setText(Character.toString(pin.charAt(pin.length()-1)));
                            ImageView imageView1 = findViewById(R.id.imageView1);
                            imageView1.setVisibility(View.INVISIBLE);
                            break;
                        case 2 :
                            TextView textView2 = findViewById(R.id.textView2);
                            textView2.setText(Character.toString(pin.charAt(pin.length()-1)));
                            ImageView imageView2 = findViewById(R.id.imageView2);
                            imageView2.setVisibility(View.INVISIBLE);
                            break;
                        case 3 :
                            TextView textView3 = findViewById(R.id.textView3);
                            textView3.setText(Character.toString(pin.charAt(pin.length()-1)));
                            ImageView imageView3 = findViewById(R.id.imageView3);
                            imageView3.setVisibility(View.INVISIBLE);
                            break;
                        case 4 :
                            TextView textView4 = findViewById(R.id.textView4);
                            textView4.setText(Character.toString(pin.charAt(pin.length()-1)));
                            ImageView imageView4 = findViewById(R.id.imageView4);
                            imageView4.setVisibility(View.INVISIBLE);
//                            checkPinMainActivity(pin, keystore);
                            checkPinMainActivity(pin);
                            break;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "ХАРЕМБА !!!\nЧисло символов в пин коде превышает допустимые 4 знака! " + pin, Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    private void checkPinMainActivity(String pin) { ///, Keystore keystore

        Keystore keystore = App.getKeystore();

        if (keystore.hasPin()) {
            keystore.saveNew(pin);
            Toast.makeText(this, "pin сохранен в pinCode SharedPreferences", Toast.LENGTH_SHORT).show();
        } else {
            if (keystore.matchPin(pin)) {
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                MainActivity.this.finish();
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Некорректный Пин код !!!", Toast.LENGTH_SHORT).show();
                clearTextViewPin();
            }
        }

    }

    private void clearTextViewPin() {
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText("");
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("");
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText("");
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText("");
        ImageView imageView1 = findViewById(R.id.imageView1);
        imageView1.setVisibility(View.VISIBLE);
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setVisibility(View.VISIBLE);
        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setVisibility(View.VISIBLE);
        ImageView imageView4 = findViewById(R.id.imageView4);
        imageView4.setVisibility(View.VISIBLE);
        pin = "";
    }





}