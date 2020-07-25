package com.example.recyclerview.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WordDAO {
    // Word Table
    public static final String TABLE_NAME = "words";
    public static final String ID = "id";
    public static final String CATEGORY = "category";
    public static final String CORRECT_ANSWER_TIMES = "correctAnswerTimes";
    public static final String VALUE = "value";
    public static final String MEANING = "meaning";
    public static final String EXAMPLE = "example";
    public static final String TYPE = "type";
    public static final String SPELLING = "spelling";
    public static final String LEARN_TIMES = "learnTimes";
    private final DatabaseHelper databaseHelper;

    public static WordDAO fromContext(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        return new WordDAO(databaseHelper);
    }

    public WordDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    private void addWord(Word word, SQLiteDatabase db) {
        ContentValues values = getContentValues(word);
        db.insert(WordDAO.TABLE_NAME, null, values);
    }

    public void addWord(List<Word> words) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        for (Word word : words) {
            addWord(word, db);
        }
        db.close();
    }

    public ArrayList<Word> getWordsByCategory(String wordCategory) {
        return getWordsByCategory(wordCategory, "", false, -1);
    }

    public ArrayList<Word> getWordsByCategory(String wordCategory,
                                              String orderColumn,
                                              boolean isOrderAscending) {
        return getWordsByCategory(wordCategory, orderColumn, isOrderAscending, -1);
    }

    public ArrayList<Word> getWordsByCategory(String wordCategory,
                                              String orderColumn,
                                              boolean isOrderAscending,
                                              int limit) {
        ArrayList<Word> words = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + WordDAO.TABLE_NAME
                + " where " + WordDAO.CATEGORY + "='" + wordCategory + "'";

        if (!orderColumn.isEmpty()) {
            selectQuery += " ORDER BY " + orderColumn + " " + (isOrderAscending ? "ASC" : "DESC");
        }
        if (limit > 0) {
            selectQuery += " LIMIT " + limit;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Log.d(WordDAO.class.toString(), "QUERY: " + selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                words.add(new Word(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getInt(7),
                        cursor.getInt(8)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return words;
    }
    public int getNumberOfWordsByCategory(String wordCategory) {
        String selectQuery = "SELECT id FROM " + WordDAO.TABLE_NAME
                + " where " + WordDAO.CATEGORY + "='" + wordCategory + "'";

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public int getNumberOfLearnedWordsByCategory(String wordCategory) {
        String selectQuery = "SELECT id FROM " + WordDAO.TABLE_NAME
                + " where "
                + WordDAO.CATEGORY + "='" + wordCategory + "'"
                + " AND "
                + WordDAO.CORRECT_ANSWER_TIMES + ">=" + ConstSaveData.NUMBER_CORRECT_TIME_TO_BE_LEARNED + "";

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public Word getWordById(int id) {
        Word word = null;
        String selectQuery = "SELECT * FROM " + WordDAO.TABLE_NAME + " where " + WordDAO.ID + "=" + id;

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            word = new Word(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getInt(8)
            );
        }

        cursor.close();
        return word;
    }

    public void updateWord(Word currentWord) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = getContentValues(currentWord);
        db.update(WordDAO.TABLE_NAME, contentValues, WordDAO.ID + "=" + currentWord.getId(), null);
        db.close();
    }

    public ContentValues getContentValues(Word word) {
        ContentValues values = new ContentValues();
        values.put(WordDAO.CATEGORY, word.getWordCategory());
        values.put(WordDAO.VALUE, word.getValue());
        values.put(WordDAO.MEANING, word.getMeaning());
        values.put(WordDAO.EXAMPLE, word.getExample());
        values.put(WordDAO.TYPE, word.getType());
        values.put(WordDAO.SPELLING, word.getSpelling());
        values.put(WordDAO.LEARN_TIMES, word.getLearnTimes());
        values.put(WordDAO.CORRECT_ANSWER_TIMES, word.getCorrectAnswerTimes());
        return values;
    }
}
