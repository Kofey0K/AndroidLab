package com.example.course;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ContentFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_container_view, ContentFragment.class, null)
//                    .commit();
//        }
    }

    @Override
    public void onSendData(int size, String selectedItem) {
        BlankFragment fragment = (BlankFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null) {
            fragment.setSelectedItem(size, selectedItem);
            fragment.saveData(size, selectedItem);
        }
    }

}