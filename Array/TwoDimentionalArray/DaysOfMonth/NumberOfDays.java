package com.henry.core_java_20170809;

import java.util.Scanner;

/**
 * 
 * @descriptionGiven two inputs year and month (Month is coded as: Jan=0, Feb=1
 *                   ,Mar=2 ...), write a program to find out total number of
 *                   days in the given month for the given year.
 * @author Henry
 * @version 0.0.1.20170808
 * 
 */
public class NumberOfDays {

    private static final int[][] DAYS_OF_MONTH = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                                  {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        input.close();
        
        int days = getNumberOfMonth(year, month);
        
        System.out.println(days);
        
    }

    private static int getNumberOfMonth(int year, int month){
        int yearIndex = 0;
        
        if(isLeapYear(year)){
            yearIndex = 1;
        }
        
        return DAYS_OF_MONTH[yearIndex][month];
    }
    
    private static boolean isLeapYear(int year){
        boolean isLeapYear = false;
        
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            isLeapYear = true;
        }
        
        return isLeapYear;
    }
}
