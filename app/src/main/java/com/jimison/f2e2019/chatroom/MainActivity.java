package com.jimison.f2e2019.chatroom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("config", MODE_PRIVATE);
        boolean isFirstOpen = pref.getBoolean("isFirstOpen",true);
        if(isFirstOpen){
            Intent it = new Intent(this,ViewPagerActivity.class);
            startActivity(it);
        }
    }
}
