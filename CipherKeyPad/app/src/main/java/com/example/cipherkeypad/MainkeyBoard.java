package com.example.cipherkeypad;


import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainkeyBoard extends InputMethodService implements View.OnClickListener{
    LinearLayout[] vertical_LinearLayout;
    LinearLayout[] horizen_LinearLayout;


    Button[] button1;


    public MainkeyBoard() {
        boolean flag = false;
        flag = init();
        if (flag) {
        } else {
            return;
        }


    }

    @Override
    public View onCreateInputView() {
        return super.onCreateInputView();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

        }
    }

    public boolean init() {
        boolean flag = true;

        button1 = new Button[3];
        LinearLayout[] vertical_LinearLayout= new LinearLayout[5];
        for (LinearLayout linearlayout : vertical_LinearLayout)
        for (int i = 0; i < 3; i++) {

        }

        return flag;
    }


}

