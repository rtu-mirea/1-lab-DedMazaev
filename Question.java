package com.company;

public class Question  {
    private String questin = "";
    private String questionAnswers = "";
    public Question(String str, String answer){
        questin = str;
        questionAnswers = answer;
    }
    public boolean isCorrect(String answer){
        return questionAnswers.compareTo(answer) == 0;
    }
    public String getQuestin() {
        return questin;
    }
}
