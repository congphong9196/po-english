package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.OnItemClickListener;
import com.example.recyclerview.data.CourseData;
import com.example.recyclerview.data.DatabaseInitializer;
import com.example.recyclerview.fragment.CourseFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    public static final String COURSE_DATA = "COURSE_DATA";
    public static MainActivity Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context = this;

        setContentView(R.layout.activity_main);
        nextFragment(new CourseFragment(this), R.id.fragmentContent);
        DatabaseInitializer.runInitialization(MainActivity.Context);
    }

    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    @Override
    public void onItemClick(CourseData courseData) {
        Intent intent = new Intent(MainActivity.this, CourseTopicActivity.class);
        intent.putExtra(COURSE_DATA, courseData.getTitle());
        startActivity(intent);
    }
}
