package com.example.recyclerview.data;

public class Setting {
    private int id;
    private int image;
    private String title;
    private String meaning;

    public Setting(int id, int image, String title, String meaning) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
