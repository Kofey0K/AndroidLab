package com.example.course;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.course.utility.SaveLoad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContentFragment extends Fragment {

    interface OnFragmentSendDataListener {
        void onSendData(int size, String data);
    }
    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    public ContentFragment() {
        super(R.layout.fragment_content);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        final RadioButton radioButton1 = view.findViewById(R.id.radioButton);
        final RadioButton radioButton2 = view.findViewById(R.id.radioButton2);
        final EditText editText = view.findViewById(R.id.editText);
        final Button buttonOk = view.findViewById(R.id.button);
        Button buttonCancel = view.findViewById(R.id.button2);
        final Button buttonOpen = view.findViewById(R.id.button3);

        buttonOk.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            int textSize = 0;
                                            String string = editText.getText().toString();
                                            if (string.equals("")) {
                                                Toast toast1 = Toast.makeText(view.getContext(), R.string.empty_text_field, Toast.LENGTH_SHORT);
                                                toast1.show();
                                                return;
                                            }
                                            if (radioGroup.getCheckedRadioButtonId() == radioButton1.getId()) {
                                                //fragmentSendDataListener.onSendData(selectedItem);
                                                textSize = 14;
                                                //textView.setTextSize(14);
                                            } else {
                                                if (radioGroup.getCheckedRadioButtonId() == radioButton2.getId()) {
                                                    textSize = 18;
                                                    //textView.setTextSize(18);
                                                } else {
                                                    if (radioGroup.getCheckedRadioButtonId() == -1) {
                                                        Toast toast = Toast.makeText(view.getContext(), R.string.font_size_not_chosen, Toast.LENGTH_SHORT);
                                                        toast.show();
                                                        return;
                                                    }
                                                    ;
                                                }
                                            }
                                            fragmentSendDataListener.onSendData(textSize, string);
                                            //textView.setText(string);
                                        }
                                    }
        );
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.clearCheck();
                fragmentSendDataListener.onSendData(14, "");
                //textView.setText("");
                editText.setText("");
            }
        });

        buttonOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getActivity(), OpenActivity.class));
            }
        });
        final Button buttonClear = view.findViewById(R.id.button4);
        buttonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SaveLoad.clearFile(getActivity());
            }
        });

    }
}
