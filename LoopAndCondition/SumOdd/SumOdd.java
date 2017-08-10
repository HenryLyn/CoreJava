package com.henry.core_java_20170810;

import java.util.Scanner;

/**
 * 
 * @descriptionGiven Write a program to read an integer and find the sum of all
 *                   odd numbers from 1 to the given number. [inclusive of the
 *                   given number]
 * 
 *                   if N = 9 [ 1,3,5,7,9]. Sum = 25.
 * @author Henry
 * @version 0.0.1.20170808
 * 
 */
public class SumOdd {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int end = input.nextInt();
        input.close();
        int sum = addOddNumbers(end);
        System.out.println(sum);
        
    }

    public static int addOddNumbers(int end){
        
        int sum = 0;
        
        for(int i = 1; i <= end; i += 2){
            sum += i;
        }
        
        return sum;
    }
    
}
