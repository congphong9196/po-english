package com.example.recyclerview.data;

public class CourseData {
    private int image;
    private String title;
    private int totalWord;

    public CourseData(int image, String title, int totalWord) {
        this.image = image;
        this.title = title;
        this.totalWord = totalWord;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(int totalWord) {
        this.totalWord = totalWord;
    }
}