package com.example.lr2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Double firstNumber = 0.0;
    Double secondNumber = 0.0;
    char lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        StringBuilder displayedText = new StringBuilder(100);

        TextView screen = findViewById(R.id.screen);
        Button clear = findViewById(R.id.button_clear);
        Button backspace = findViewById(R.id.button_backspace);
        Button seven = findViewById(R.id.button_7);
        Button eight = findViewById(R.id.button_8);
        Button nine = findViewById(R.id.button_9);
        Button div = findViewById(R.id.button_div);
        Button four = findViewById(R.id.button_4);
        Button five = findViewById(R.id.button_5);
        Button six = findViewById(R.id.button_6);
        Button multi = findViewById(R.id.button_multi);
        Button one = findViewById(R.id.button_1);
        Button two = findViewById(R.id.button_2);
        Button three = findViewById(R.id.button_3);
        Button minus = findViewById(R.id.button_minus);
        Button dot = findViewById(R.id.button_dot);
        Button zero = findViewById(R.id.button_0);
        Button eq = findViewById(R.id.button_eq);
        Button plus = findViewById(R.id.button_plus);

        clear.setOnClickListener(v -> {
            firstNumber = 0.0;
            secondNumber = 0.0;
            displayedText.setLength(0);
            screen.setText(displayedText);
        });

        backspace.setOnClickListener(v -> {
            if (displayedText.length() > 0) {
                displayedText.setLength(displayedText.length() - 1);
                screen.setText(displayedText);
            }
        });

        seven.setOnClickListener(v -> {
            displayedText.append("7");
            screen.setText(displayedText);
        });

        eight.setOnClickListener(v -> {
            displayedText.append("8");
            screen.setText(displayedText);
        });

        nine.setOnClickListener(v -> {
            displayedText.append("9");
            screen.setText(displayedText);
        });

        four.setOnClickListener(v -> {
            displayedText.append("4");
            screen.setText(displayedText);
        });

        five.setOnClickListener(v -> {
            displayedText.append("5");
            screen.setText(displayedText);
        });

        six.setOnClickListener(v -> {
            displayedText.append("6");
            screen.setText(displayedText);
        });

        one.setOnClickListener(v -> {
            displayedText.append("1");
            screen.setText(displayedText);
        });

        two.setOnClickListener(v -> {
            displayedText.append("2");
            screen.setText(displayedText);
        });

        three.setOnClickListener(v -> {
            displayedText.append("3");
            screen.setText(displayedText);
        });

        zero.setOnClickListener(v -> {
            displayedText.append("0");
            screen.setText(displayedText);
        });

        dot.setOnClickListener(v -> {
            displayedText.append(".");
            screen.setText(displayedText);
        });

        plus.setOnClickListener(v -> {
            lastAction = '+';
            // FIXME: 12 + 12 + 12 doesn't work
            if ((firstNumber != 0.0) && (secondNumber != 0.0)) {
                firstNumber += secondNumber;
                firstNumber += Double.parseDouble(displayedText.toString());
                secondNumber = 0.0;
                displayedText.setLength(0);
                displayedText.append(firstNumber);
                screen.setText(displayedText.toString());
            } else {
                if (firstNumber == 0.0) {
                    firstNumber = Double.parseDouble(displayedText.toString());
                    displayedText.setLength(0);
                } else if (secondNumber == 0.0) {
                    secondNumber = Double.parseDouble(displayedText.toString());
                    displayedText.setLength(0);
                }
                screen.setText(displayedText.toString());
            }
        });

        eq.setOnClickListener(v -> {
            secondNumber = Double.parseDouble(displayedText.toString());
            if (lastAction == '+') {
                firstNumber += secondNumber;
            } else if (lastAction == '-') {
                firstNumber -= secondNumber;
            } else if (lastAction == '*') {
                firstNumber *= secondNumber;
            } else if (lastAction == '/') {
                firstNumber /= secondNumber;
            }
            displayedText.setLength(0);
            displayedText.append(firstNumber);
            screen.setText(displayedText.toString());
        });

        minus.setOnClickListener(v -> {
            lastAction = '-';
            if (firstNumber == 0.0) {
                firstNumber = Double.parseDouble(displayedText.toString());
            } else if (secondNumber == 0.0) {
                secondNumber = Double.parseDouble(displayedText.toString());
            }
            displayedText.setLength(0);
            screen.setText(displayedText.toString());
        });

        multi.setOnClickListener(v -> {
            lastAction = '*';
            if (firstNumber == 0.0) {
                firstNumber = Double.parseDouble(displayedText.toString());
            } else if (secondNumber == 0.0) {
                secondNumber = Double.parseDouble(displayedText.toString());
            }
            displayedText.setLength(0);
            screen.setText(displayedText.toString());
        });

        div.setOnClickListener(v -> {
            lastAction = '/';
            if (firstNumber == 0.0) {
                firstNumber = Double.parseDouble(displayedText.toString());
            } else if (secondNumber == 0.0) {
                secondNumber = Double.parseDouble(displayedText.toString());
            }
            displayedText.setLength(0);
            screen.setText(displayedText.toString());
        });

    }
}