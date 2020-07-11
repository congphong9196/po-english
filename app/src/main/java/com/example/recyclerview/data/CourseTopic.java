package com.example.recyclerview.data;

public class CourseTopic {
    private String courseName;
    private String topicName;
    private Integer numberOfWords;

    public CourseTopic(String courseName, String topicName, Integer numberOfWords) {
        this.courseName = courseName;
        this.topicName = topicName;
        this.numberOfWords = numberOfWords;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(Integer numberOfWords) {
        this.numberOfWords = numberOfWords;
    }
}
