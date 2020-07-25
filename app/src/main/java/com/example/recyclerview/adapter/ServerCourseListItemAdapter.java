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
import com.example.recyclerview.data.Course;
import com.example.recyclerview.data.CourseDAO;

import java.util.ArrayList;
import java.util.List;

public class ServerCourseListItemAdapter extends RecyclerView.Adapter<ServerCourseListItemAdapter.ServerCourseViewHolder> {

    private DownloadButtonClickListener listener;
    private final Context context;
    private ArrayList<DownloadCourseListActivity.ServerCourse> courses;

    public ServerCourseListItemAdapter(Context context, DownloadButtonClickListener listener) {
        this.courses = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ServerCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_server_course, parent, false);
        return new ServerCourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServerCourseViewHolder holder, int position) {
        final DownloadCourseListActivity.ServerCourse course = this.courses.get(position);
        holder.textViewCourseName.setText(course.getName());
        holder.textViewTotalWord.setText(String.valueOf(course.getNumberOfWords()));
        holder.textViewIntroduction.setText(course.getIntroduction());
        CourseDAO courseDAO = CourseDAO.fromContext(context);
        Course courseInDb = courseDAO.getCourseByTitle(course.getName());
        if (courseInDb == null) {
            holder.btnDownloadCourse.setBackgroundResource(R.drawable.ic_baseline_cloud_download_24_gray);
            holder.btnDownloadCourse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnDownloadButtonClick(course);
                }
            });
        } else {
            holder.btnDownloadCourse.setBackgroundResource(R.drawable.ic_baseline_check_24_green);
        }
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
        private final ImageView btnDownloadCourse;
        private final TextView textViewTotalWord;
        private final TextView textViewCourseName;
        private final TextView textViewIntroduction;

        public ServerCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourseName = itemView.findViewById(R.id.itemtxtTitle);
            textViewTotalWord = itemView.findViewById(R.id.itemtxtTotalWord);
            textViewIntroduction = itemView.findViewById(R.id.itemtxtIntroduction);
            btnDownloadCourse = itemView.findViewById(R.id.btnDownloadCourse);
        }
    }

    public interface DownloadButtonClickListener {
        void OnDownloadButtonClick(DownloadCourseListActivity.ServerCourse course);
    }
}
