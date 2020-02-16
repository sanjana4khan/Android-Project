package com.example.user.pipilika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_screenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mythread=new Thread(){
            @Override
            public void run()
            {
                try{
                    sleep(5000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                   }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

    }
}
