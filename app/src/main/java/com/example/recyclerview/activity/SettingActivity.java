package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.R;

public class SettingActivity extends AppCompatActivity {
    private static final int REMIND_ACTIVITY_REQUEST = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button settingRemindButton = findViewById(R.id.setting_remind);
        settingRemindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, RemindActivity.class);
                startActivityForResult(intent, REMIND_ACTIVITY_REQUEST);
            }
        });
    }
}
