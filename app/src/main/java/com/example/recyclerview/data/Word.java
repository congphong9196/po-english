package com.example.recyclerview.data;

public class Word {
    static int idCount = 0;
    private int id;
    private String wordCategory;
    private String value;
    private String meaning;
    private String example;
    private String type;
    private String spelling;
    private int learnTimes;
    private int correctAnswerTimes;

    public Word(int id,
                String wordCategory,
                String value,
                String meaning,
                String example,
                String type,
                String spelling,
                int learnTimes,
                int correctAnswerTimes) {
        this.id = id;
        this.wordCategory = wordCategory;
        this.value = value;
        this.meaning = meaning;
        this.type = type;
        this.spelling = spelling;
        this.example = example;
        this.learnTimes = learnTimes;
        this.correctAnswerTimes = correctAnswerTimes;
    }

    public Word(String wordCategory,
                String value,
                String meaning,
                String example,
                String type,
                String spelling) {
        this.learnTimes = 0;
        this.correctAnswerTimes = 0;
        this.id = idCount++;
        this.wordCategory = wordCategory;
        this.value = value;
        this.meaning = meaning;
        this.example = example;
        this.type = type;
        this.spelling = spelling;
    }

    public Word(String wordCategory,
                String value,
                String meaning) {
        this.learnTimes = 0;
        this.correctAnswerTimes = 0;
        this.id = idCount++;
        this.wordCategory = wordCategory;
        this.value = value;
        this.meaning = meaning;
        this.example = "";
        this.type = "";
        this.spelling = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
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

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordCategory() {
        return wordCategory;
    }

    public void setWordCategory(String wordCategory) {
        this.wordCategory = wordCategory;
    }

    public int getLearnTimes() {
        return learnTimes;
    }

    public void setLearnTimes(int learnTimes) {
        this.learnTimes = learnTimes;
    }

    public int getCorrectAnswerTimes() {
        return correctAnswerTimes;
    }

    public void setCorrectAnswerTimes(int correctAnswerTimes) {
        this.correctAnswerTimes = correctAnswerTimes;
    }
}
