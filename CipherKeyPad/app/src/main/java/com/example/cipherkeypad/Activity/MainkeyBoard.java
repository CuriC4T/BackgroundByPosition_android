package com.example.cipherkeypad.Activity;


import android.content.Context;
import android.security.keystore.KeyExpiredException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cipherkeypad.Cryption.AES256;
import com.example.cipherkeypad.R;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainkeyBoard extends LinearLayout implements View.OnClickListener {
    private AES256 aes256;
    private Context context;
    private InputConnection ic = null;
    private Button[] button_Array;
    private String key;

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
        try {
            key = "hyunjaewook12345";
            aes256 = new AES256(key);
            buttonSetting(1);

        } catch (UnsupportedEncodingException e) {
            Log.e("CRYPTION_ERROR", "error");
        }
    }

    public void buttonSetting(int buttonMode) {


        switch (buttonMode) {
            //todo CASE, array 사이즈 변수화
            case 1:
                randomKeyPad();
                break;
            case 2:
                break;
            default:
                break;
        }


    }

    private void randomKeyPad() {

        //todo 랜덤 세팅
        int resource_id;
        button_Array = new Button[14];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int array_setting[] = new int[14];


        for (int i = 0; i < 14; i++) {

            array_setting[i] = i;
        }
        //array 초기

        for (int i = 0; i < 3 * 12; i++) {
            int x = random.nextInt(12);
            int y = random.nextInt(12);
            int value_x = array_setting[x];
            int value_y = array_setting[y];
            int temp = value_x;
            array_setting[x] = value_y;
            array_setting[y] = temp;

        }//0~11까지 포지션 스위칭 36번 믹스


        for (int i = 0; i < 14; i++) {
            resource_id = getResources().getIdentifier("key_".concat(String.valueOf(i)), "id", context.getPackageName());

            //10,11은 공백 세팅
            if (array_setting[i] > 9 && array_setting[i] < 12) {
                button_Array[i] = (Button) findViewById(resource_id);
                button_Array[i].setText(String.valueOf(String.valueOf(-1)));
                button_Array[i].setOnClickListener(null);
                button_Array[i].setClickable(false);


                //나머지는 배열 값이 키값
            } else {
                button_Array[i] = (Button) findViewById(resource_id);
                button_Array[i].setText(String.valueOf(String.valueOf(array_setting[i])));
                button_Array[i].setOnClickListener(this);
                button_Array[i].setClickable(true);

            }

        }


    }

    private void e_qwertyKeyboard() {

    }

    private void k_qwertyKeyboard() {

    }

    @Override
    public void onClick(View v) {
        int resource_id;
        Button d = (Button) findViewById(v.getId());

        String text = String.valueOf(d.getText());
        String encrypted;
        String decrypted;
        EditText encrypted_textview;
        EditText decrypted_textview;
        try {
            encrypted = aes256.aesEncode(text);
            if (encrypted != null) {
                switch (v.getId()) {
                    case R.id.key_12:
                        randomKeyPad();
                        break;
                    case R.id.key_13:
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
                        ic.commitText(text, 1);

                        break;
                }
                decrypted = aes256.aesDecode(encrypted);

                Log.d("eeeeeee",encrypted);
                Log.d("eeeeeee",decrypted);
                LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View view = inflater.inflate(R.layout.activity_main, null);



                resource_id = view.getResources().getIdentifier("decrypted", "id", context.getPackageName());
                decrypted_textview = (EditText) view.findViewById(resource_id);

                if(decrypted_textview==null){
                    Log.d("eeeeeee",String.valueOf(resource_id));

                    Log.d("eeeeeee",context.getPackageName());

                }
                decrypted_textview.setText(decrypted);

                resource_id = view.getResources().getIdentifier("encrypted", "id", context.getPackageName());
                encrypted_textview = (EditText) view.findViewById(resource_id);

                if(encrypted_textview==null){
                    Log.d("eeeeeee",String.valueOf(resource_id));

                    Log.d("eeeeeee",context.getPackageName());

                }
                encrypted_textview.setText(encrypted);
                //view.invalidate();



            }
        } catch (NoSuchAlgorithmException e) {

        } catch (UnsupportedEncodingException e) {

        } catch (NoSuchPaddingException e) {

        } catch (InvalidKeyException e) {

        } catch (InvalidAlgorithmParameterException e) {

        } catch (IllegalBlockSizeException e) {

        } catch (BadPaddingException e) {

        }


    }

    public boolean init() {
        boolean flag = true;

        return flag;
    }


}

