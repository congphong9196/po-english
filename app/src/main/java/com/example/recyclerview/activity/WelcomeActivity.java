package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.recyclerview.R;
import com.example.recyclerview.data.DatabaseInitializer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Welcome activity will show up the logo of PO english and initialize database
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();

        InitDatabaseInThread();
    }

    private void InitDatabaseInThread() {
        final WelcomeActivity this_ = this;
        Thread initializeDatabaseThread = new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseInitializer databaseInitializer = new DatabaseInitializer();
                databaseInitializer.runInitialization(this_);

                if (databaseInitializer.isRunDatabaseInitialization()) {
                    this_.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            GoToMainActivity();
                        }
                    });
                } else {
                    try {
                        Thread.sleep(2000);
                        GoToMainActivity();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        initializeDatabaseThread.start();
    }

    private void GoToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}