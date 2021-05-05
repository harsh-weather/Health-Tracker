package com.example.tabbed_test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mEntry;
    TextView mDate;
    TextView mTime;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mEntry = itemView.findViewById(R.id.card_entry1);
        this.mDate = itemView.findViewById(R.id.card_date);
        this.mTime = itemView.findViewById(R.id.card_time);
    }
}