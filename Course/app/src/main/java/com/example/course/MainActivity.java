package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

    }

    public void funcOK(View view) {
        String string = editText.getText().toString();
        textView.setText(string);
        if(radioGroup.getCheckedRadioButtonId() == radioButton1.getId()){
            textView.setTextSize(14);
        }
        else{
            if(radioGroup.getCheckedRadioButtonId() == radioButton2.getId()){
                textView.setTextSize(18);
            };
        }

    }

    public void funcCancel(View view) {
        radioGroup.clearCheck();
        textView.setText("");
        editText.setText("");
    }
}