package com.henry.util;

public class Utils {
    
    /* Follow variables for regular expression pattern. */
    public static final String REGEX_INTEGER_PATTERN = "[0-9]+";

    /**
     * @author Henry
     * @description: 
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
    
}
