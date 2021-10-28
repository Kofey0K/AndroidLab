package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        if(string.equals("")){
            Toast toast1 = Toast.makeText(getApplicationContext(), "Пустое текстовое поле!", Toast.LENGTH_SHORT);
            toast1.show();
            return;
        }
        if(radioGroup.getCheckedRadioButtonId() == radioButton1.getId()){
            textView.setTextSize(14);
        }
        else{
            if(radioGroup.getCheckedRadioButtonId() == radioButton2.getId()){
                textView.setTextSize(18);
            }
            else{
                if(radioGroup.getCheckedRadioButtonId()==-1){
                    Toast toast = Toast.makeText(getApplicationContext(), "Не выбран размер шрифта!", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                };
            }
        }

        textView.setText(string);

    }

    public void funcCancel(View view) {
        radioGroup.clearCheck();
        textView.setText("");
        editText.setText("");
    }
}