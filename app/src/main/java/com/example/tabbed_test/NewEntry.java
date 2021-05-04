package com.example.tabbed_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class NewEntry extends AppCompatActivity {
EditText oxygen, bpm, temp;
Button save, view_records;
DatabaseReference db;
Record record;
String userType, userEmail, userName;
long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        Intent in = getIntent();
        userType = in.getStringExtra("type");
        userName = in.getStringExtra("name");
        userEmail = in.getStringExtra("email");

        oxygen = findViewById(R.id.oxygen);
        bpm = findViewById(R.id.bpm);
        temp = findViewById(R.id.temp);
        save = findViewById(R.id.save_btn);
        view_records = findViewById(R.id.view_records_btn);
        db = FirebaseDatabase.getInstance().getReference().child("Table-1");
        record = new Record();

        count=0;
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    count = snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(oxygen.getText().toString().trim().isEmpty() || bpm.getText().toString().trim().isEmpty() || temp.getText().toString().trim().isEmpty()) {
                    Toast.makeText(NewEntry.this, "Any field cannot be empty!", Toast.LENGTH_SHORT).show();
                }else{
                    record.setTemp(temp.getText().toString().trim() + "°F");
                    record.setOxygen(oxygen.getText().toString().trim() + "%");
                    record.setBpm(bpm.getText().toString().trim() + " bpm");
                    record.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                    db.child(String.valueOf(count + 1)).setValue(record);
                    Toast.makeText(NewEntry.this, "Record saved successfully", Toast.LENGTH_SHORT).show();
                    oxygen.setText("");
                    bpm.setText("");
                    temp.setText("");
                }
            }
            });
    view_records.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(NewEntry.this, MainActivity.class);
            intent.putExtra("type", userType);
            intent.putExtra("email", userEmail);
            intent.putExtra("name", userName);
            startActivity(intent);
        }
    });
    }
}