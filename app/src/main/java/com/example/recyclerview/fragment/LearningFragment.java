package com.example.recyclerview.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.WordListActivity;
import com.example.recyclerview.data.DatabaseHelper;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.data.WordDAO;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LearningFragment extends Fragment {
    private final OnLearningFragmentNextListener listener;
    private Word word;
    private TextView tvTopicWordName;
    private ImageView imgImage;
    private TextView tvMean;


    public LearningFragment(Word word, OnLearningFragmentNextListener listener) {
        this.word = word;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learn, container, false);

        tvTopicWordName = v.findViewById(R.id.tv_topic_word_name);
        imgImage = v.findViewById(R.id.img_image);
        tvMean = v.findViewById(R.id.tv_mean);

        tvTopicWordName.setText(word.getValue());
        tvMean.setText(word.getMeaning());

        Button btnNext = v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnLearningFragmentNext();
            }
        });
        return v;
    }
    public interface OnLearningFragmentNextListener {
        void OnLearningFragmentNext();
    }
}
