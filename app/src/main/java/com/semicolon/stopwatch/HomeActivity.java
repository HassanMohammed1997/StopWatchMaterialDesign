package com.semicolon.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    Animation rotateAnim;
    ImageView anchorImage;
    Button startButton;
    Button finishBtn;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        finishBtn = findViewById(R.id.button);

        finishBtn.setAlpha(0.0f);
        chronometer = findViewById(R.id.chronometer);


        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        anchorImage = findViewById(R.id.anchor_image);
        startButton = findViewById(R.id.button2);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishBtn.animate().alpha(1.0f).setDuration(300).translationY(-80).start();
                startButton.animate().alpha(0.0f).setDuration(300).start();

                anchorImage.startAnimation(rotateAnim);

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();


            }
        });


    }

    public void finish(View view) {
        anchorImage.clearAnimation();
        startButton.animate().alpha(1.0f).start();
        chronometer.stop();

    }
}
