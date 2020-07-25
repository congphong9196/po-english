package com.example.recyclerview.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.ServerCourseListItemAdapter;
import com.example.recyclerview.data.Course;
import com.example.recyclerview.data.CourseDAO;
import com.example.recyclerview.data.Topic;
import com.example.recyclerview.data.TopicDAO;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.data.WordDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DownloadCourseListActivity extends AppCompatActivity
    implements ServerCourseListItemAdapter.DownloadButtonClickListener {

    private String TAG = "DownloadCourseListActivity";

    public static class ServerWord {
        private String value;
        private String meaning;
        private String topic;
        private String course;

        public ServerWord() {
            value = "value";
            meaning = "meaning";
            topic = "topic name";
        }

        public ServerWord(String course) {
            this.course = course;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
    }
    public static class ServerCourse {
        private String name;
        private String introduction;
        private int numberOfWords;
        private int numberOfTopics;

        // Firebase storage need this construction
        public ServerCourse() {
        }

        public ServerCourse(String name, int numberOfWords, int numberOfTopics) {
            this.name = name;
            this.introduction = name + " have " + numberOfTopics + " topics and " + numberOfWords + " words";
            this.numberOfWords = numberOfWords;
            this.numberOfTopics = numberOfTopics;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfWords() {
            return numberOfWords;
        }

        public void setNumberOfWords(int numberOfWords) {
            this.numberOfWords = numberOfWords;
        }

        public int getNumberOfTopics() {
            return numberOfTopics;
        }

        public void setNumberOfTopics(int numberOfTopics) {
            this.numberOfTopics = numberOfTopics;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }
    }

    private ServerCourseListItemAdapter adapter;
    private FirebaseFirestore fireStoreDb = FirebaseFirestore.getInstance();
    private CollectionReference courseCollection = fireStoreDb.collection("courses");
    private CollectionReference wordCollection = fireStoreDb.collection("words");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_course_list);

        RecyclerView recyclerViewServerCourseList = findViewById(R.id.recycleViewServerCourseList);
        recyclerViewServerCourseList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ServerCourseListItemAdapter(this, this);
        recyclerViewServerCourseList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        courseCollection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<ServerCourse> serverCourses =
                            Objects
                                    .requireNonNull(task.getResult())
                                    .toObjects(ServerCourse.class);
                    adapter.setItems(serverCourses);
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        });
    }

    @Override
    public void OnDownloadButtonClick(ServerCourse course) {
        DownloadCourse(course);
    }

    private void DownloadCourse(final ServerCourse course) {
        CourseDAO courseDAO = CourseDAO.fromContext(DownloadCourseListActivity.this);
        final Course courseInDb = courseDAO.addDefaultCourseIfNotExists(course.getName());

        wordCollection.whereEqualTo("course", course.getName()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<ServerWord> serverWords = Objects.requireNonNull(task.getResult()).toObjects(ServerWord.class);
                    addWordsToDatabase(serverWords, courseInDb);
                } else {
                    Toast.makeText(
                            DownloadCourseListActivity.this,
                            "Download course unsuccessful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addWordsToDatabase(List<ServerWord> serverWords, Course courseInDb) {
        List<String> topicNames = new ArrayList<>();
        for (ServerWord serverWord : serverWords) {
            if (!topicNames.contains(serverWord.getTopic())) {
                topicNames.add(serverWord.getTopic());
            }
        }

        TopicDAO topicDAO = TopicDAO.fromContext(DownloadCourseListActivity.this);
        for (String topicName : topicNames) {
            topicDAO.addTopicIfNotExists(new Topic(courseInDb.getId(), topicName));
        }

        WordDAO wordDAO = WordDAO.fromContext(DownloadCourseListActivity.this);
        List<Word> words = new ArrayList<>();
        for (ServerWord serverWord : serverWords) {
            words.add(new Word(serverWord.getTopic(), serverWord.getValue(), serverWord.getMeaning()));
        }
        wordDAO.addWord(words);

        Toast.makeText(
                DownloadCourseListActivity.this,
                "Download course " + courseInDb.getTitle() + " with " + topicNames.size() + " topics and " + words.size() + " words",
                Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }
}