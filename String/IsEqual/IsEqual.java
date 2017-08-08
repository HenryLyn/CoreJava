package com.henry.core_java_20170808;

import java.util.Scanner;

/**
 * 
 * @description read a two strings and one int value(N). check if Nth character
 *              of first String from start and Nth character of second String
 *              from end are same or not. If both are same return true else
 *              return false. Check need not be Case sensitive.
 * @author Henry
 * @version 0.0.1.20170808
 * 
 */
public class IsEqual {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String strFirst = input.nextLine();
        String strSecond = input.nextLine();
        int index = Integer.parseInt(input.nextLine());
        input.close();
        
        if(isEqual(strFirst,strSecond, index)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
        
    }
    
    private static boolean isEqual(String strFirst, String strSecond, int index){
        
        boolean isEqual = false;
        strFirst = strFirst.toLowerCase();
        strSecond = strSecond.toLowerCase();
        
        if(strFirst.charAt(index - 1) == strSecond.charAt(strSecond.length() - index)){
            isEqual = true;
        }
        
        return isEqual;
    }
    
}
