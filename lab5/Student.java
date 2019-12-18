package com.company;

import java.io.Serializable;

public class Student extends User implements Serializable {
    private int questionCount = 0;
    private int rightAnswers = 0;
    public Student(){
        setUser("", "", "");
    }
    public Student(String name, String login, String password){
        setUser(name, login, password);
    }
    public String getLogin(){return super.getLogin();}
    public void addQuestionCount(){
        questionCount++;
    }
    public void addRightAnswers() {
        rightAnswers++;
    }
    public int getQuestionCount(){
        return questionCount;
    }
    public int getRightAnswers(){
        return rightAnswers;
    }
}
