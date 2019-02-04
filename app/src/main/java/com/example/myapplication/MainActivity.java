package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView infoTextView;
    TextView numberTextView;
    Button lowerButton;
    Button correctButton;
    Button higherButton;

    //Game Properties
    int min = 0;
    int max = 1000;
    int guessed = max/2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    public void Init()
    {
        Random r = new Random();
        System.out.println(r.nextInt(1000));
        infoTextView = findViewById(R.id.text_view_info);
        numberTextView = findViewById(R.id.text_view_number);
        lowerButton = findViewById(R.id.button_lower);
        correctButton = findViewById(R.id.button_correct);
        higherButton = findViewById(R.id.button_higher);
        UpdateNumberText();
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("GAME FINISHED");
            }
        });

        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                max = guessed;
                guessed = (max +min)/ 2;
                UpdateNumberText();
            }
        });
        higherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min = guessed;
                guessed = (max + min) / 2;
                UpdateNumberText();
            }
        });
    }

    public void UpdateNumberText()
    {
        numberTextView.setText("Is your number : " + guessed);
    }

}
