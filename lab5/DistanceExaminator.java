package com.company;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DistanceExaminator implements Serializable {
    private Admin admin = new Admin();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Question> questions = new ArrayList<Question>();
    //private int curreantUser = -2;
    private Student curreantUser = new Student();
    public DistanceExaminator(){
        students.add(0, new Student("admin", "admin", "admin"));
    }
    public Student getCurreantUser(){
        return curreantUser;
    }
    public void addUser(String name, String login, String password, String repeatPassword) throws Exception{
        if (login.compareTo("") == 0 || password.compareTo("") == 0) throw new Exception("Заполните все данные");
        if (password.compareTo(repeatPassword) != 0) throw new Exception("Пароли не совпадают");
        if (login.compareTo(admin.getLogin()) == 0) throw new Exception("Данный логин уде занят");
        if (students.isEmpty()){

            Student buf = new Student(name, login, password);
            students.add(buf);
        }
        else {
            for (Student student : students) {
                if (student.getLogin().compareTo(login) == 0) throw new Exception("Данный логин уже занят");
            }
            Student buf = new Student(name, login, password);
            students.add(buf);
        }
    }
    public void changePassword(String login, String password, String newPassword, String repeatNewPassword) throws Exception {
        if (newPassword.compareTo(repeatNewPassword) != 0) throw new Exception("Пароли не совпадают");
        if (admin.enter(login, password)) {
            admin.changePassword(newPassword);
            return;
        }
        if (students.size() < 2) throw new Exception("В системе нет ни одного зарегистрированного пользователя");
        for (Student student: students){
            if (student.enter(login, password))
            {
                //curreantUser = students.indexOf(student);
                int ind = students.indexOf(student);
                curreantUser = students.get(ind);
                break;
            }
            else curreantUser = new Student();
        }
        if (curreantUser.getLogin().compareTo("") == 0) throw new Exception("Логин или пароль были введены неверно");
        //students.get(curreantUser).changePassword(newPassword);
        curreantUser.changePassword(newPassword);
        //curreantUser = -2;
        curreantUser = new Student();
    }
    public void logining(String login, String password)throws Exception{
        if (admin.enter(login, password)) {
            curreantUser = students.get(0);
            return;
        }
        if (students.size() < 2) throw new Exception("В системе нет ни одного зарегистрированного пользователя");
        for (Student student: students){
            if (student.enter(login, password))
            {
                //curreantUser = students.indexOf(student);
                int ind = students.indexOf(student);
                curreantUser = students.get(ind);
                break;
            }
            else curreantUser = new Student();
        }
        if (curreantUser.getLogin().compareTo("") == 0) throw new Exception("Логин или пароль были введены неверно");
    }
    public void exit(){
        curreantUser = new Student();
    }
    public void addQuestion(String question, String answer) throws Exception{
        if (question.compareTo("") == 0 && answer.compareTo("") == 0)
            throw new Exception("Введите вопрос и ответ на него");
        if (curreantUser.getLogin().compareTo("admin") == 0) {
            questions.add(new Question(question, answer));
        }
        else throw new Exception("Вы не имеете парв на добавление вопросов");
    }
    public void changeQuestion(int i, String question, String answer) throws Exception{
        if (question.compareTo("") == 0 || answer.compareTo("") == 0)
            throw new Exception("Введите вопрос и ответ на него");
        if (curreantUser.getLogin().compareTo("admin") == 0) {
            questions.set(i, new Question(question, answer));
        }
        else throw new Exception("Вы не имеете парв на добавление вопросов");
    }
    public void deleteQuestion(int i){
        questions.remove(i);
    }
    public String getAllQuestions(){
        String res = "Cписок вопросов\n";
        for (int i = 0; i < questions.size(); i++){
            res += "Вопрос №" + i + " : " + questions.get(i).getQuestin() + "\nОтвет: " + questions.get(i).getAnswer() + '\n';
        }
        return res;
    }
    public void examination()throws Exception{
        int questionIndex, arr[] = {-1,-1,-1,-1,-1};
        boolean flag;
        Random random = new Random();
        String str;
        Scanner in = new Scanner(System.in);
        if (curreantUser.getLogin().compareTo("admin") == 0) throw new Exception("Вы не можете отвечать на вопросы");
        if (curreantUser.getLogin().compareTo("") == 0) throw new Exception("Вы не вошли в систему");
        if (questions.size() < 5) throw new Exception("Преподаватель еще не добавил нужное количество вопросов");
        if (curreantUser.getQuestionCount() != 0) throw new Exception("Вы уже проходили экзамен");
        for (int i = 0; i < 5; i++){
            flag = true;
            questionIndex = random.nextInt(questions.size());
            for (int n = 0; n < i; n++){
                if (arr[n] == questionIndex){
                    flag = false;
                    break;
                }
            }
            if (flag) arr[i] = questionIndex;
            else i--;
        }
        for (int i = 1; i <= 5; i++){
            //System.out.println("Вопрос №" + i + " :\n" + questions.get(arr[i - 1]).getQuestin() + "\nОтвет: ");
            //str = in.nextLine();
            str = JOptionPane.showInputDialog("Вопрос №" + i + " :\n" + questions.get(arr[i - 1]).getQuestin() + "\nОтвет: ");
            curreantUser.addQuestionCount();
            if (questions.get(arr[i - 1]).isCorrect(str))
                curreantUser.addRightAnswers();
        }
    }
    public int getMark()throws Exception{
        if (curreantUser.getLogin().compareTo("") == 0) throw new Exception("Вы не вошли в систему или не имеете доступа к этому меню");
        if (curreantUser.getQuestionCount() == 0) throw new Exception("Вы еще не прошли экзамен");
        if (curreantUser.getRightAnswers() <= 2)
            return 2;
        else
            return curreantUser.getRightAnswers();
    }
}
