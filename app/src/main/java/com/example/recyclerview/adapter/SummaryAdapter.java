package com.example.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.data.SummaryData;
import com.example.recyclerview.R;
import com.example.recyclerview.data.Word;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.MyViewHolder> {
    Context context;
    ArrayList<SummaryData> summaryDatas ;


    public SummaryAdapter(Context context, ArrayList<SummaryData> summaryData) {
        this.context = context;
        this.summaryDatas = summaryData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_topic_word_list, null);
        SummaryAdapter.MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final SummaryData summaryData = summaryDatas.get(position);
        holder.wordValue.setText(summaryData.getValue());
        holder.wordMeaning.setText(summaryData.getMeaning());
        //holder.correctAnswer.setText(words.get(position).getCorrectAnswer());
    }

    @Override
    public int getItemCount() {
        return summaryDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordValue;
        private final TextView wordMeaning;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wordValue = itemView.findViewById(R.id.txtWordValue);
            wordMeaning = itemView.findViewById(R.id.txtWordMeaning);
        }
    }
}
