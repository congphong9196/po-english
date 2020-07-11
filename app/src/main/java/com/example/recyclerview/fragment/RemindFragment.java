package com.example.recyclerview.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.recyclerview.activity.MainActivity;
import com.example.recyclerview.notification.NotificationReceiver;
import com.example.recyclerview.R;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.ALARM_SERVICE;

public class RemindFragment extends Fragment {
    public static RemindFragment remindFragment;
    public static RemindFragment newInstant() {
        if(remindFragment == null) {
            remindFragment = new RemindFragment();

        }
        return remindFragment;
    }

    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.fragment_remind, container, false);

        btnSave = (Button) view.findViewById(R.id.btnSave);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.Context);
        String hoursMinute = sharedPreferences.getString("Remind", "");
        int hours = 0, minute = 0;
        if (!hoursMinute.equals("")) {
            String[] split = hoursMinute.trim().split("\\|");
            hours = Integer.parseInt(split[0].trim());
            minute = Integer.parseInt(split[1].trim());
        }

        final NumberPicker txtHours = (NumberPicker) view.findViewById(R.id.txtHours);
        txtHours.setMaxValue(23);
        txtHours.setMinValue(0);
        txtHours.setValue(hours);

        final NumberPicker txtMinute = (NumberPicker) view.findViewById(R.id.txtMinute);
        txtMinute.setMaxValue(59);
        txtMinute.setMinValue(0);
        txtMinute.setValue(minute);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =
                        PreferenceManager.getDefaultSharedPreferences(MainActivity.Context).edit();
                editor.putString("Remind", txtHours.getValue() + "|" + txtMinute.getValue());
                editor.apply();

                //alarm nhắc nhở
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, txtHours.getValue());
                calendar.set(Calendar.MINUTE, txtMinute.getValue());
                //calendar.set(Calendar.SECOND, 0);

                Intent intent = new Intent(MainActivity.Context, NotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.Context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) MainActivity.Context.getSystemService(ALARM_SERVICE);
                if (alarmManager != null) {
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                }

                Toast.makeText(MainActivity.Context, "Save successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
