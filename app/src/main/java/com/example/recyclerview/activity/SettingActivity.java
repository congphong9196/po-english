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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    public void initView() {
        recyclerView = findViewById(R.id.recyclerview_setting_remind);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Setting> settings = new ArrayList<>();
        settings.add(new Setting(
                R.drawable.ic_alarm,
                "Setting remind",
                "Reinstall your reminder clock"
        ));

        SettingAdapter settingAdapter = new SettingAdapter(getApplicationContext(), settings, this);
        recyclerView.setAdapter(settingAdapter);
    }

    @Override
    public void onItemClick(Setting setting) {
        Intent intent = new Intent(SettingActivity.this, RemindActivity.class);
        startActivityForResult(intent, REMIND_ACTIVITY_REQUEST);
    }
}
