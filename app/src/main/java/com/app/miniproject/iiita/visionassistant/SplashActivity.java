package com.app.miniproject.iiita.visionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        animationView = findViewById(R.id.animationView);
        animationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                finish();
            }
        }, 5000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animationView != null) {
            animationView.cancelAnimation();
        }
    }
}