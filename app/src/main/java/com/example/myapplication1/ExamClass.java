package com.example.myapplication1;

public class ExamClass {
    String Quetion;
    String Answer1;
    String Answer2;
    String Answer3;
    String Answer4;
    String correctAnswer;

    public ExamClass(String quetion, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        Quetion = quetion;
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuetion() {
        return Quetion;
    }

    public void setQuetion(String quetion) {
        Quetion = quetion;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String answer1) {
        Answer1 = answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String answer3) {
        Answer3 = answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String answer4) {
        Answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
