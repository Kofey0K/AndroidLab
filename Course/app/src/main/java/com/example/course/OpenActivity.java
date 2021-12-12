package com.example.course;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course.utility.SaveLoad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(SaveLoad.loadText(this));
    }


}
