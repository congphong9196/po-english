package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.data.WordDAO;

import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class WordDetailActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private TextView tvTopicWordName;
    private TextView tvExample;
    private TextView tvMean;
    private ImageButton imgButtonSpeaker;
    private Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_word_detail);

        tvTopicWordName = findViewById(R.id.tv_topic_word_name);
        tvExample = findViewById(R.id.tv_sentence);
        tvMean = findViewById(R.id.tv_mean);

        imgButtonSpeaker = findViewById(R.id.image_btnSpeaker);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                } else {
                    Toast.makeText(WordDetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        speakWord();

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settingActionBar();

        getWordInIntent();
    }

    private void speakWord() {
        imgButtonSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void getWordInIntent() {
        Intent intent = getIntent();
        int wordId = intent.getIntExtra(WordListActivity.WORD_ID, -1);
        if (wordId == -1) {
            Toast.makeText(this, "Wrong word id", Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseHelper helper = new DatabaseHelper(this);
        WordDAO wordDAO = new WordDAO(helper);
        Word word = wordDAO.getWordById(wordId);
        tvMean.setText(word.getMeaning());
        tvTopicWordName.setText(word.getValue());
        tvExample.setText(word.getExample());
    }

    private void settingActionBar() {
        getSupportActionBar().setTitle(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topic_word_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(
                    getApplicationContext(), "Clicked on ActionBar",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void speak() {
        String text = tvTopicWordName.getText().toString().trim();
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }


    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

}
