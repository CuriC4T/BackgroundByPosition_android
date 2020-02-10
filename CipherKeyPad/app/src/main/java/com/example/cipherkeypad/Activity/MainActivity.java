package com.example.cipherkeypad.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

import com.example.cipherkeypad.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private MainkeyBoard mainkeyBoard;
    private InputConnection ic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        MainkeyBoard mainkeyBoard = (MainkeyBoard)findViewById(R.id.keyboard);
        editText.setShowSoftInputOnFocus(false);

        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        mainkeyBoard.setInputConnection(ic);
    }


}
