package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.MainActivity;
import com.example.recyclerview.activity.TopicWordDetailActivity;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TopicWordDetailFragment extends Fragment {
    public final OnTopicWordDetailFragmentNextListener listener;
    private TextToSpeech textToSpeech;
    private TextView tvTopicWordName;
    private TextView tvMean;
    private ImageButton imgButtonSpeaker;
    private Button btnNext;

    public TopicWordDetailFragment(OnTopicWordDetailFragmentNextListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_topic_word_detail, container, false);

        tvTopicWordName = v.findViewById(R.id.tv_topic_word_name);
        tvMean = v.findViewById(R.id.tv_mean);
        imgButtonSpeaker = v.findViewById(R.id.image_btnSpeaker);

        textToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        imgButtonSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNext = v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnTopicWordDetailFragmentNext();
            }
        });
        return v;
    }

    public interface OnTopicWordDetailFragmentNextListener {
        void OnTopicWordDetailFragmentNext();
    }
}
