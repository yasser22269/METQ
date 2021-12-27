package com.example.myapplication1;

import static com.example.myapplication1.login.listQuetions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exam extends AppCompatActivity {
     ArrayList<ExamClass> AllQuetionslist  ;
        ExamClass examClass;
        int index=0;
        TextView  card_quetion,answer1, answer2,answer3,answer4;
       // CardView  card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Hooks();
        AllQuetionslist =listQuetions;
        Collections.shuffle(AllQuetionslist);
        examClass = listQuetions.get(index);

        setAllData();

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer2);
                
            }

        });
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer1);
            }

        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer3);
            }

        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoverClick(answer4);
            }

        });


    }

    private void hoverClick(TextView answer) {

              //  List<TextView> l = null;

//                l.add(answer4);
//                l.add(answer1);
//                l.add(answer3);
//                l.add(answer2);
               // for (int i = 0; i < 4; i++) {
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
        card_quetion.setText(examClass.getQuetion());
        answer1.setText(examClass.getAnswer1());
        answer2.setText(examClass.getAnswer2());
        answer3.setText(examClass.getAnswer3());
        answer4.setText(examClass.getAnswer4());
    }

    private void Hooks() {
        card_quetion = findViewById(R.id.card_quetion);

        // set answer 1 with its id
        answer1 = findViewById(R.id.answer1);

        // set answer 2 with its id
        answer2 = findViewById(R.id.answer2);

        // set answer 3 with its id
        answer3 = findViewById(R.id.answer3);

        // set answer 4 with its id
        answer4 = findViewById(R.id.answer4);

    }
}