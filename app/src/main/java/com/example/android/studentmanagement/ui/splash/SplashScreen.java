package com.example.android.studentmanagement.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.studentmanagement.R;
import com.example.android.studentmanagement.ui.home.HomeScreen;

public class SplashScreen extends AppCompatActivity implements SplashScreenContract.View {

    private SplashScreenPresenterImp splashScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreenPresenter = new SplashScreenPresenterImp((SplashScreenContract.View) SplashScreen.this);
    }

    @Override
    public void lodeComplete() {
        Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
}
