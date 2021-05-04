package com.example.tabbed_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapterGeneral extends RecyclerView.Adapter<MyViewHolderGeneral> {
    Context mContext;                          // refactor c -> mContext
    ArrayList<Record> recordList;          // refactor records -> recordList

    public CardAdapterGeneral(Context mContext, ArrayList<Record> records) {
        this.mContext = mContext;
        this.recordList = records;
    }

    @NonNull
    @Override
    public MyViewHolderGeneral onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_general, parent,false);     // This will inflate our card
        return new MyViewHolderGeneral(view);      // THis will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderGeneral holder, int position) {
        holder.mEntry1.setText(recordList.get(position).getOxygen());
        holder.mEntry2.setText(recordList.get(position).getBpm());
        holder.mEntry3.setText(recordList.get(position).getTemp());
        holder.mDateTime.setText((recordList.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
