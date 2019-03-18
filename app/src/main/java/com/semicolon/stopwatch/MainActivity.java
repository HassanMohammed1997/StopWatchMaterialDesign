package com.semicolon.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation alphaAnim, translateAnim, anim;
    TextView splashTv, subSplashTv;
    Button splashBtn, finishBtn;

    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashImage = findViewById(R.id.imageView);
        splashTv = findViewById(R.id.textView);
        subSplashTv = findViewById(R.id.textView2);
        splashBtn = findViewById(R.id.splash_btn);



        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        translateAnim = AnimationUtils.loadAnimation(this, R.anim.btgone);
        anim = AnimationUtils.loadAnimation(this, R.anim.btgtwo);



        splashImage.startAnimation(alphaAnim);
        splashTv.startAnimation(translateAnim);
        subSplashTv.startAnimation(anim);
        splashBtn.startAnimation(anim);
    }

    public void getStarted(View view) {
        Intent in = new Intent(this, HomeActivity.class);
        startActivity(in);




    }
}
