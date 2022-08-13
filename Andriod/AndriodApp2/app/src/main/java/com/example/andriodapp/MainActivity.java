package com.example.andriodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2, t3;
    Button add, sub, div, mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.Num1);
        t2 = findViewById(R.id.Num2);
        t3 = findViewById(R.id.Ans);

        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());

                int sums = n1 + n2;
                t3.setText(" " + sums + " ");
            }
        });

        sub = findViewById(R.id.SUB);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(t1.getText().toString());
                int n2 = Integer.parseInt(t2.getText().toString());
                int sums = n1 - n2;
                t3.setText(" " + sums + " ");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}