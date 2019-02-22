package com.example.lesson2hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        final TextView textView2 = findViewById(R.id.textView2);
        final TextView textView4 = findViewById(R.id.textView4);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText(String.valueOf(editText1.getText()));
                editText1.setText("");
                textView4.setText("");
            }
        });
    }
}
