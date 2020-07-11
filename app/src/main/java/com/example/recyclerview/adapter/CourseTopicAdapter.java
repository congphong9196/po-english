package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.data.CourseTopic;
import com.example.recyclerview.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseTopicAdapter extends RecyclerView.Adapter<CourseTopicAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CourseTopic> courseTopics;
    private OnItemClickListener listener;

    public CourseTopicAdapter(Context context, ArrayList<CourseTopic> CourseTopics, OnItemClickListener listener) {
        this.context = context;
        this.courseTopics = CourseTopics;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_english_catalog, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final CourseTopic courseTopic = courseTopics.get(position);
        holder.txtCourseName.setText(courseTopic.getCourseName());
        holder.txtTopicName.setText(courseTopic.getTopicName());
        holder.txtNumberOfWords.setText(courseTopic.getNumberOfWords() + " từ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(courseTopic);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseTopics.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CourseTopic courseTopic);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCourseName;
        private TextView txtTopicName;
        private TextView txtNumberOfWords;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourseName = itemView.findViewById(R.id.txtTitleEnglishCatalog);
            txtTopicName = itemView.findViewById(R.id.txtContentEnglishCatalog);
            txtNumberOfWords = itemView.findViewById(R.id.txtTotalWordEnglishCatalog);
        }
    }
//    public interface OnItemClickListener {
//        void onItemClick(CourseTopic courseTopic);
//    }

}
