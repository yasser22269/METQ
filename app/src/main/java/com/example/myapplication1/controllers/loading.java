package com.example.myapplication1.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication1.R;
import com.example.myapplication1.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class loading extends AppCompatActivity {

    public static ArrayList<User> listUsers;
    DatabaseReference databaseReferenceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        listUsers = new ArrayList<>();
        databaseReferenceUser = FirebaseDatabase.getInstance().getReference("Users");
        databaseReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    User user = dataSnapshot.getValue(User.class);
                    listUsers.add(user);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent login = new Intent(loading.this, login.class);
                        startActivity(login);

                    }
                }, 1500);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}