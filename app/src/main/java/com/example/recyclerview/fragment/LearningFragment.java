package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.recyclerview.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LearningFragment extends Fragment {
    private final OnLearningFragmentNextListener listener;

    public LearningFragment(OnLearningFragmentNextListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learn, container, false);
        Button button = v.findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnLearningFragmentNext();
            }
        });
        return v;
    }

//    @Override
//    public void onClickItemHome() {
//        Intent intent = new Intent(getActivity().getApplication(), TopicWordListActivity.class);
//    }

    public interface OnLearningFragmentNextListener {
        void OnLearningFragmentNext();
    }


}
