package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.data.Word;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SpeechToTextFragment extends Fragment {
    public final OnSpeechFragmentVoiceListener listenerVoice;
    public final OnSpeechFragmentNextListener listenerNext;
    private final Word word;

    public SpeechToTextFragment(Word word, OnSpeechFragmentVoiceListener listenerVoice, OnSpeechFragmentNextListener listenerNext) {
        this.word = word;
        this.listenerVoice = listenerVoice;
        this.listenerNext = listenerNext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_speechtotext, container, false);
        TextView tvWord = v.findViewById(R.id.tv_word);
        TextView tvPress = v.findViewById(R.id.tv_press);
        tvWord.setText(word.getValue());

        ImageButton imageButtonMic = v.findViewById(R.id.img_btnMic);
        imageButtonMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerVoice.OnSpeechFragmentVoice();
            }
        });

        Button btnNext = v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerNext.OnSpeechFragmentNext();
            }
        });
        return v;
    }

    public interface OnSpeechFragmentVoiceListener {
        void OnSpeechFragmentVoice();
    }

    public interface OnSpeechFragmentNextListener {
        void OnSpeechFragmentNext();
    }
}
