package com.example.receicebroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MY_ACTION = "codefresher.ACTION";
    private static final String MY_TEXT1 = "codefresher.TEXT1";
    private static final String MY_TEXT2 = "codefresher.TEXT2";
    private static final String MY_TEXT3 = "codefresher.TEXT3";

    private TextView tv_Receive1;
    private TextView tv_Receive2;
    private TextView tv_Receive3;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(MY_ACTION.equals(intent.getAction()))
            {
                String text1 = intent.getStringExtra(MY_TEXT1);
                tv_Receive1.setText(text1);
                String text2 = intent.getStringExtra(MY_TEXT2);
                tv_Receive2.setText(text2);
                String text3 = intent.getStringExtra(MY_TEXT3);
                tv_Receive3.setText(text3);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_Receive1 = findViewById(R.id.tv_receice1);
        tv_Receive2 = findViewById(R.id.tv_receice2);
        tv_Receive3 = findViewById(R.id.tv_receice3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver , intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }
}