package com.example.cipherkeypad;


import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainkeyBoard extends LinearLayout implements View.OnClickListener {

    private Context context;
    private InputConnection ic = null;
    private Button[] button_Array;

    public MainkeyBoard(Context context) {
        this(context, null, 0);
    }

    public MainkeyBoard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainkeyBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void setInputConnection(InputConnection ic) {
        if (ic != null) {
            this.ic = ic;
        }
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.keyboard_layout, this, true);
        buttonSetting(1);
    }

    public void buttonSetting(int buttonMode) {


        switch (buttonMode) {
            //todo CASE, array 사이즈 변수화
            case 1:
                randomKeyPad();
                break;
            default:
                break;
        }


    }

    private void randomKeyPad() {

        //todo 랜덤 세팅
        String button_value = "";
        int resource_id;
        button_Array = new Button[14];
        Random random = new Random();
        random.setSeed(1);
        int random_number;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList;

        while(set.size()<10){
            random_number = random.nextInt(10);
            Log.d("dd",String.valueOf(random_number));
            set.add(random_number);


        }
        arrayList = new ArrayList<>(set);
        for(int i=0;i<arrayList.size();i++){
            resource_id = getResources().getIdentifier("key_".concat(String.valueOf(arrayList.get(i))), "id", context.getPackageName());
            Log.d("ddaaaa",String.valueOf(arrayList.get(i)));

//            button_Array[arrayList.get(i)] = (Button) findViewById(resource_id);
//            button_Array[arrayList.get(i)].setText(String.valueOf(arrayList.get(i)));
//            button_Array[arrayList.get(i)].setOnClickListener(this);
        }


        for (int i = 13; i < 14; i++) {
            resource_id = getResources().getIdentifier("key_".concat(String.valueOf(i + 1)), "id", context.getPackageName());

            button_value = String.valueOf(i + 1);
            button_Array[i] = (Button) findViewById(resource_id);
            button_Array[i].setOnClickListener(this);

            button_Array[i].setText(button_value);

            //button_Array[i].setTag();

        }



    }


    @Override
    public void onClick(View v) {
        Button d = (Button) findViewById(v.getId());

        String dd = String.valueOf(d.getText());
        switch (v.getId()) {
            case R.id.key_13:
                break;
            case R.id.key_14:
                CharSequence selectedText = ic.getSelectedText(0);

                if (TextUtils.isEmpty(selectedText)) {
                    //블럭된게 없을 시
                    ic.deleteSurroundingText(1, 0);
                } else {
                    //블럭된게 있을시
                    ic.commitText("", 1);
                }
                break;
            default:
                ic.commitText(dd, 1);

                break;
        }


    }

    public boolean init() {
        boolean flag = true;

        return flag;
    }


}

