package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.recyclerview.adapter.SummaryAdapter;
import com.example.recyclerview.data.SummaryData;
import com.example.recyclerview.R;
import com.example.recyclerview.data.Word;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SummaryFragment extends Fragment {
    private final OnSummaryFragmentNextListener listener;
    private RecyclerView recyclerView;
    private ArrayList<SummaryData> arrayListSummary;

    public SummaryFragment(OnSummaryFragmentNextListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        recyclerView = v.findViewById(R.id.summaryRecyclerview);
        recyclerView.setHasFixedSize(true);
        SummaryAdapter summaryAdapter = new SummaryAdapter(getContext(), arrayListSummary);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(summaryAdapter);
        Button button = v.findViewById(R.id.btnNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnSummaryFragmentNext();
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListSummary = new ArrayList<>();
        arrayListSummary.add(new SummaryData("Cat", "Con mèo"));
        arrayListSummary.add(new SummaryData("Monkey", "Con khỉ"));
        arrayListSummary.add(new SummaryData("Lion", "Con sư tủ"));
        arrayListSummary.add(new SummaryData("Dog", "Con chó"));
        arrayListSummary.add(new SummaryData("Snake", "Con rắn"));
        arrayListSummary.add(new SummaryData("Bird", "Con chim"));
    }
    public interface OnSummaryFragmentNextListener {
        void OnSummaryFragmentNext();
    }
}
