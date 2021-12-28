package com.example.myapplication1;

import static com.example.myapplication1.login.listQuestions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class exam extends AppCompatActivity {
     ArrayList<ExamClass> AllQuestionslist  ;
        ExamClass examClass;
        int index=0,AnswerCorrect=0;
        String AnswerString,select;
        TextView  card_question,answer1, answer2,answer3,answer4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Hooks();
        AllQuestionslist =listQuestions;
        Collections.shuffle(AllQuestionslist);
        examClass = listQuestions.get(index);

        setAllData();

        Button next =  findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(select == null){
                    Toast.makeText(exam.this, "Please answer this Question",
                            Toast.LENGTH_LONG).show();
                }else{
                    if(correctAnswerCount(select,AnswerString))
                        AnswerCorrect ++;

                    if(listQuestions.size()-1 == index){
                        new AlertDialog.Builder(exam.this)
                                .setMessage("result = " +AnswerCorrect)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(exam.this,login.class);
                                        startActivity(intent);
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }else{
                        index ++;
                        examClass = listQuestions.get(index);
                        clearCheck();
                        setAllData();

                    }
                }
            }


        });


        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer2);
                select = (String) answer2.getText();

            }

        });
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer1);
                select = (String) answer1.getText();

            }

        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer3);

                select = (String) answer3.getText();

            }

        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer4);

                select = (String) answer4.getText();

            }

        });


    }

    private void hoverClick(TextView answer) {
        if (answer== answer1) {
                answer1.setBackgroundResource(R.color.colorAccent);
                answer1.setTextColor(getResources().getColor(R.color.white));
        } else {
                answer1.setBackgroundResource(R.color.colorSecondary);
                answer1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (answer== answer2) {
            answer2.setBackgroundResource(R.color.colorAccent);
            answer2.setTextColor(getResources().getColor(R.color.white));
        } else {
            answer2.setBackgroundResource(R.color.colorSecondary);
            answer2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (answer== answer3) {
            answer3.setBackgroundResource(R.color.colorAccent);
            answer3.setTextColor(getResources().getColor(R.color.white));
        } else {
            answer3.setBackgroundResource(R.color.colorSecondary);
            answer3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (answer== answer4) {
            answer4.setBackgroundResource(R.color.colorAccent);
            answer4.setTextColor(getResources().getColor(R.color.white));
        } else {
            answer4.setBackgroundResource(R.color.colorSecondary);
            answer4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }



    private void setAllData() {
        card_question.setText(examClass.getQuestion());
        answer1.setText(examClass.getAnswer1());
        answer2.setText(examClass.getAnswer2());
        answer3.setText(examClass.getAnswer3());
        answer4.setText(examClass.getAnswer4());
        AnswerString = examClass.getCorrectAnswer();
        select =null;
    }

    private boolean correctAnswerCount(String Answer,String AnswerString){
        if(AnswerString.equals(Answer)){
            return true;
        }
        return false;
    }
    private void Hooks() {
        card_question = findViewById(R.id.card_question);
        // set answer 1 with its id
        answer1 = findViewById(R.id.answer1);
        // set answer 2 with its id
        answer2 = findViewById(R.id.answer2);
        // set answer 3 with its id
        answer3 = findViewById(R.id.answer3);
        // set answer 4 with its id
        answer4 = findViewById(R.id.answer4);
    }

    private void clearCheck() {
        answer1.setBackgroundResource(R.color.colorSecondary);
        answer1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        answer2.setBackgroundResource(R.color.colorSecondary);
        answer2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        answer3.setBackgroundResource(R.color.colorSecondary);
        answer3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        answer4.setBackgroundResource(R.color.colorSecondary);
        answer4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}