package com.example.recyclerview.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DatabaseInitializer implements DataInitializable{
    public static final String DATABASE_INITIALIZED_KEY = "DatabaseInitialized";
    boolean isRunDatabaseInitialization = false;

    @Override
    public void runInitialization(Context context) {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isDatabaseInitialized = sp.getBoolean(DATABASE_INITIALIZED_KEY, false);

        if (!isDatabaseInitialized) {
            isRunDatabaseInitialization = true;
            DatabaseHelper db = new DatabaseHelper(context);
            db.dropTables();
            db.createTables();

            new CourseInitializer().runInitialization(context);
            new TopicInitializer().runInitialization(context);
            new WordInitializer().runInitialization(context);

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(DATABASE_INITIALIZED_KEY, true);
            editor.apply();
        } else {
            isRunDatabaseInitialization = false;
        }
    }

    public boolean isRunDatabaseInitialization() {
        return isRunDatabaseInitialization;
    }
}
