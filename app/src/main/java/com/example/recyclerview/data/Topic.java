package com.example.recyclerview.data;

import android.util.Log;

public class Topic {
    static int idCount = 0;
    private int id;
    private int courseId;
    private String name;
    private String imageEncodedString = "";

    // Not inside database
    private String courseName;
    private int numberOfWords = 0;

    public Topic(int id, int courseId, String name, String imageEncodedString) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.imageEncodedString = imageEncodedString;
        InitData();
    }

    private void InitData() {
        if (imageEncodedString == null) {
            imageEncodedString = "";
        }
    }

    public Topic(int id, int courseId, String name) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
    }

    public Topic(int courseId, String name) {
        this.id = idCount++;
        this.courseId = courseId;
        this.name = name;
    }

    public Topic(int courseId, String name, String imageEncodedString) {
        this.id = idCount++;
        this.courseId = courseId;
        this.name = name;
        this.imageEncodedString = imageEncodedString;
        Log.d("TopicInit", imageEncodedString);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImageEncodedString() {
        return imageEncodedString;
    }

    public void setImageEncodedString(String imageEncodedString) {
        this.imageEncodedString = imageEncodedString;
    }
}
