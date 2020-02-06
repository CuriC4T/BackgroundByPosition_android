package com.example.cipherkeypad;


import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;

public class MainkeyBoard extends InputMethodService implements View.OnClickListener {



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


        switch(v.getId()){

        }
    }

    public boolean init() {
        boolean flag = false;

        button1 = new Button[3];
        
        for (int i = 0; i < 3; i++) {

        }

        return flag;
    }


}

