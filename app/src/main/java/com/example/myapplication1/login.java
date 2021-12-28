package com.example.myapplication1;

import static com.example.myapplication1.loading.listUsers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private Button button1;
    private EditText id, password;
    public static ArrayList<ExamClass> listQuestions;

    DatabaseReference databaseReferenceExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listQuestions = new ArrayList<>();


        button1 = findViewById(R.id.login);
        id = findViewById(R.id.id);
        password = findViewById(R.id.password);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkUser(id.getText().toString(),password.getText().toString())) {
                    databaseReferenceExam = FirebaseDatabase.getInstance().getReference("Question");
                    databaseReferenceExam.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                ExamClass examClass = dataSnapshot.getValue(ExamClass.class);
                                listQuestions.add(examClass);

                            }
                            Intent exam = new Intent(login.this, exam.class);
                            startActivity(exam);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }else{
                    Toast.makeText(login.this, "User not found",
                            Toast.LENGTH_LONG).show();
                }
            }


        });
    }

    private boolean checkUser(String id,String password) {
        for (LoginModel loginmodel:listUsers
             ) {
            if(loginmodel.getId().equals(id) && loginmodel.getPassword().equals(password)){
                return true;
            }
        }
        return  false;
    }
}