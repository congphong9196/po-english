package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.data.Word;
import com.example.recyclerview.utils.TextToSpeechUtils;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListeningFragment extends Fragment {
    public final OnListeningFragmentNextListener listener;
    private final Word word;
    private TextToSpeech textToSpeech;
    private SeekBar sbSpeed;

    public ListeningFragment(Word word, OnListeningFragmentNextListener listener) {
        this.word = word;
        this.listener = listener;
    }

    public void setTextToSpeech() {
        textToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                } else {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listening, container, false);

        final TextView tvValue = v.findViewById(R.id.tv_value);
        TextView tvMean = v.findViewById(R.id.tv_mean);
        TextView tvSpelling = v.findViewById(R.id.tv_spelling);

        tvValue.setText(word.getValue());
        tvMean.setText(word.getMeaning());
        tvSpelling.setText(word.getSpelling());

        setTextToSpeech();
        sbSpeed = v.findViewById(R.id.sb_speed);
        Button button = v.findViewById(R.id.btnNext);
        ImageView imageView = v.findViewById(R.id.img_listening);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float speed = (float)sbSpeed.getProgress() / 50;
                if(speed < 0.1) {
                    speed = 0.1f;
                }
                textToSpeech.setSpeechRate(speed);
                TextToSpeechUtils.speak(tvValue.getText().toString(), getContext(),textToSpeech );

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnListeningFragmentNext();
            }
        });
        return v;
    }

    public interface OnListeningFragmentNextListener {
        void OnListeningFragmentNext();
    }
}
