package com.henry.core_java_20160628;

import java.util.Scanner;

/**
 * @description accepts three integer values (a,b,c) and returns their sum.
 *              However, if one of the values is 13 then it does not count
 *              towards the sum and the next number also does not count. So for
 *              example, if b is 13, then both b and c do not count.
 * 
 */

public class GetLuckySum {

	private static final int BAD_NUM = 13;
	private static final int TOTAL_NUM = 3;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int arr[] = new int[TOTAL_NUM];
		for (int i = 0; i < TOTAL_NUM; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		System.out.println(getLuckySum(arr));
	}

	public static int getLuckySum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != BAD_NUM) {
				sum += arr[i];
			} else {
				i++;
			}
		}

		return sum;
	}

}
