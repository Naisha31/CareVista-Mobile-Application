package com.example.carevista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;

public class splash extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        /** Sets a layout for this activity */
        setContentView(R.layout.activity_splash);

        /** Creates a count down timer, which will be expired after 5000 milliseconds */
        new CountDownTimer(5000,1000) {

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                startActivity(intent);

                finish();

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }
}