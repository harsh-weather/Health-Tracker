package com.example.tabbed_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapterTemp extends RecyclerView.Adapter<MyViewHolder> {
    Context mContext;                          // refactor c -> mContext
    ArrayList<Record> recordList;          // refactor records -> recordList

    public CardAdapterTemp(Context mContext, ArrayList<Record> records) {
        this.mContext = mContext;
        this.recordList = records;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent,false);     // This will inflate our card
        return new MyViewHolder(view);      // THis will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mEntry.setText(recordList.get(position).getTemp());
        holder.mDate.setText((recordList.get(position).getDate()));
        String[] date_time = recordList.get(position).getDate().split(" ");
        holder.mDate.setText(date_time[0]);
        holder.mTime.setText(date_time[1]);
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
