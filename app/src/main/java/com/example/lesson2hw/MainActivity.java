package com.example.lesson2hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        final TextView textView2 = findViewById(R.id.textView2);
        final TextView textView4 = findViewById(R.id.textView4);
        final TextView textView6 = findViewById(R.id.textView6);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "Введите название города", Toast.LENGTH_LONG).show();
                } else {
                    textView2.setText(String.valueOf(editText1.getText()));
                    editText1.setText("");
                    textView4.setText("20 градусов");
                    textView6.setText("без осадков");
                }

            }
        });
    }
}
