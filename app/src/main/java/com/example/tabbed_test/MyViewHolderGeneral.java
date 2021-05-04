package com.example.tabbed_test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolderGeneral extends RecyclerView.ViewHolder {

    TextView mEntry1, mEntry2, mEntry3, mDateTime;

    public MyViewHolderGeneral(@NonNull View itemView) {
        super(itemView);

        this.mEntry1 = itemView.findViewById(R.id.card_entry1);
        this.mEntry2 = itemView.findViewById(R.id.card_entry2);
        this.mEntry3 = itemView.findViewById(R.id.card_entry3);
        this.mDateTime = itemView.findViewById(R.id.card_dateTime);
    }
}
