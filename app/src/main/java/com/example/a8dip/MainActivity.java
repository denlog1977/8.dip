package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setCalcClickListener((TextView) findViewById(R.id.textViewButton0));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton1));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton2));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton3));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton4));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton5));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton6));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton7));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton8));
        setCalcClickListener((TextView) findViewById(R.id.textViewButton9));
        setCalcClickListener((TextView) findViewById(R.id.textViewBackSpace));

        TextView textViewBackSpace = findViewById(R.id.textViewBackSpace);
        textViewBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

            }
        });

    }

    private void setCalcClickListener(final TextView button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pin = pin + button.getText().toString();
                if (pin.length() < 5) {
                switch (pin.length()) {
                    case 1 :
                        TextView textView1 = findViewById(R.id.textView1);
                        textView1.setText("1");
                        Toast.makeText(MainActivity.this, "case 1", Toast.LENGTH_SHORT).show();
                        ImageView imageView1 = findViewById(R.id.imageView1);
                        imageView1.setVisibility(View.INVISIBLE);
                        break;
                    case 2 :
                        TextView textView2 = findViewById(R.id.textView2);
                        textView2.setText("2");
                        Toast.makeText(MainActivity.this, "case 2", Toast.LENGTH_SHORT).show();
                        ImageView imageView2 = findViewById(R.id.imageView2);
                        imageView2.setVisibility(View.INVISIBLE);
                        break;
                    case 3 :
                        TextView textView3 = findViewById(R.id.textView3);
                        textView3.setText("3");
                        Toast.makeText(MainActivity.this, "case 3", Toast.LENGTH_SHORT).show();
                        ImageView imageView3 = findViewById(R.id.imageView3);
                        imageView3.setVisibility(View.INVISIBLE);
                        break;
                    case 4 :
                        TextView textView4 = findViewById(R.id.textView4);
                        textView4.setText("4");
                        Toast.makeText(MainActivity.this, "case 4", Toast.LENGTH_SHORT).show();
                        ImageView imageView4 = findViewById(R.id.imageView4);
                        imageView4.setVisibility(View.INVISIBLE);

                        Toast.makeText(MainActivity.this, "PIN = " + pin, Toast.LENGTH_SHORT).show();

                        break;
                }

                } else {
                    Toast.makeText(MainActivity.this, "ХАРЕМБА !!! " + pin, Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}