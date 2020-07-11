package com.example.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.TopicWordAdapter;
import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class TopicWordListActivity
        extends AppCompatActivity
        implements TopicWordAdapter.OnItemClickListener {

    public static final String WORD_ID = "word_id";
    public static final String TOPIC = "TopicWordListActivity.TOPIC";
    public static final String COURSE = "TopicWordListActivity.COURSE";
    private static final int LEARNING_AND_PRACTICE_ACTIVITY = 1000;
    private static final int FAST_LEARNING_ACTIVITY = 1001;

    String topicName;
    private TopicWordAdapter topicWordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_word_list);

        final Intent intent = getIntent();
        topicName = intent.getStringExtra(CourseTopicActivity.TOPIC_NAME);

        ((TextView) findViewById(R.id.tv_topic_name)).setText(topicName + " Topic");

        RecyclerView recyclerView = findViewById(R.id.topicWordRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        topicWordAdapter = new TopicWordAdapter(
                TopicWordListActivity.this,
                getWordLists(topicName),
                this
        );
        recyclerView.setAdapter(topicWordAdapter);
        setTitle(topicName);

        final View actionGroup = handleClickFloatingButton();
        handleLearningAndPracticeButtonClicked(actionGroup);
        handleFastLearningButtonClicked(actionGroup);
    }

    private View handleClickFloatingButton() {
        final View actionGroup = findViewById(R.id.actionGroup);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = actionGroup.getVisibility();
                if (visibility == View.VISIBLE) {
                    actionGroup.setVisibility(View.INVISIBLE);
                } else {
                    actionGroup.setVisibility(View.VISIBLE);
                }
            }
        });
        return actionGroup;
    }

    private void handleFastLearningButtonClicked(View actionGroup) {
        actionGroup.findViewById(R.id.actionFastLearning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TopicWordListActivity.this, "actionFastLearning", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopicWordListActivity.this, FastLearningActivity.class);
                intent.putExtra(TOPIC, topicName);
                startActivityForResult(intent, FAST_LEARNING_ACTIVITY);
            }
        });
    }

    private void handleLearningAndPracticeButtonClicked(View actionGroup) {
        actionGroup.findViewById(R.id.actionTraining).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TopicWordListActivity.this, "actionTraining", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TopicWordListActivity.this, LearningAndPracticeActivity.class);
                intent.putExtra(TOPIC, topicName);
                startActivityForResult(intent, LEARNING_AND_PRACTICE_ACTIVITY);
            }
        });
    }

    private ArrayList<Word> getWordLists(String topicName) {
        // TODO: depend on topic name for deciding word category
        Log.d(TopicWordListActivity.class.toString(), topicName);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.Context);
        return databaseHelper.getWordsByCategory(topicName);
    }

    @Override
    public void onItemClick(Word word) {
        Intent intent = new Intent(TopicWordListActivity.this, TopicWordDetailActivity.class);
        intent.putExtra(WORD_ID, word.getId());
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FAST_LEARNING_ACTIVITY) {
            topicWordAdapter.SetWordList(getWordLists(topicName));
        }
    }
}
