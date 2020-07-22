package com.example.recyclerview.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
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
import com.example.recyclerview.utils.TextToSpeechUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class WordDetailActivity extends AppCompatActivity {

    private Menu mOptionsMenu;
    private TextToSpeech textToSpeech;
    private TextView tvTopicWordName;
    private TextView tvExample;
    private TextView tvMean;
    private TextView tvType;
    private TextView tvSpelling;
    private DatabaseHelper helper = new DatabaseHelper(this);
    private int wordId;
    private String topicName;
    private ArrayList<Word> words = new ArrayList<>();
    private int wordIndex = -1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_word_detail);

        tvTopicWordName = findViewById(R.id.tv_topic_word_name);
        tvExample = findViewById(R.id.tv_sentence);
        tvMean = findViewById(R.id.tv_mean);
        tvType = findViewById(R.id.tv_type);
        tvSpelling = findViewById(R.id.tv_spelling);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                } else {
                    //Toast.makeText(WordDetailActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Word word = getWordInIntent();
        if (word == null) {
            return;
        }
        topicName = word.getWordCategory();

        boolean success = findWordsAndWordIndex(word);
        if (!success) return;

        handleSpeakerClicked();
        settingActionBar();
        handleButtonNextClicked();
    }

    private boolean findWordsAndWordIndex(Word word) {
        WordDAO wordDAO = new WordDAO(helper);
        words = wordDAO.getWordsByCategory(topicName);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getId() == word.getId()) {
                wordIndex = i;
                break;
            }
        }
        if (wordIndex == -1) {
            Toast.makeText(this, "[ERROR] Wrong word id", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void handleButtonNextClicked() {
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word;
                wordIndex++;
                if (wordIndex >= words.size()) {
                    finish();
                    return;
                }
                word = words.get(wordIndex);

                tvMean.setText(word.getMeaning());
                tvTopicWordName.setText(word.getValue());
                tvExample.setText(word.getExample());
                tvType.setText(word.getType());
                tvSpelling.setText(word.getSpelling());

                updateProgress();
            }
        });
    }

    private void updateProgress() {
        MenuItem menuItem = mOptionsMenu.findItem(R.id.progress_text);
        menuItem.setTitle(wordIndex + "/" + words.size());
    }

    private void handleSpeakerClicked() {
        ImageButton imgButtonSpeaker = findViewById(R.id.image_btnSpeaker);
        imgButtonSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvTopicWordName.getText().toString().trim();
                TextToSpeechUtils.speak(text,getApplicationContext(),textToSpeech);
            }
        });
    }

    private Word getWordInIntent() {
        Intent intent = getIntent();
        wordId = intent.getIntExtra(WordListActivity.WORD_ID, -1);
        if (wordId == -1) {
            Toast.makeText(this, "Wrong word id", Toast.LENGTH_SHORT).show();
            return null;
        }
        WordDAO wordDAO = new WordDAO(helper);
        Word word = wordDAO.getWordById(wordId);
        tvMean.setText(word.getMeaning());
        tvTopicWordName.setText(word.getValue());
        tvExample.setText(word.getExample());
        tvType.setText(word.getType());
        tvSpelling.setText(word.getSpelling());
        return word;
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
        mOptionsMenu = menu;
        updateProgress();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
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
