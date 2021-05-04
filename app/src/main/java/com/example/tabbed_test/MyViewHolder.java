package com.example.tabbed_test;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mEntry;
    TextView mDateTime;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mEntry = itemView.findViewById(R.id.card_entry1);
        this.mDateTime = itemView.findViewById(R.id.card_dateTime);
    }
}