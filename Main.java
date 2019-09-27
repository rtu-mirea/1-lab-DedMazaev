package com.company;
import java.util.Random;
import java.util.Scanner;

//Вариант 9 лаб1

public class Main {

    public static void main(String[] args) {
        System.out.println("1.Manual"); //выбор рандом или ручной ввод
        System.out.println("2.Random");
        Scanner in = new Scanner(System.in);
        byte x= in.nextByte();
        while (x != 1 && x!=2) {
            System.out.println("Enter 1 or 2");
            x = in.nextByte();
        }
        System.out.println("Enter array size"); //ввод размера массива
        byte n = in.nextByte();
        while (n<1) {
            System.out.println("Array size is incorrect, enter again");
            n = in.nextByte();
        }
        byte[] arr = new byte[n];

        if (x == 1) {
            System.out.println("Enter array of bytes"); //ввод массива
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextByte();
            }
        } else {
            new Random().nextBytes(arr);
            for (int i = 0; i < n; i++) {

                System.out.println(arr[i]);

            }

        }
        System.out.println("Enter digit to find elements of array with number of digits < than this digit");
        byte u=in.nextByte(); //ввод значание для задания 1




        LabArr one=new LabArr(arr);
        System.out.println("Amount of numbers with amount of digits <" + u + "=" + one.task1(u));
        if (one.task2()==true)
        System.out.println("Array is symmetrical");
                else System.out.println("Array is not symmetrical");

    }
}
class LabArr {
    public byte arr0[];
    public LabArr(byte[] arr) {
       arr0=arr;
    }


    public int task1(byte a) {           //задание1 количество эелементов с количеством цифр менее введенного
        byte arr1[]=arr0.clone();
        byte sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            byte sum = 0;
            while (arr1[i] != 0) {
                sum++;
                arr1[i] /= 10;

            }
            arr1[i] = sum;
            if (arr1[i] < a)
                sum1++;
        }
        return sum1;
    }

    public boolean task2() {       //задание 2 Проверка зеркальности массива
        byte arr1[]=arr0.clone();
        int n = arr1.length;
        int count = 0;
                for (int i = 0; i < (n / 2); i++) {
                    if (arr1[i] != arr1[(n - i - 1)])
                        count++;
                }


                if (count == 0)
                   return true;
                else return false;

        }
        }





