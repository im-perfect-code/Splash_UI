package com.imperfectcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private int progressCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final AppCompatSeekBar seekBar = findViewById(R.id.seekBar);
        final AppCompatImageView imgLogo = findViewById(R.id.imgLogo);

        CountDownTimer downTimer = new CountDownTimer(5000, 25) {
            @Override
            public void onTick(long l) {
                seekBar.setProgress(progressCount);
                progressCount++;
            }

            @Override
            public void onFinish() {

            }
        }.start();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imgLogo.setAnimation(animation);
    }
}