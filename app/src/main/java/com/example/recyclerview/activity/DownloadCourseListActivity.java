package com.example.recyclerview.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.ServerCourseListItemAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class DownloadCourseListActivity extends AppCompatActivity {

    public static class ServerCourse {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    private RecyclerView recyclerViewServerCourseList;
    private ServerCourseListItemAdapter adapter;
    private DatabaseReference coursesRef = FirebaseDatabase.getInstance().getReference("courses");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_course_list);

        recyclerViewServerCourseList = findViewById(R.id.recycleViewServerCourseList);
        recyclerViewServerCourseList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ServerCourseListItemAdapter(this);
        recyclerViewServerCourseList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Write a message to the database
        coursesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<ServerCourse>> serverCourseListType =
                        new GenericTypeIndicator<List<ServerCourse>>() {};
                List<ServerCourse> courses = snapshot.getValue(serverCourseListType);
                adapter.setItems(courses);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DownloadCourseListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}