package com.henry.core_java_20170706;

/**
 * 
 * @description Given an int array and a number as input, write a program to add
 *              all the elements in the array greater than the given number.
 *              Finally reverse the digits of the obtained sum and print it.
 * @author Henry
 * @version 0.0.1.20170706
 * 
 */
import java.util.Scanner;

public class AddAndReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int cmpNum = in.nextInt();// compare number.
        in.close();

        int sum = getSum(arr, cmpNum);
        int rvsSum = getReverseSum(sum);
        
        System.out.println(rvsSum);
    }

    private static int getSum(int arr[], int cmpNum) {
        int sum = 0;
        int end = arr.length;
        for(int i = 0; i < end; i++){
            if(arr[i] > cmpNum){
                sum += arr[i];
            }
        }
        
        return sum;
    }

    private static int getReverseSum(int sum) {
        int rvsSum = 0;
        while(sum != 0){
            rvsSum = (rvsSum * 10) + (sum % 10);
            sum /= 10;
        }
        
        return rvsSum;
    }

}
