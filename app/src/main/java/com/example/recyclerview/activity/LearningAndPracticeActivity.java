package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.data.WordDAO;
import com.example.recyclerview.fragment.LearningAndTrainingFragment;
import com.example.recyclerview.fragment.LearningFragment;
import com.example.recyclerview.R;
import com.example.recyclerview.fragment.ListeningFragment;
import com.example.recyclerview.fragment.SpeechToTextFragment;
import com.example.recyclerview.fragment.SummaryFragment;
import com.example.recyclerview.fragment.WritingFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class LearningAndPracticeActivity
        extends AppCompatActivity
        implements
        LearningFragment.OnLearningFragmentNextListener,
        LearningAndTrainingFragment.OnLearningAndTrainingFragmentNextListener,
        ListeningFragment.OnListeningFragmentNextListener,
        WritingFragment.OnWritingFragmentNextListener,
        SpeechToTextFragment.OnSpeechFragmentNextListener,
        SpeechToTextFragment.OnSpeechFragmentVoiceListener {

    private TextView tvTopicWordName;
    private TextView tvMean;
    private ImageView imgImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_and_practice);
        tvTopicWordName = findViewById(R.id.tv_topic_word_name);
        imgImage = findViewById(R.id.img_image);
        tvMean = findViewById(R.id.tv_mean);

        nextFragment(new LearningFragment(this), R.id.learning_and_practiceFragmentLayout);

        getSupportActionBar().setTitle(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);

        //   getWordInIntent();
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
    public void OnLearningFragmentNext() {
        nextFragment(new ListeningFragment(this), R.id.learning_and_practiceFragmentLayout);
    }

    @Override
    public void OnLearningAndTrainingFragmentNext() {
        //    nextFragment(new LearningFragment(this), R.id.learning_and_practiceFragmentLayout);
    }

    @Override
    public void OnListeningFragmentNext() {
        nextFragment(new WritingFragment(this), R.id.learning_and_practiceFragmentLayout);
    }

    @Override
    public void OnWritingFragmentNext() {
        nextFragment(new SpeechToTextFragment(this, this), R.id.learning_and_practiceFragmentLayout);
    }

    @Override
    public void OnSpeechFragmentNext() {
        // nextFragment(new SummaryFragment(), R.id.learning_and_practiceFragmentLayout);
    }

    @Override
    public void OnSpeechFragmentVoice() {

    }

    public interface OnClickItemHomeListener {
        void onClickItemHome();
    }
//    private void getWordInIntent() {
//        Intent intent = getIntent();
//        int wordId = intent.getIntExtra(WordListActivity.WORD_ID, -1);
//        if (wordId == -1) {
//              Toast.makeText(this, "Wrong word id", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        DatabaseHelper helper = new DatabaseHelper(this);
//        WordDAO wordDAO = new WordDAO(helper);
//        Word word = wordDAO.getWordById(wordId);
//        tvMean.setText(word.getMeaning());
//        tvTopicWordName.setText(word.getValue());
//        //  imgImage.setImageResource(word.get());
//    }
}
