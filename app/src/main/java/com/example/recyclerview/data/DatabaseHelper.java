package com.example.recyclerview.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "po-english-db";
    private static final String TAG = "Database";

    // Word Table
    private static final String WORD_TABLE_NAME = "words";
    private static final String WORD_ID = "id";
    private static final String WORD_CATEGORY = "category";
    private static final String WORD_VALUE = "value";
    private static final String WORD_MEANING = "meaning";
    private static final String WORD_EXAMPLE = "example";
    private static final String WORD_LEARN_TIMES = "learnTimes";
    private static final String WORD_CORRECT_ANSWER_TIMES = "correctAnswerTimes";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Database.onCreate start ");
        Log.i(TAG, "Database.onCreate end ");
    }

    public void dropTables() {
        dropWordTable();
    }

    private void dropWordTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "DROP TABLE IF EXISTS " + WORD_TABLE_NAME;
        db.execSQL(sql);
        db.close();
    }

    public void createTables() {
        createWordTable();
    }

    public void createWordTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String createTableScript = "CREATE TABLE IF Not EXISTS " + WORD_TABLE_NAME + "("
                + WORD_ID + " INTEGER PRIMARY KEY,"
                + WORD_CATEGORY + " TEXT,"
                + WORD_VALUE + " TEXT,"
                + WORD_MEANING + " TEXT,"
                + WORD_EXAMPLE + " TEXT,"
                + WORD_LEARN_TIMES + " TEXT,"
                + WORD_CORRECT_ANSWER_TIMES + " TEXT" +
                ")";
        db.execSQL(createTableScript);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Database.onUpgrade start ");

        db.execSQL("DROP TABLE IF EXISTS " + WORD_TABLE_NAME);

        Log.i(TAG, "Database.onUpgrade end ");

    }

    private void addWord(Word word, SQLiteDatabase db) {
        ContentValues values = getContentValues(word);
        db.insert(WORD_TABLE_NAME, null, values);
    }

    private ContentValues getContentValues(Word word) {
        ContentValues values = new ContentValues();
        values.put(WORD_ID, word.getId());
        values.put(WORD_CATEGORY, word.getWordCategory());
        values.put(WORD_EXAMPLE, word.getExample());
        values.put(WORD_VALUE, word.getValue());
        values.put(WORD_MEANING, word.getMeaning());
        values.put(WORD_LEARN_TIMES, word.getLearnTimes());
        values.put(WORD_CORRECT_ANSWER_TIMES, word.getCorrectAnswerTimes());
        return values;
    }

    public void addWord(List<Word> words) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (Word word : words) {
            addWord(word, db);
        }
        db.close();
    }

    public ArrayList<Word> getWordsByCategory(String wordCategory) {
        ArrayList<Word> words = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + WORD_TABLE_NAME
                + " where " + WORD_CATEGORY + "='" + wordCategory + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                words.add(new Word(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return words;
    }

    public int getNumberOfWordsByCategory(String wordCategory) {
        String selectQuery = "SELECT id FROM " + WORD_TABLE_NAME
                + " where " + WORD_CATEGORY + "='" + wordCategory + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public Word getWordById(int id) {
        Word word = null;
        String selectQuery = "SELECT * FROM " + WORD_TABLE_NAME + " where " + WORD_ID + "=" + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            word = new Word(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6)
            );
        }

        cursor.close();
        return word;
    }

    public void updateWord(Word currentWord) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = getContentValues(currentWord);
        db.update(WORD_TABLE_NAME, contentValues, WORD_ID + "=" + currentWord.getId(), null);
        db.close();
    }
}