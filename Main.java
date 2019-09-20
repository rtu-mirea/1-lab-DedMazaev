package com.company;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.println("1.Manual");
        System.out.println("2.Random");
        Scanner in = new Scanner(System.in);
        byte x=in.nextByte();


   LabArr one=new LabArr();
        one.procedure(x);

    }
}
class LabArr {
    public byte[] arr = new byte[5];
    byte max=127;
    byte min=-128;
    public void procedure(byte a) {
        a = a;
        Scanner in = new Scanner(System.in);
        if (a == 1) {
            System.out.println("Enter array");
            for (int i = 0; i < 5; i++) {
                arr[i] = in.nextByte();
            }
        } else {
            new Random().nextBytes(arr);
            for (int i = 0; i < 5; i++) {

                System.out.println(arr[i]);

            }

        }
        System.out.println("Enter x");
        byte x = in.nextByte();
        byte[] arr1 = arr;
        byte sum1 = 0;
        for (int i = 0; i < 5; i++) {
            byte sum = 0;
            while (arr1[i] != 0) {
                sum++;
                arr1[i] /= 10;

            }
            arr1[i] = sum;
            if (arr[i] < x)
                sum1++;
        }
        System.out.println("Amount of numbers with amount of digits <" + x + "=" + sum1);
        if ((arr[0] == arr[4]) && (arr[1] == arr[3]))
            System.out.println("Array is symmetrical");
        else System.out.println("Array is not symmetrical");


    }
}
