package com.example.backgroundbyposition.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.backgroundbyposition.R;
import com.example.backgroundbyposition.Service.PositionService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PositionService positionService = new PositionService(MainActivity.this);

        Intent intent = getIntent();
        processIntent(intent);

        Intent serviceIntent = new Intent(getApplicationContext(), PositionService.class);
        startService(serviceIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent);

    }

    private void processIntent(Intent intent){
        if(intent!=null){

        }
    }
}
