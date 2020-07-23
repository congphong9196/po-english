package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.DownloadCourseListActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerCourseListItemAdapter extends RecyclerView.Adapter<ServerCourseListItemAdapter.ServerCourseViewHolder> {

    private final Context context;
    private ArrayList<DownloadCourseListActivity.ServerCourse> courses;

    public ServerCourseListItemAdapter(Context context) {
        this.courses = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ServerCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_server_course, parent, false);
        return new ServerCourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServerCourseViewHolder holder, int position) {
        DownloadCourseListActivity.ServerCourse topic = this.courses.get(position);
        holder.textViewCourseName.setText(topic.getName());
    }

    @Override
    public int getItemCount() {
        return this.courses.size();
    }

    public void setItems(List<DownloadCourseListActivity.ServerCourse> serverCourses) {
        this.courses = new ArrayList<>();
        this.courses.addAll(serverCourses);
        notifyDataSetChanged();
    }

    class ServerCourseViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageButton;
        private final TextView textViewTotalWord;
        private final TextView textViewCourseName;

        public ServerCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourseName = itemView.findViewById(R.id.itemtxtTitle);
            textViewTotalWord = itemView.findViewById(R.id.itemtxtTotalWord);
            imageButton = itemView.findViewById(R.id.itemImage);
        }
    }
}
