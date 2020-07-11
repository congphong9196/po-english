package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.data.ConstSaveData;
import com.example.recyclerview.notification.NotificationReceiver;
import com.example.recyclerview.R;

import java.util.Calendar;

public class RemindActivity extends AppCompatActivity {

    private Button btnDone;
    private TextView txtIgnore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);

        btnDone = (Button) findViewById(R.id.btnDone);
        txtIgnore = (TextView) findViewById(R.id.txtIgnore);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String hoursMinute = sharedPreferences.getString("Remind", "");
        int hours = 0, minute = 0;
        if (!hoursMinute.equals("")) {
            String[] split = hoursMinute.trim().split("\\|");
            hours = Integer.parseInt(split[0].trim());
            minute = Integer.parseInt(split[1].trim());
        }

        final NumberPicker txtHours = (NumberPicker) findViewById(R.id.txtHours);
        txtHours.setMaxValue(23);
        txtHours.setMinValue(0);
        txtHours.setValue(hours);

        final NumberPicker txtMinute = (NumberPicker) findViewById(R.id.txtMinute);
        txtMinute.setMaxValue(59);
        txtMinute.setMinValue(0);
        txtMinute.setValue(minute);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =
                        PreferenceManager.getDefaultSharedPreferences(RemindActivity.this).edit();
                editor.putString("Remind", txtHours.getValue() + "|" + txtMinute.getValue());
                editor.apply();

                //alarm nhắc nhở
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, txtHours.getValue());
                calendar.set(Calendar.MINUTE, txtMinute.getValue());
                //calendar.set(Calendar.SECOND, 0);

                Intent intent = new Intent(RemindActivity.this, NotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(RemindActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) RemindActivity.this.getSystemService(ALARM_SERVICE);
                if (alarmManager != null) {
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                }
                Toast.makeText(RemindActivity.this, "Save successfully!", Toast.LENGTH_SHORT).show();

                SaveDataTypeNumberByName(ConstSaveData.DADATNHACNHO, 1);

                Intent intentMain = new Intent(RemindActivity.this, MainActivity.class);
                startActivity(intentMain);

            }

        });
        txtIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private int GetDataTypeNumberByName(String NameData, int ValueDefault){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int value = sp.getInt(NameData, ValueDefault);
        return value;
    }

    private void SaveDataTypeNumberByName(String NameData, int value){
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putInt(NameData, value);
        editor.apply();
    }
}
