package com.company;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.println("1.Manual");
        System.out.println("2.Random");
        Scanner in = new Scanner(System.in);
        byte x=in.nextByte();
        System.out.println("Enter array size");
        byte n=in.nextByte();
        byte[] arr = new byte[n];
        if (x == 1) {
            System.out.println("Enter array");
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

        byte u=in.nextByte();



   LabArr one=new LabArr();
        one.task1(u, arr, n);
        one.task2(arr,n);

    }
}
class LabArr {

    public void task1(byte a, byte arr[], byte n) {
         byte x=a;
        byte[] arr1 = arr;
        byte sum1 = 0;
        for (int i = 0; i < n; i++) {
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



    }
    public void task2(byte arr[], byte n){
        int flag=0;
        for (int i=0,j=n-1; i<(n/2); i++,j--) {
            if (arr[i]==arr[j])
                flag++;
        }
        if (flag==(n/2))
        System.out.println("Array is symmetrical");
        else System.out.println("Array is not symmetrical");
    }
}
