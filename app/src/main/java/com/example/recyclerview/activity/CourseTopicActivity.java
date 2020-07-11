package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.adapter.CourseTopicAdapter;
import com.example.recyclerview.data.CourseTopic;
import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.WordCategory;
import com.example.recyclerview.fragment.CourseFragment;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CourseTopicActivity extends AppCompatActivity implements CourseTopicAdapter.OnItemClickListener {

    public static final String TOPIC_NAME = "TOPIC_NAME";

    public static final String FAMILY = "Family";
    public static final String ANIMAL = "Animal";
    public static final String CLOTHES = "Clothes";
    public static final String COLOR = "Color";
    public static final String FRUIT = "Fruit";
    public static final String COOKING = "Cooking";
    public static final String MUSIC = "Music";
    public static final String NUMBER = "Number";
    public static final String SCHOOL = "School";
    public static final String SPORT = "Sport";
    public static final String TRAFFIC = "Traffic";
    public static final String VEGETABLES = "Vegetables";
    public static final String WEATHER = "Weather";
    public static final String HOSPITAL = "Hospital";
    public static final String RESTAURANT = "Restaurant";
    public static final String ADJECTIVE = "Adjective";
    public static final String ACTION = "Action";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_basic_english);

        Intent parentIntent = getIntent();
        String courseTitle = parentIntent.getStringExtra(MainActivity.COURSE_DATA);
        String courseTitleStr = "";

        ArrayList<CourseTopic> courseTopics = new ArrayList<>();
        switch (courseTitle) {
            case CourseFragment.BASIC_ENGLISH:
                courseTitleStr = "Basic English";
                courseTopics = createBasicEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.ENGLISH_FOR_CHILDREN:
                courseTitleStr = "English for Children";
                courseTopics = createChildrenEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.ENGLISH_FOR_HIGH_SCHOOL:
                courseTitleStr = "English for High school";
                courseTopics = createHighSchoolEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.ENGLISH_FOR_OFFICE:
                courseTitleStr = "English for Office";
                courseTopics = createOfficeEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.ENGLISH_FOR_PROGRAMMING:
                courseTitleStr = "English for Programming";
                courseTopics = createProgrammingEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.ENGLISH_FOR_TRAVEL:
                courseTitleStr = "English for Travel";
                courseTopics = createTravelEnglishCourseTopics(courseTitleStr);
                break;
            case CourseFragment.IELTS:
                courseTitleStr = "Ielts";
                courseTopics = createIeltsCourseTopics(courseTitleStr);
                break;
            case CourseFragment.TOEIC:
                courseTitleStr = "Toeic";
                courseTopics = createToeicCourseTopics(courseTitleStr);
                break;
        }

        RecyclerView recyclerView = findViewById(R.id.basicEnglishRecyclerView);
        CourseTopicAdapter basicEnglishAdapter =
                new CourseTopicAdapter(CourseTopicActivity.this, courseTopics, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(basicEnglishAdapter);

        setTitle(courseTitleStr);
    }

    ArrayList<CourseTopic> createBasicEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListBasicEnglish = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(MainActivity.Context);
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.ANIMAL,
                helper.getNumberOfWordsByCategory(WordCategory.ANIMAL)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.FAMILY,
                helper.getNumberOfWordsByCategory(WordCategory.FAMILY)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.CLOTHES,
                helper.getNumberOfWordsByCategory(WordCategory.CLOTHES)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.COLOR,
                helper.getNumberOfWordsByCategory(WordCategory.COLOR)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.FRUIT,
                helper.getNumberOfWordsByCategory(WordCategory.FRUIT)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.COOKING,
                helper.getNumberOfWordsByCategory(WordCategory.COOKING)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.MUSIC,
                helper.getNumberOfWordsByCategory(WordCategory.MUSIC)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.NUMBER,
                helper.getNumberOfWordsByCategory(WordCategory.NUMBER)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.SCHOOL,
                helper.getNumberOfWordsByCategory(WordCategory.SCHOOL)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.SPORT,
                helper.getNumberOfWordsByCategory(WordCategory.SPORT)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.TRAFFIC,
                helper.getNumberOfWordsByCategory(WordCategory.TRAFFIC)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.VEGETABLE,
                helper.getNumberOfWordsByCategory(WordCategory.VEGETABLE)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.WEATHER,
                helper.getNumberOfWordsByCategory(WordCategory.WEATHER)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.HOSPITAL,
                helper.getNumberOfWordsByCategory(WordCategory.HOSPITAL)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.RESTAURANT,
                helper.getNumberOfWordsByCategory(WordCategory.RESTAURANT)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.ADJECTIVE,
                helper.getNumberOfWordsByCategory(WordCategory.ADJECTIVE)));
        arrayListBasicEnglish.add(new CourseTopic(courseName, WordCategory.ACTION,
                helper.getNumberOfWordsByCategory(WordCategory.ACTION)));
        return arrayListBasicEnglish;
    }

    ArrayList<CourseTopic> createChildrenEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListChildrenEnglish = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(MainActivity.Context);
        arrayListChildrenEnglish.add(new CourseTopic(courseName, WordCategory.CLASS1,
                helper.getNumberOfWordsByCategory(WordCategory.CLASS1)));
        arrayListChildrenEnglish.add(new CourseTopic(courseName, "English class 2", 170));
        arrayListChildrenEnglish.add(new CourseTopic(courseName, "English class 3", 140));
        arrayListChildrenEnglish.add(new CourseTopic(courseName, "English class 4", 210));
        arrayListChildrenEnglish.add(new CourseTopic(courseName, "English class 5", 200));
        return arrayListChildrenEnglish;
    }

    ArrayList<CourseTopic> createHighSchoolEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListHighSchoolEnglish = new ArrayList<>();
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 6", 190));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 7", 200));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 8", 2200));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 9", 140));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 10", 200));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 11", 190));
        arrayListHighSchoolEnglish.add(new CourseTopic(courseName, "English class 12", 150));
        return arrayListHighSchoolEnglish;
    }

    ArrayList<CourseTopic> createOfficeEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListOfficeEnglish = new ArrayList<>();
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Position", 30));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Department", 20));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Office supplies", 40));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Benefit", 40));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Conference", 30));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Machines", 20));
        arrayListOfficeEnglish.add(new CourseTopic(courseName, "Common", 40));
        return arrayListOfficeEnglish;
    }

    ArrayList<CourseTopic> createProgrammingEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListProgrammingEnglish = new ArrayList<>();
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Computer structure", 30));
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Jobs", 30));
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Peripherals", 40));
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Meeting", 30));
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Machines", 30));
        arrayListProgrammingEnglish.add(new CourseTopic(courseName, "Technology", 30));
        return arrayListProgrammingEnglish;
    }

    ArrayList<CourseTopic> createTravelEnglishCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListTravelEnglish = new ArrayList<>();
        arrayListTravelEnglish.add(new CourseTopic(courseName, "Tour guide", 50));
        arrayListTravelEnglish.add(new CourseTopic(courseName, "Travel agency", 40));
        arrayListTravelEnglish.add(new CourseTopic(courseName, "Hotel", 45));
        arrayListTravelEnglish.add(new CourseTopic(courseName, "Sea", 60));
        arrayListTravelEnglish.add(new CourseTopic(courseName, "Planes", 30));
        return arrayListTravelEnglish;
    }

    ArrayList<CourseTopic> createIeltsCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListIeltsEnglish = new ArrayList<>();
        arrayListIeltsEnglish.add(new CourseTopic(courseName, "Overview", 40));
        arrayListIeltsEnglish.add(new CourseTopic(courseName, "Listening", 50));
        arrayListIeltsEnglish.add(new CourseTopic(courseName, "Speaking", 60));
        arrayListIeltsEnglish.add(new CourseTopic(courseName, "Reading", 40));
        arrayListIeltsEnglish.add(new CourseTopic(courseName, "Writing", 45));
        return arrayListIeltsEnglish;
    }

    ArrayList<CourseTopic> createToeicCourseTopics(String courseName) {
        ArrayList<CourseTopic> arrayListToeicEnglish = new ArrayList<>();
        arrayListToeicEnglish.add(new CourseTopic(courseName, "Contracts", 50));
        arrayListToeicEnglish.add(new CourseTopic(courseName, "Shopping", 40));
        arrayListToeicEnglish.add(new CourseTopic(courseName, "Marketing", 30));
        arrayListToeicEnglish.add(new CourseTopic(courseName, "Movies", 50));
        arrayListToeicEnglish.add(new CourseTopic(courseName, "Accounting", 40));
        return arrayListToeicEnglish;
    }


    @Override
    public void onItemClick(CourseTopic courseTopic) {
        Intent intent = new Intent(CourseTopicActivity.this, TopicWordListActivity.class);
        intent.putExtra(TOPIC_NAME, courseTopic.getTopicName());
        startActivity(intent);
    }
}