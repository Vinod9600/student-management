package com.example.android.studentmanagement.ui.splash;

/**
 * Created by Vinod on 11/12/2017.
 */

public class SplashScreenPresenterImp {

    SplashScreenContract.View view;

    public SplashScreenPresenterImp(SplashScreenContract.View view) {
        this.view = view;

        startThread();
    }

    private void startThread() {
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 2 seconds
                    sleep(2 * 1000);

                    view.lodeComplete();

                } catch (Exception e) {

                }
            }
        };

        background.start();
    }
}
