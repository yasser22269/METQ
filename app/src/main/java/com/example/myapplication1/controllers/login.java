package com.example.myapplication1.controllers;

import static com.example.myapplication1.controllers.loading.listUsers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication1.R;
import com.example.myapplication1.models.Question;
import com.example.myapplication1.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtID, edtPassword;
    public static ArrayList<Question> listQuestions;
    DatabaseReference databaseReferenceExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listQuestions = new ArrayList<>();

        btnLogin = findViewById(R.id.login);
        edtID = findViewById(R.id.id);
        edtPassword = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkUser(edtID.getText().toString(), edtPassword.getText().toString())) {
                    databaseReferenceExam = FirebaseDatabase.getInstance().getReference("Question");
                    databaseReferenceExam.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Question question = dataSnapshot.getValue(Question.class);
                                listQuestions.add(question);
                            }
                            Intent exam = new Intent(login.this, exam.class);
                            startActivity(exam);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                } else {
                    Toast.makeText(login.this, "User not found",
                            Toast.LENGTH_LONG).show();
                }
            }


        });
    }

    private boolean checkUser(String id, String password) {
        for (User loginmodel : listUsers
        ) {
            if (loginmodel.getId().equals(id) && loginmodel.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}