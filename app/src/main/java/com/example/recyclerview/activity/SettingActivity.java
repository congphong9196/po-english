package com.example.recyclerview.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.SettingAdapter;
import com.example.recyclerview.data.Setting;

import java.util.ArrayList;

import static com.example.recyclerview.data.DatabaseInitializer.DATABASE_INITIALIZED_KEY;

public class SettingActivity extends AppCompatActivity implements SettingAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    private static final int REMIND_ACTIVITY_REQUEST = 1001;
    private static final int DOWNLOAD_ACTIVITY_REQUEST = 1002;
    private static final int CLEAR_DATABASE_REQUEST = 1003;

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
        settings.add(new Setting(
                CLEAR_DATABASE_REQUEST,
                R.drawable.ic_baseline_clear_24,
                "Clear database",
                "Clear database for debugging, you need to restart you application"
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
            case CLEAR_DATABASE_REQUEST: {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean(DATABASE_INITIALIZED_KEY, false);
                editor.apply();
                break;
            }
        }
    }
}
