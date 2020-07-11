package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.fragment.ChooseAnswerFragment;
import com.example.recyclerview.fragment.ListeningFragment;
import com.example.recyclerview.fragment.SpeechToTextFragment;
import com.example.recyclerview.fragment.SummaryFragment;
import com.example.recyclerview.fragment.WritingFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class FastLearningActivity
        extends AppCompatActivity
        implements
        ChooseAnswerFragment.OnChooseAnswerFragmentNextListener,
        SummaryFragment.OnSummaryFragmentNextListener,
        ListeningFragment.OnListeningFragmentNextListener,
        WritingFragment.OnWritingFragmentNextListener,
        SpeechToTextFragment.OnSpeechFragmentVoiceListener,
        SpeechToTextFragment.OnSpeechFragmentNextListener {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private String topicName;
    ArrayList<Word> words;
    ArrayList<Word> learningWords;
    Menu menu;
    int currentLearningWord = 0;
    int wrongTimes = 0;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        settingUpActionBar();

        topicName = getIntent().getStringExtra(TopicWordListActivity.TOPIC);
        databaseHelper = new DatabaseHelper(MainActivity.Context);

        setupWords();
        nextFragment(createChooseAnswerFragment(), R.id.trainingFragmentLayout);
    }

    class WordCorrectionTimeComparator implements Comparator<Word> {
        public int compare(Word s1, Word s2) {
            return Integer.compare(s1.getCorrectAnswerTimes(), s2.getCorrectAnswerTimes());
        }
    }

    private void setupWords() {
        DatabaseHelper helper = new DatabaseHelper(MainActivity.Context);
        words = helper.getWordsByCategory(topicName);
        Collections.sort(words, new WordCorrectionTimeComparator());
        learningWords = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            learningWords.add(words.get(i));
            words.remove(i);
        }
    }

    public ChooseAnswerFragment createChooseAnswerFragment() {
        if (currentLearningWord >= learningWords.size()) {
            return null;
        }
        ArrayList<Word> words = databaseHelper.getWordsByCategory(topicName);
        if (words.size() < 4) {
            return null;
        }
        return new ChooseAnswerFragment(this, this, learningWords.get(currentLearningWord), words);
    }

    private void settingUpActionBar() {
        getSupportActionBar().setTitle(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
    }

    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        if (fragment == null || wrongTimes >= 3) {
            fragment = new SummaryFragment(this);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
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

    @Override
    public void OnSummaryFragmentNext() {
        nextFragment(createChooseAnswerFragment(), R.id.trainingFragmentLayout);
    }

    @Override
    public void OnChooseAnswerFragmentNext(boolean isCorrect) {
        if (!isCorrect) {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    inCreaseWrongTime();
                }
            });
        }
        if (isCorrect) {
            Word currentWord = learningWords.get(currentLearningWord);
            currentWord.setCorrectAnswerTimes(currentWord.getCorrectAnswerTimes() + 1);
            databaseHelper.updateWord(currentWord);
        }
        currentLearningWord++;
        nextFragment(createChooseAnswerFragment(), R.id.trainingFragmentLayout);
    }

    private void inCreaseWrongTime() {
        wrongTimes++;
        MenuItem it = null;
        if (wrongTimes == 1) {
            it = menu.findItem(R.id.heart3);
        } else if (wrongTimes == 2) {
            it = menu.findItem(R.id.heart2);
        } else if (wrongTimes == 3) {
            it = menu.findItem(R.id.heart1);
        }

        if (it != null) {
            it.setIcon(R.drawable.ic_hear_black);
        }
    }

    @Override
    public void OnListeningFragmentNext() {
        nextFragment(new WritingFragment(this), R.id.trainingFragmentLayout);
    }

    @Override
    public void OnWritingFragmentNext() {
        nextFragment(new SpeechToTextFragment(this, this), R.id.trainingFragmentLayout);
    }

    @Override
    public void OnSpeechFragmentVoice() {
        speak();
    }
    //  receive voice input and handle it
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvPress;
        tvPress = findViewById(R.id.tv_press);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if(resultCode == RESULT_OK && null != data) {
                    // get text array from voice intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // set to text view

                    tvPress.setText(result.get(0));
                }
                break;
            }
        }
    }
    @Override
    public void OnSpeechFragmentNext() {
        nextFragment(new SummaryFragment(this), R.id.trainingFragmentLayout);
    }

    private void speak() {
        //intent to show speech to text dialog
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speech something");
        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        //start intent
        try {
            // in there was no error, show dialog
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e) {
            //if there was some error. get message of error and show
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
