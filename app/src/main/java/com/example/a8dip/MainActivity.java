package com.example.a8dip;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                TextView textViewBackSpace = findViewById(R.id.textViewBackSpace);
                textViewBackSpace.setText("");
//                textViewBackSpace.append(button.getText());
            }
        });

    }

    private void setCalcClickListener(final TextView button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (button.getText().toString()) {
                    case "1" :
                        TextView textView1 = findViewById(R.id.textView1);
                        textView1.setText("1");
                    case "2" :
                        TextView textView2 = findViewById(R.id.textView2);
                        textView2.setText("2");
                    case "3" :
                        TextView textView3 = findViewById(R.id.textView3);
                        textView3.setText("3");
                    case "4" :
                        TextView textView4 = findViewById(R.id.textView4);
                        textView4.setText("4");
                }

            }
        });
    }
}