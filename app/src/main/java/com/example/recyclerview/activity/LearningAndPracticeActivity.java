package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.data.WordDAO;
import com.example.recyclerview.fragment.LearningFragment;
import com.example.recyclerview.R;
import com.example.recyclerview.fragment.ListeningFragment;
import com.example.recyclerview.fragment.SpeechToTextFragment;
import com.example.recyclerview.fragment.WritingFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.recyclerview.activity.WordListActivity.TOPIC;

public class LearningAndPracticeActivity extends AppCompatActivity {

    public static final int WORDS_PER_LEARNING_SECTION = 4;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private Menu menu;
    private LearningAndWord currentLearningAndWord;
    private WordDAO wordDAO;




    static enum LearningType {
        LEARNING,
        LISTENING,
        WRITING,
        SPEAKING
    }

    private ArrayList<LearningType> learningTypes = new ArrayList<>(Arrays.asList(
            LearningType.LEARNING,
            LearningType.LISTENING,
            LearningType.WRITING,
            LearningType.SPEAKING
    ));

    static class LearningAndWord {
        Word word;
        LearningType learningType;

        public LearningAndWord(LearningType learningType, Word word) {
            this.learningType = learningType;
            this.word = word;
        }
    }

    static void shuffleArray(ArrayList<LearningAndWord> ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            LearningAndWord a = ar.get(index);
            ar.set(index, ar.get(i));
            ar.set(i, a);
        }
    }

    ArrayList<LearningAndWord> learningAndWords;
    int learningAndWordsIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_and_practice);

        initializeActionBar();

        // Select 4 words and learning that words
        String topicName = getIntent().getStringExtra(TOPIC);
        DatabaseHelper helper = new DatabaseHelper(this);
        wordDAO = new WordDAO(helper);
        ArrayList<Word> words = wordDAO.getWordsByCategory(
                topicName,
                WordDAO.LEARN_TIMES,
                true,
                WORDS_PER_LEARNING_SECTION);

        learningAndWords = new ArrayList<>();
        for (Word word : words) {
            for (LearningType learningType : learningTypes) {
                learningAndWords.add(new LearningAndWord(
                        learningType,
                        word
                ));
            }
        }
        shuffleArray(learningAndWords);
        nextFragment();
    }

    private void nextFragment() {
        Fragment fragment = getFragmentByLearningTypeAndWord();
        if (fragment == null) {
            return;
        }
        nextFragment(fragment, R.id.learning_and_practiceFragmentLayout);
        updateProgress();
    }

    private Fragment getFragmentByLearningTypeAndWord() {
        if (learningAndWordsIndex >= learningAndWords.size()) {
            finish();
            return null;
        }

        currentLearningAndWord = learningAndWords.get(learningAndWordsIndex);
        switch (currentLearningAndWord.learningType) {
            case WRITING:
                return createWritingFragment(currentLearningAndWord.word);
            case LEARNING:
                return createLearningFragment(currentLearningAndWord.word);
            case SPEAKING:
                return createSpeechToTextFragment(currentLearningAndWord.word);
            case LISTENING:
                return createListeningFragment(currentLearningAndWord.word);
        }
        return null;
    }

    private void initializeActionBar() {
        getSupportActionBar().setTitle(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
    }

    public void nextFragment(androidx.fragment.app.Fragment fragment, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.learning, menu);
        this.menu = menu;
        updateProgress();
        return super.onCreateOptionsMenu(menu);
    }

    private void updateProgress() {
        if (menu == null) {
            return;
        }
        MenuItem menuItem = menu.findItem(R.id.progress_text);
        menuItem.setTitle(learningAndWordsIndex + "/" + learningAndWords.size());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //////////////////////////////////////////////////////////////////

    private LearningFragment createLearningFragment(Word word) {
        return new LearningFragment(
                word,
                new LearningFragment.OnLearningFragmentNextListener() {
                    @Override
                    public void OnLearningFragmentNext() {
                        updateLearningTimes();
                        learningAndWordsIndex++;
                        nextFragment();
                    }
                });
    }

    private ListeningFragment createListeningFragment(Word word) {
        return new ListeningFragment(
                word,
                new ListeningFragment.OnListeningFragmentNextListener() {
                    @Override
                    public void OnListeningFragmentNext() {
                        updateLearningTimes();
                        learningAndWordsIndex++;
                        nextFragment();
                    }
                });
    }

    private void updateLearningTimes() {
        Word word = currentLearningAndWord.word;
        word.setLearnTimes(word.getLearnTimes() + 1);
        wordDAO.updateWord(word);
    }
    private void updateCorrectAnswerTimes() {
        Word word = currentLearningAndWord.word;
        word.setCorrectAnswerTimes(word.getCorrectAnswerTimes() + 1);
        wordDAO.updateWord(word);
    }

    private WritingFragment createWritingFragment(Word word) {
        return new WritingFragment(
                word,
                new WritingFragment.OnWritingFragmentNextListener() {
                    @Override
                    public void OnWritingFragmentNext() {
                        updateLearningTimes();
                        updateCorrectAnswerTimes();
                        learningAndWordsIndex++;
                        nextFragment();
                    }
                });
    }

    private SpeechToTextFragment createSpeechToTextFragment(Word word) {
        return new SpeechToTextFragment(
                word,
                new SpeechToTextFragment.OnSpeechFragmentVoiceListener() {
                    @Override
                    public void OnSpeechFragmentVoice() {
                        speak();
                    }
                },
                new SpeechToTextFragment.OnSpeechFragmentNextListener() {
                    @Override
                    public void OnSpeechFragmentNext() {
                        updateLearningTimes();
                        updateCorrectAnswerTimes();
                        learningAndWordsIndex++;
                        nextFragment();

                    }
                }
        );
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
        } catch (Exception e) {
            //if there was some error. get message of error and show
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvPress,tvValue;
        tvPress = findViewById(R.id.tv_press);
        tvValue = findViewById(R.id.tv_word);
        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    // get text array from voice intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    // set to text view
                    tvPress.setText(result.get(0));
                    if (tvPress.getText().toString().toLowerCase().equals(tvValue.getText().toString().toLowerCase())){
                        Toast.makeText(getApplicationContext(),"Wow, You speak like a native!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Sorry, You need to practice more!",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            }
        }
    }
}
