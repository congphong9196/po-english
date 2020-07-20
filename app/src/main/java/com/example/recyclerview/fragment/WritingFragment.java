package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.LearningAndPracticeActivity;
import com.example.recyclerview.data.Word;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WritingFragment extends Fragment {
    public final OnWritingFragmentNextListener listener;
    private final Word word;
    private EditText edt;

    public WritingFragment(Word word, OnWritingFragmentNextListener listener) {
        this.word = word;
        this.listener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writing, container, false);
        Button btnComplete = v.findViewById(R.id.btn_complete);
        TextView txt = v.findViewById(R.id.tv_mean);
        txt.setText(word.getMeaning());
        edt = v.findViewById(R.id.edt_writing);

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt.getText().toString().toLowerCase().equals(word.getValue().toLowerCase())) {
                    Toast.makeText(getContext(), "Correct answer!", Toast.LENGTH_SHORT).show();
                    listener.OnWritingFragmentNext();
                } else {
                    Toast.makeText(getContext(), "Wrong answer! Try your next study!", Toast.LENGTH_SHORT).show();
                    listener.OnWritingFragmentNext();
                }

            }
        });
        return v;
    }

    public interface OnWritingFragmentNextListener {
        void OnWritingFragmentNext();
    }

}
