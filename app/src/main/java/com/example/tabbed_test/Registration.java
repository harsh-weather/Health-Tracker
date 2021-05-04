package com.example.tabbed_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    private Button reg_btn;
    RadioButton radioButton;
    RadioGroup radioGroup;
    private TextView name_tv, email_tv;
    private String email, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        reg_btn = findViewById(R.id.register_btn);
        name_tv = findViewById(R.id.name);
        email_tv = findViewById(R.id.email);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        Intent in = getIntent();
        name = in.getStringExtra("name");
        email = in.getStringExtra("email");

        name_tv.setText(name);
        email_tv.setText(email);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndRegisterUser();
            }
        });
    }

    private void validateAndRegisterUser() {
        if(radioButton.getText().toString()!=null) {
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton)findViewById(radioId);
            String type = radioButton.getText().toString();
            User user = new User();
            user.setEmail(email);
            user.setType(type);
            DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("User");
            db.push().setValue(user);
            Toast.makeText(this, "New user has been added!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Registration.this, LoginPage.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Select User option", Toast.LENGTH_SHORT).show();
        }
    }


    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected radio button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}