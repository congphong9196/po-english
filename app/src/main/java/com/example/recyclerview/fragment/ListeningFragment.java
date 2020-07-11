package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.recyclerview.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListeningFragment extends Fragment {
    public final OnListeningFragmentNextListener listener;

    public ListeningFragment(OnListeningFragmentNextListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listening, container, false);
        Button button = v.findViewById(R.id.btnNext);
        ImageView imageView = v.findViewById(R.id.img_listening);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
