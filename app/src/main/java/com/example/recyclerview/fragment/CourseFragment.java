package com.example.recyclerview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.adapter.CourseAdapter;
import com.example.recyclerview.adapter.OnItemClickListener;
import com.example.recyclerview.data.CourseData;
import com.example.recyclerview.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CourseFragment extends Fragment {
    public static final String BASIC_ENGLISH = "Basic English";
    public static final String ENGLISH_FOR_CHILDREN = "English for Children";
    public static final String ENGLISH_FOR_HIGH_SCHOOL = "English for High School";
    public static final String ENGLISH_FOR_OFFICE = "English for Office";
    public static final String ENGLISH_FOR_PROGRAMMING = "English for Programming";
    public static final String ENGLISH_FOR_TRAVEL = "English for Travel";
    public static final String IELTS = "Ielts";
    public static final String TOEIC = "Toeic";

    View v;
    private RecyclerView recyclerView;
    private ArrayList<CourseData> arrayListCourse;
    OnItemClickListener listener;

    public CourseFragment(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_course, container, false);
        recyclerView = v.findViewById(R.id.courseRecyclerView);
        recyclerView.setHasFixedSize(true);
        CourseAdapter courseAdapter = new CourseAdapter(getContext(), arrayListCourse, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(courseAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCourse = new ArrayList<>();
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhcoban, BASIC_ENGLISH, 300));
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhtreem, ENGLISH_FOR_CHILDREN, 470));
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhtrunghocphothong, ENGLISH_FOR_HIGH_SCHOOL, 380));
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhvanphong, ENGLISH_FOR_OFFICE, 300));
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhlaptrinh, ENGLISH_FOR_PROGRAMMING, 550));
        arrayListCourse.add(new CourseData(R.drawable.icon_tienganhdulich, ENGLISH_FOR_TRAVEL, 500));
        arrayListCourse.add(new CourseData(R.drawable.icon_ielts, IELTS, 500));
        arrayListCourse.add(new CourseData(R.drawable.icon_toeic, TOEIC, 400));
    }
}
