package com.example.tabbed_test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolderGeneral extends RecyclerView.ViewHolder {

    TextView mEntry1, mEntry2, mEntry3, mDate, mTime;

    public MyViewHolderGeneral(@NonNull View itemView) {
        super(itemView);

        this.mEntry1 = itemView.findViewById(R.id.card_entry1);
        this.mEntry2 = itemView.findViewById(R.id.card_entry2);
        this.mEntry3 = itemView.findViewById(R.id.card_entry3);
        this.mDate = itemView.findViewById(R.id.card_date);
        this.mTime = itemView.findViewById(R.id.card_time_general);
    }
}
