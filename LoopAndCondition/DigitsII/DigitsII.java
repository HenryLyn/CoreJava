package com.henry.core_java_20170705;

/**
 * 
 * @description read a non-negative integer n, compute the sum of its digits. If
 *              sum is greater than 9 repeat the process and calculate the sum
 *              once again until the final sum comes to single digit.Return the
 *              single digit.
 * @author Henry
 * @version 0.0.1.20170705
 * 
 */
import java.util.Scanner;

public class DigitsII {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int ret = getDigitSum(n);
        System.out.println(ret);
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        int tmpNum = number;
        while (true) {
            sum += tmpNum % 10;
            tmpNum /= 10;
            if ((tmpNum == 0) && (sum < 10)) {
                break;
            } else if (tmpNum == 0) {
                tmpNum = sum;
                sum = 0;
            }
        }
        return sum;
    }

}
