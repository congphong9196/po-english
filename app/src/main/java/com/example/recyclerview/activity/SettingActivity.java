package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.SettingAdapter;
import com.example.recyclerview.data.Setting;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity implements SettingAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    private static final int REMIND_ACTIVITY_REQUEST = 1001;
    private static final int DOWNLOAD_ACTIVITY_REQUEST = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    public void initView() {
        recyclerView = findViewById(R.id.recyclerview_setting_remind);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new Setting(
                REMIND_ACTIVITY_REQUEST,
                R.drawable.ic_alarm,
                "Setting remind",
                "Reinstall your reminder clock"
        ));
        settings.add(new Setting(
                DOWNLOAD_ACTIVITY_REQUEST,
                R.drawable.ic_baseline_cloud_download_24,
                "Download course from server",
                "Download course from server to work on local"
        ));

        SettingAdapter settingAdapter = new SettingAdapter(getApplicationContext(), settings, this);
        recyclerView.setAdapter(settingAdapter);
    }

    @Override
    public void onItemClick(Setting setting) {
        switch (setting.getId()) {
            case REMIND_ACTIVITY_REQUEST: {
                finish();
                Intent intent = new Intent(SettingActivity.this, RemindActivity.class);
                startActivityForResult(intent, setting.getId());
                break;
            }
            case DOWNLOAD_ACTIVITY_REQUEST: {
                finish();
                Intent intent = new Intent(SettingActivity.this, DownloadCourseListActivity.class);
                startActivityForResult(intent, setting.getId());
                break;
            }

        }
    }
}
