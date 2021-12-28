package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private Button button1;
    public static ArrayList<ExamClass> listQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listQuestions = new ArrayList<>();
        listQuestions.add(new ExamClass("Question 1","correctAnser1","2","3","4",
                "correctAnser1"));
        listQuestions.add(new ExamClass("Question 2","correctAnser1","2","3","4","correctAnser1"));
        listQuestions.add(new ExamClass("Question 3","correctAnser1","2","3","4","correctAnser1"));
        listQuestions.add(new ExamClass("Question 4","correctAnser1","2","3","4","correctAnser1"));
        listQuestions.add(new ExamClass("Question 5","correctAnser1","2","3","4","correctAnser1"));



        button1 =  findViewById(R.id.login);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent yasser = new Intent(login.this,exam.class);
                startActivity(yasser);
            }
        });
    }
}