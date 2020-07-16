package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.data.Word;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WritingFragment extends Fragment {
    public final OnWritingFragmentNextListener listener;
    private final Word word;

    public WritingFragment(Word word, OnWritingFragmentNextListener listener) {
        this.word = word;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writing, container, false);

        TextView tvMean = v.findViewById(R.id.tv_mean);
        tvMean.setText(word.getMeaning());

        Button btnComplete = v.findViewById(R.id.btn_complete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnWritingFragmentNext();
            }
        });
        return v;
    }

    public interface OnWritingFragmentNextListener {
        void OnWritingFragmentNext();
    }

}
