package com.example.course;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    public BlankFragment() {
        super(R.layout.fragment_blank);
    }

    public void setSelectedItem(int size, String selectedItem) {
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(selectedItem);
        textView.setTextSize(size);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}