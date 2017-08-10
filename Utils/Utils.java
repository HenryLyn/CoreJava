package com.henry.util;

public class Utils {
    
    /* Follow variables for regular expression pattern. */
    public static final String REGEX_INTEGER_PATTERN = "[0-9]+";

    /**
     * @author Henry
     * @description: check if the input string can be parse to integer.
     * @param strInput:
     *              a string for checking.
     * @return boolean
     *              true: means the string can parse to a integer.
     *              false: means the string can not parse to a integer.
     * @version: 1.0.0.20170808
     * */
    public static boolean isInteger(String strInput){
       
        boolean isInteger = false;
        
        if((null != strInput) && (strInput.matches(REGEX_INTEGER_PATTERN))){
            isInteger = true;
        }
        
        return isInteger;
    }
    
    /**
     * @author Henry
     * @description: Check if the year is leap year.
     * @param year:
     *              a integer of year.
     * @return boolean
     *              true: means the year is a leap year.
     *              false: means the year is not a leap year.
     * @version: 1.0.0.20170809
     * */
    public static boolean isLeapYear(int year){
        boolean isLeapYear = false;
        
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            isLeapYear = true;
        }
        
        return isLeapYear;
    }
    
    /**
     * @author Henry
     * @description: Check if the number is odd.
     * @param number:
     *              a number for checking.
     * @return boolean
     *              true: means the number is odd.
     *              false: means the number is not odd.
     * @version: 1.0.0.20170810
     * */
    public static boolean isOddNumber(int number){
        boolean isOddNumber = false;
        
        if(number % 2 != 0){
            isOddNumber = true;
        }
        
        return isOddNumber;
    }
    
}
