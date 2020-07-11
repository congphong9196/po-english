package com.example.recyclerview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.OnItemClickListener;
import com.example.recyclerview.data.Course;
import com.example.recyclerview.data.DatabaseInitializer;
import com.example.recyclerview.fragment.CourseFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    public static final String COURSE_DATA = "COURSE_DATA";
    public static Context Context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context = this;

        setContentView(R.layout.activity_main);
        nextFragment(new CourseFragment(this), R.id.fragmentContent);

        new DatabaseInitializer().runInitialization(this);
    }

    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();
    }

    @Override
    public void onItemClick(Course course) {
        Intent intent = new Intent(MainActivity.this, TopicActivity.class);
        intent.putExtra(COURSE_DATA, course.getTitle());
        startActivity(intent);
    }
}
